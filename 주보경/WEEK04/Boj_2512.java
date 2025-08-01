import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        StringTokenizer st;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                pq.add(-1 * Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 0; i < N-1; i++) {
            pq.poll();
        }

        System.out.println(pq.poll() * -1);

    }
}
