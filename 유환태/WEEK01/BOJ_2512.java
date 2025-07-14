package boj;

import java.util.*;
import java.io.*;


public class Main2512 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N =  Integer.parseInt(br.readLine());

        int[] costs = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
        }

        int M =  Integer.parseInt(br.readLine());

        Arrays.sort(costs);

        int left = 0;
        int right = costs[costs.length - 1];

        while(left<=right){
            int mid = (left+right)/2;
            int sum = 0;
            for (int cost : costs) {
                sum += Math.min(cost, mid);
            }
            if(sum<=M){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }

        System.out.println(right);

    }
}
