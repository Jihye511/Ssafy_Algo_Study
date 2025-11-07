import java.util.*;
import java.io.*;

public class Main {
    public static class Room implements Comparable<Room>{
        int start;
        int end;

        public Room(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Room r) {
            if (this.end == r.end) {
                return this.start - r.start;
            }
            return this.end - r.end;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Room> pq = new PriorityQueue<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Room r = new Room(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            pq.add(r);
        }

        int ans = 0;
        int end = 0;
        while (!pq.isEmpty()) {
            Room r = pq.poll();
            if (end > r.start) continue;
            end = r.end;
            ans++;
        }

        System.out.println(ans);
    }
}
