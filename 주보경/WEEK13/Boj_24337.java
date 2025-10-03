import java.util.*;
import java.io.*;

public class Boj_24337_가희와탑 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int left = Integer.parseInt(st.nextToken());
        int right = Integer.parseInt(st.nextToken());

        //계단 두개
        //높이 중복돼도 됨
        Deque<Integer> dq = new ArrayDeque<>();

        //왼쪽 계단
        for (int i = 1; i < left; i++) {
            dq.add(i);
        }
        dq.add(Math.max(left,right));
        for (int i = right - 1; i > 0; i--) {
            dq.add(i);
        }

        if (dq.size() > N) {
            System.out.println(-1);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(dq.pollFirst()).append(" ");
        //1 채우기
        for (int i = 0; i < N - dq.size() - 1; i++) {
            sb.append(1).append(" ");
        }
        while (!dq.isEmpty()) {
            sb.append(dq.pollFirst()).append(" ");
        }

        System.out.println(sb);
    }
}
