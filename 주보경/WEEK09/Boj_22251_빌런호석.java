import java.util.*;
import java.io.*;

public class Main {
    static int N, K, P, X;
    static int[][] segments;
    static int[][] changeCost;

    static int costBetween(int a, int b) {
        int sum = 0;
        for (int i = 0; i < K; i++) {
            int da = a % 10;
            int db = b % 10;
            a /= 10;
            b /= 10;
            sum += changeCost[da][db];
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        segments = new int[10][7];
        segments[0] = new int[] {1,1,1,1,1,1,0};
        segments[1] = new int[] {0,1,1,0,0,0,0};
        segments[2] = new int[] {1,1,0,1,1,0,1};
        segments[3] = new int[] {1,1,1,1,0,0,1};
        segments[4] = new int[] {0,1,1,0,0,1,1};
        segments[5] = new int[] {1,0,1,1,0,1,1};
        segments[6] = new int[] {1,0,1,1,1,1,1};
        segments[7] = new int[] {1,1,1,0,0,0,0};
        segments[8] = new int[] {1,1,1,1,1,1,1};
        segments[9] = new int[] {1,1,1,1,0,1,1};

        changeCost = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int diff = 0;
                for (int k = 0; k < 7; k++) {
                    if (segments[i][k] != segments[j][k]) diff++;
                }
                changeCost[i][j] = diff;
            }
        }

        int ans = 0;
        for (int floor = 1; floor <= N; floor++) {
            if (floor == X) continue;
            int total = costBetween(X, floor);
            if (total >= 1 && total <= P) ans++;
        }
        System.out.println(ans);
    }
}