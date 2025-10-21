package 신승용.WEEK11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] map = new int[N];

        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(map);

        long high = map[N-1] - map[0];
        long low = 1;
        long answer = 1;

        while (low <= high) {
            long mid = (high + low) / 2;
            int count = 1;
            long prev = map[0];
            for (int i = 1; i < N; i++) {
                if(map[i] - prev >= mid){
                    count++;
                    prev = map[i];
                }
            }
            if(count >= C){
                low = mid+1;
                answer = mid;
            } else {
                high = mid-1;
            }
        }

        System.out.println(answer);

    }
}
