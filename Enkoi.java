//enkoi1
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        final int N = Integer.parseInt(line);
        int total = 0;
        for (int i = 0; i < N; i++) {
            total += Integer.parseInt(br.readLine());
        }    
        System.out.println(total);
    }
}

//enkoi2
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        final int N = Integer.parseInt(br.readLine());
        int total = 0;
        for (int i = 0; i < N; i++) {
            String readLine = br.readLine();
            readLine = readLine.trim();
            String[] readLineArray = readLine.split(" ");
            int t = Integer.parseInt(readLineArray[0]);
            int s = Integer.parseInt(readLineArray[1]);
            int p = Integer.parseInt(readLineArray[2]);
            if (s < t) {
                total += (t - s) * p;
            }
        }
            
        System.out.println(total);
    }
}

//enkoi3
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstLine = br.readLine();
        String[] readLineArray = firstLine.split(" ");
        final int T = Integer.parseInt(readLineArray[0]);// 区間の長さ
        final int N = Integer.parseInt(readLineArray[1]);// コマの個数
        
        //要素数Tのリスト
        ArrayList<Integer> mArray = new ArrayList<Integer>();
        for (int i = 0; i < T; i++) {
            mArray.add(0);
        }
        
        int max = 0;
        for (int i = 0; i < N; i++) {
            String readLine = br.readLine();
            readLine = readLine.trim();
            if (i < T) {
                mArray.add(Integer.parseInt(readLine));
            } else {
                int num = Integer.parseInt(readLine);
                int first = mArray.get(0);
                mArray.remove(0);
                mArray.add(num);
                if (first < num) {
                    max = max - first + num;
                } else {
                    continue;
                }
            }
        }
            
        System.out.println(max);
    }
}