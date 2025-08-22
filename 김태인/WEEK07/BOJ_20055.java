import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static int[] durability;
    static boolean[] robot;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        durability = new int[2 * N];
        robot = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            durability[i] = Integer.parseInt(st.nextToken());
        }

        int step = 0;
        while (true) {
            step++;
            rotate();
            moveRobots();
            placeRobot();
            if (countZero() >= K) break;
        }

        System.out.println(step);
    }

    static void rotate() {
        int last = durability[2 * N - 1];
        for (int i = 2 * N - 1; i > 0; i--) {
            durability[i] = durability[i - 1];
        }
        durability[0] = last;

        for (int i = N - 1; i > 0; i--) {
            robot[i] = robot[i - 1];
        }
        robot[0] = false;
        robot[N - 1] = false;
    }

    static void moveRobots() {
        for (int i = N - 1; i > 0; i--) {
            if (robot[i - 1] && !robot[i] && durability[i] > 0) {
                robot[i] = true;
                robot[i - 1] = false;
                durability[i]--;
            }
        }
        robot[N - 1] = false;
    }

    static void placeRobot() {
        if (durability[0] > 0 && !robot[0]) {
            robot[0] = true;
            durability[0]--;
        }
    }

    static int countZero() {
        int cnt = 0;
        for (int d : durability) {
            if (d == 0) cnt++;
        }
        return cnt;
    }
}
