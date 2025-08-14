package 신승용.WEEK06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int answer = 0;

        int[] dx = {-1, 1, 2};

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{N, 0});
        boolean[] visited = new boolean[100_001];
        visited[N] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curNum = cur[0];
            int count = cur[1];

            if(curNum == K){
                answer = count;
                break;
            }

            for (int i = 0; i < dx.length; i++) {
                int nextNum = 0;
                if(i != dx.length-1){
                    nextNum = curNum + dx[i];
                } else {
                    nextNum = curNum * dx[i];
                }

                if(nextNum > 100_000) continue;
                if(nextNum < 0) continue;

                if (!visited[nextNum]) {
                    queue.offer(new int[]{nextNum, count+1});
                    visited[nextNum] = true;
                }
            }
        }

        System.out.println(answer);
    }
}
