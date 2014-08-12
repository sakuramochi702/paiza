package paiza.poh3;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * Paiza Online Hackathon 3
 * 20万人月のプロジェクトを最も効率的に下請け会社に振る方法を算出する
 * @author sakuramochi
 *
 */
public class Main {
	
	public static void main(String[] args) throws Exception {
		//クラス生成
		Main self = new Main();
		self.executeMain();
    }
	
	private void executeMain() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        final int m = Integer.parseInt(line); //1行目がプロジェクト総人月
        line = br.readLine();
        final int n = Integer.parseInt(line); //2行目が下請け会社の数
        
        int total_q = 0;
    	int total_r = 0;
    	int[] ary_q = new int[n];
    	int[] ary_r = new int[n];
        //下請け会社のリストを作成(たかだか50ループ)
        for (int i = 0; i < n; i++) {
        	String readLine = br.readLine();
            readLine = readLine.trim();
            String[] readLineArray = readLine.split(" ");
            int q = Integer.parseInt(readLineArray[0]);
            int r = Integer.parseInt(readLineArray[1]);
            total_q = total_q + q;
            total_r = total_r + r;
            ary_q[i] = q;
            ary_r[i] = r;
        }
        
        //削減できる人員
        int reduce_q = total_q - m;
        
        /*
         * sum(q) <= reduce_q を満たす中で、sum(r)が最大となる組み合わせを求めれば（⇒ナップサック問題）、
         * total_r - sum(r) が答え
         */
        
        //dp[i][j] : i番目までの会社を使う(=省く)場合の、人員j人以内での最大コスト
        int[][] dp = new int[n+1][reduce_q+1]; 
        for (int i = 0; i < n+1; i++) {
        	dp[i][0] = 0;
        }
        for (int j = 0; j < reduce_q+1; j++) {
        	dp[0][j] = 0;
        }
        
        //動的計画法
        for (int i = 1; i < n+1; i++) {
        	for (int j = 1; j < reduce_q+1; j++) {
        		if (ary_q[i - 1] <= j) {
        			dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-ary_q[i-1]] + ary_r[i-1]);
        		} else {
        			dp[i][j] = dp[i-1][j];
        		}
        	}
        }
        
        System.out.println(total_r - dp[n][reduce_q]);
	}
}
