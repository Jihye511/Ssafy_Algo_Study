import javax.swing.plaf.IconUIResource;
import java.io.*;
import java.util.*;

public class Main {
    static int N,K;
    static int[] count = new int[100001];
    static int[] parent = new int[100001];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Arrays.fill(count, 0);
        bfs();
        sb.append(count[K]).append("\n");
        int c = K;
        Stack<Integer> stack = new Stack<>();
        stack.add(K);
        while(c != N){
            stack.add(parent[c] );
            c = parent[c];
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);

    }
    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        count[N] = 0;
        parent[N] = N;
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == K) {
                return;
            }

            if (cur - 1 >= 0 && count[cur - 1] ==0) {
                count[cur - 1] = count[cur] + 1;
                parent[cur - 1] = cur;
                q.offer(cur - 1);
            }
            if (cur + 1 <= 100000 && count[cur + 1] ==0) {
                count[cur + 1] = count[cur] + 1;
                parent[cur + 1] = cur;
                q.offer(cur + 1);
            }

            if (cur * 2 <= 100000 && count[cur * 2] ==0) {
                count[cur * 2] = count[cur] + 1;
                parent[cur * 2] = cur;
                q.offer(cur * 2);
            }
        }
    }
}
