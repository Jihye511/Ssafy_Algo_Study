import java.util.*;
import java.io.*;

public class Boj_2138_전구와스위치 {
    static char[] curr;
    static char[] target;
    static int N;
    static int cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        curr = new char[N];
        target = new char[N];

        curr = br.readLine().toCharArray();
        target = br.readLine().toCharArray();


        //0번을 누르고 시작하거나, 아니거나
        cnt = Integer.MAX_VALUE;

        start(true);
        start(false);

        if (cnt == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else 
            System.out.println(cnt);
        
    }

    static void start(boolean isPressed) {
        int temp = 0;
        char[] copy = curr.clone();
        if (isPressed) {
            //바꿔야됨
            copy = press(0, copy);
            temp++;
        }

        for (int i = 1; i < N; i++) {
            if (copy[i-1] != target[i-1]) {
                copy = press(i, copy);
                temp++;
            }
        }

        if (Arrays.equals(copy, target))  cnt = Math.min(cnt, temp);
    }

    static char[] press(int idx, char[] copy) {
        if (idx > 0) copy[idx-1] = copy[idx-1] == '0' ? '1' : '0';
        copy[idx] = copy[idx] == '0' ? '1' : '0';
        if (idx < N-1) copy[idx+1] = copy[idx+1] == '0' ? '1' : '0';

        return copy;
    }
}
