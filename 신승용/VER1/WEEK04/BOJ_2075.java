package 신승용.WEEK04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2075 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int target = Integer.parseInt(st.nextToken());
                if(pq.size() >= N){
                    int cmp = pq.poll();
                    if(cmp < target){
                        pq.offer(target);
                    } else {
                        pq.offer(cmp);
                    }
                } else {
                    pq.offer(target);
                }
            }
        }

        int answer = pq.poll();

        System.out.println(answer);
    }
}
