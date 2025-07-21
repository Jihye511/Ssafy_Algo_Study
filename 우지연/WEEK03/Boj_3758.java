import java.util.*;
import java.io.*;

//떼잉....

public class Main_3758 {

    static class Node implements Comparable<Node> {
        int cnt;
        int total;
        int time;
        boolean myTeam;

        public Node(int cnt, int total, int time, boolean myTeam) {
            this.cnt = cnt;
            this.total = total;
            this.time = time;
            this.myTeam = myTeam;
        }

        @Override
        public int compareTo(Node o) {
            if (this.total == o.total) {
                if (this.cnt == o.cnt) {
                    return Integer.compare(this.time, o.time);
                }
                return Integer.compare(this.cnt, o.cnt);
            }
            return Integer.compare(o.total, this.total);
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken()); // 팀의 개수
            int k = Integer.parseInt(st.nextToken()); // 문제의 개수
            int t = Integer.parseInt(st.nextToken()); //당신 팀의 ID
            int m = Integer.parseInt(st.nextToken()); // 로그 엔트리의 개수

            int[] count = new int[n + 1];
            int[][] score = new int[n + 1][k + 1];
            int[] time = new int[n + 1];
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int id = Integer.parseInt(st.nextToken());
                int num = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                count[id]++;
                score[id][num] = Math.max(s, score[id][num]);
                time[id] = i;
            }

            PriorityQueue<Node> pq = new PriorityQueue<>();
            for (int i = 1; i < n + 1; i++) {
                int sum = 0;
                for (int j = 1; j < k + 1; j++) {
                    sum += score[i][j];
                }
                pq.add(new Node(count[i], sum, time[i], i == t ? true : false));
            }

            int rank = 0;
            while (!pq.isEmpty()) {
                Node node = pq.poll();
                rank++;
                if (node.myTeam) {
                    break;
                }
            }

            sb.append(rank).append("\n");
        }

        System.out.println(sb);
    }

}
