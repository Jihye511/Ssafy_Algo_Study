package boj;

import java.util.*;
import java.io.*;

public class BOJ_19637 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] name = new String[N];
        int[] power = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            name[i] = st.nextToken();
            power[i] = Integer.parseInt(st.nextToken());

        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int character = Integer.parseInt(br.readLine());
            int left = 0;
            int right = N-1;
            while(left < right) {
                int mid =  (left + right) / 2;
                if(power[mid]<character) {
                    left = mid + 1;
                }else{
                    right = mid;
                }

            }

//            System.out.println(name[left]);
            sb.append(name[left] + "\n");
        }

        System.out.println(sb.toString());

    }
}
