import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N;
    static char[] start, target;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        start = br.readLine().toCharArray();
        target = br.readLine().toCharArray();

        int res1 = simulate(false);
        int res2 = simulate(true);
        
        int ans = -1;
        if (res1 >= 0 && res2 >= 0) ans = Math.min(res1, res2);
        else if (res1 >= 0) ans = res1;
        else if (res2 >= 0) ans = res2;

        System.out.println(ans);
    }
    
    static int simulate(boolean pressFirst) {
        char[] bulbs = start.clone();
        int count = 0;

        if (pressFirst) {
            press(bulbs, 0);
            count++;
        }

        for (int i = 1; i < N; i++) {
            if (bulbs[i - 1] != target[i - 1]) {
                press(bulbs, i);
                count++;
            }
        }

        for (int i = 0; i < N; i++) {
            if (bulbs[i] != target[i]) return -1;
        }
        return count;
    }
    static void press(char[] bulbs, int i) {
        for (int j = i - 1; j <= i + 1; j++) {
            if (0 <= j && j < N) {
                bulbs[j] = bulbs[j] == '0' ? '1' : '0';
            }
        }
    }
}