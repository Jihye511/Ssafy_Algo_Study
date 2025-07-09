package boj;
import java.util.*;
import java.io.*;

public class Main13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n =  Integer.parseInt(br.readLine());
        long[] distances  = new long[n-1];
        long[] costs =  new long[n];
        long min = Long.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n-1; i++) {
            distances[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            costs[i] =  Long.parseLong(st.nextToken());
            min = Math.min(min, costs[i]);
            if (i > 0 && costs[i] > min){
                costs[i] = min;
            }
        }
        long ans = 0;

        for (int i = 0; i < n-1; i++) {
            ans += costs[i] * distances[i];
        }

        System.out.println(ans);
    }
}
