package WEEK02;

import java.io.*;
import java.util.*;

public class BOJ_21921 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i=0; i<N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int i=0; i<X; ++i) {
            sum += arr[i];
        }

        int max = sum;
        int cnt = 1;
        for (int i=0; i<N-X; ++i) {
            sum -= arr[i];
            sum += arr[i+X];

            if (max < sum) {
                max = sum;
                cnt = 1;
            }
            else if (max == sum) {
                ++cnt;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n").append(cnt);
        System.out.println(sb);

    }
}
