import java.util.*;
import java.io.*;

public class Main {

    static int N, K;
    static int[][] jewel;
    static int[] knapsack;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 0 : 무게, 1 : 가치
        jewel = new int[N][2];
        int weight, value;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            weight = Integer.parseInt(st.nextToken());
            value = Integer.parseInt(st.nextToken());
            jewel[i][0] = weight;
            jewel[i][1] = value;
        }



        knapsack = new int[K];
        for (int i = 0; i < K; i++) {
            knapsack[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewel, (arr1, arr2) ->{
            return arr1[0] - arr2[0];
        });
        Arrays.sort(knapsack);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long result = 0;
        int idx = 0;

        for (int i = 0; i < K; i++) {
            int cur_knapsack = knapsack[i];

            while (idx < N && jewel[idx][0] <= cur_knapsack){
                pq.add(jewel[idx][1]);
                idx++;
            }

            if(!pq.isEmpty()){
                result += pq.poll();
            }
        }


        System.out.println(result);

    }



}
