package paiza.poh3;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * Paiza Online Hackathon 3
 * 20���l���̃v���W�F�N�g���ł������I�ɉ�������ЂɐU����@���Z�o����
 * @author sakuramochi
 *
 */
public class Main {
	
	public static void main(String[] args) throws Exception {
		//�N���X����
		Main self = new Main();
		self.executeMain();
    }
	
	private void executeMain() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        final int m = Integer.parseInt(line); //1�s�ڂ��v���W�F�N�g���l��
        line = br.readLine();
        final int n = Integer.parseInt(line); //2�s�ڂ���������Ђ̐�
        
        int total_q = 0;
    	int total_r = 0;
    	int[] ary_q = new int[n];
    	int[] ary_r = new int[n];
        //��������Ђ̃��X�g���쐬(��������50���[�v)
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
        
        //�팸�ł���l��
        int reduce_q = total_q - m;
        
        /*
         * sum(q) <= reduce_q �𖞂������ŁAsum(r)���ő�ƂȂ�g�ݍ��킹�����߂�΁i�˃i�b�v�T�b�N���j�A
         * total_r - sum(r) ������
         */
        
        //dp[i][j] : i�Ԗڂ܂ł̉�Ђ��g��(=�Ȃ�)�ꍇ�́A�l��j�l�ȓ��ł̍ő�R�X�g
        int[][] dp = new int[n+1][reduce_q+1]; 
        for (int i = 0; i < n+1; i++) {
        	dp[i][0] = 0;
        }
        for (int j = 0; j < reduce_q+1; j++) {
        	dp[0][j] = 0;
        }
        
        //���I�v��@
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
