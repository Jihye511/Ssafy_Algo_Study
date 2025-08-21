import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] power = new int[2*N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2*N; i++) {
            power[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;  //내구도 0인 벨트 개수

        int step = 0;
        int up = 0;
        int down = N-1;
        Deque<Integer> dq = new ArrayDeque<>();
        boolean[] visited = new boolean[N*2];

        while (cnt < K) {
            step++;

            //1. 컨베이어 이동
            up--;
            down--;
            if (up < 0) {
                up = 2 * N -1;
            }
            if (down < 0) {
                down = 2 * N -1;
            }

            //2. 로봇 이동
            int size = dq.size();
            for (int i = 0; i < size; i++) {
                int curr = dq.poll();
                visited[curr] = false;
                //내림여부
                if (curr == down) continue;

                //이동할 수 있는지 확인
                int next = curr + 1;
                if (next >= 2 * N) next = 0;
                if (power[next] > 0 && !visited[next]) {
                    if (next != down) {
                        dq.add(next);
                        visited[next] = true;
                    }
                    power[next]--;
                    if (power[next] == 0) cnt++;
                }
                else {
                    //도로 넣기
                    dq.add(curr);
                    visited[curr] = true;
                }
            }

            //3. 로봇 올리기
            if (power[up] > 0 && !visited[up]) {
                dq.add(up);
                visited[up] = true;
                power[up]--;
                if (power[up] == 0) cnt++;
            }
        }
        System.out.println(step);
    }
}
