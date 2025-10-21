import java.util.*;
import java.io.*;

public class Main {

    static class Node implements Comparable<Node>{
        int now, cnt;
        Node(int now, int cnt){
            this.now = now;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o){
            return this.cnt - o.cnt;
        }
    }

    static int N, M;
    static HashMap<Integer, Integer> ladder = new HashMap<>();
    static HashMap<Integer, Integer> snake = new HashMap<>();
    static int[] board = new int[101];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int x, y, u, v;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            ladder.put(x, y);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            snake.put(u, v);
        }

        Arrays.fill(board, Integer.MAX_VALUE);

        int result = bfs();
        System.out.println(result);

    }

    public static int bfs(){
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(new Node(1, 0));

        Node temp;
        board[1] = 0;

        while(!q.isEmpty()){
            temp = q.poll();
            if (temp.now == 100) return temp.cnt;
            if(board[temp.now] < temp.cnt) continue;
            for (int i = 1; i < 7; i++) {
                if (temp.now + i > 100) break;
                if (temp.cnt >= board[temp.now + i]) continue;
                int next = temp.now + i;
                if (ladder.containsKey(next)) next = ladder.get(next);
                if (snake.containsKey(next)) next = snake.get(next);

                if (board[next] > temp.cnt + 1) {
                    board[next] = temp.cnt + 1;
                    q.add(new Node(next, temp.cnt + 1));
                }
            }



        }

        return 0;

    }
}
