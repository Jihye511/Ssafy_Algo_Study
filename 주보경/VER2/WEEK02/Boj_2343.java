import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[] v;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        v = new int[N];
        int start = 0;
        int end = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            v[i] = Integer.parseInt(st.nextToken());
            start = Math.max(start, v[i]);
            end += v[i];
        }

        //최소 블루레이 크기 -> lower bound

        int ans = end;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (divide(mid)) { //size 크게
                ans = mid;
                end = mid -1;
            }
            else {
                start = mid + 1;
            }
        }
        System.out.println(ans);
    }

    public static boolean divide(int size) {
        //블루레이 크기 : size
        int cnt = 1;
        int temp = 0;
        for (int i = 0; i < N; i++) {
            if (temp + v[i] > size) {
                cnt++;
                temp = 0;
            }
            temp += v[i];
        }
        return cnt <= M;
    }
}
