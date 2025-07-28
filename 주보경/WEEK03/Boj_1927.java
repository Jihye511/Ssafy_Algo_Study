import java.util.*;
import java.io.*;

public class Boj_1927_최소힙 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (pq.isEmpty()) {
                    bw.write(String.valueOf(0));
                }
                else {
                    bw.write(String.valueOf(pq.poll()));
                }
                bw.newLine();
            }
            else {
                pq.add(num);
            }
        }
        bw.flush();
    }
}
