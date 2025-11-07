import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[1] == b[1]) return a[0]- b[0];
            else return a[1]-b[1];
        } );
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            pq.offer(new int[]{s, e});
        }
        int cnt=1;
        int[] cur = pq.poll();
        while (!pq.isEmpty()) {
            int[] next = pq.poll();
            if(cur[1] <=next[0]){
                cnt++;
                cur= next;
            }
        }
        System.out.println(cnt);
    }
}
