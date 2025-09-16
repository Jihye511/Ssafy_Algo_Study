package boj;
import java.util.*;
import java.io.*;

public class BOJ_2110 {
    static int N, C;
    static int[] home;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        home = new int[N];
        for (int i = 0; i < N; i++) {
            home[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(home);
        long min = 0;
        long max = home[N-1] - home[0] + 1;

        while(min < max) {
            long mid = (min+max)/2;

            long count = 1;
            long index = home[0];

            for (int i = 1; i < N; i++) {
                if(mid+index<=home[i]) {
                    count++;
                    index = home[i];
                }
            }

            if(count >= C) {
                min = mid + 1;
            }else {
                max = mid;
            }

        }

        System.out.println(min-1);
    }

}
