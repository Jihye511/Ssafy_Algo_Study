import java.io.*;
import java.util.*;

public class Main_20055 {
    static int N, K;
    static int[] container;          // 내구도
    static boolean[] robot;  // 로봇 위치
    static int zeroCount = 0;
    static int step = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        container = new int[2 * N];
        robot = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            container[i] = Integer.parseInt(st.nextToken());
        }

        while (zeroCount < K) {
            step++;

            // 1. 벨트와 로봇 회전
            rotate();

            // 2. 로봇 이동
            moveRobots();

            // 3. 올리는 위치에 로봇 올리기
            putRobot();

            // 4. 내구도 0칸 수 확인 → 종료는 while 조건에서
        }

        System.out.println(step);
    }

    static void rotate() {
        // 내구도 회전
        int last = container[2 * N - 1];
        for (int i = 2 * N - 1; i > 0; i--){
            container[i] = container[i - 1];
        }
        container[0] = last;

        // 로봇 회전
        for (int i = N - 1; i > 0; i--) {
            robot[i] = robot[i - 1];
        }
        robot[0] = false;      // 올리는 위치에는 로봇 없음으로 초기화
        robot[N - 1] = false;  // 내리는 위치 로봇 제거
    }

    static void moveRobots() {
        for (int i = N - 2; i >= 0; i--) {
            if (robot[i] && !robot[i + 1] && container[i + 1] > 0) {
                robot[i] = false;
                robot[i + 1] = true;
                container[i + 1]--;
                if (container[i + 1] == 0) {
                    zeroCount++;
                }
            }
        }
        robot[N - 1] = false; // 내리는 위치는 항상 제거
    }

    static void putRobot() {
        if (!robot[0] && container[0] > 0) {
            robot[0] = true;
            container[0]--;
            if (container[0] == 0) {
                zeroCount++;
            }
        }
    }
}
