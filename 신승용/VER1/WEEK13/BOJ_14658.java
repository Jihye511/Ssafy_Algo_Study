package 신승용.WEEK13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_14658 {
    static int L;
    static int K;
    static int[][] stars;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        stars = new int[K][2];
        Map<Integer, Integer> mapX = new HashMap<>();
        Map<Integer, Integer> mapY = new HashMap<>();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            stars[i][0] = Integer.parseInt(st.nextToken());
            stars[i][1] = Integer.parseInt(st.nextToken());

            mapX.put(stars[i][0], mapX.getOrDefault(stars[i][0], 0)+1);
            mapY.put(stars[i][1], mapY.getOrDefault(stars[i][1], 0)+1);
        }

        int answer = 0;

        for (int x1 : mapX.keySet()) {
            for (int y1 : mapY.keySet()) {
                int count = calCStarNum(x1, y1);
                if (count > answer) answer = count;
            }
        }

        System.out.println(K - answer);
    }

    static int calCStarNum(int x1, int y1) {
        int cnt = 0;
        int x2 = x1 + L;
        int y2 = y1 + L;

        for (int k = 0; k < K; k++) {
            int sx = stars[k][0];
            int sy = stars[k][1];
            if (x1 <= sx && sx <= x2 && y1 <= sy && sy <= y2) {
                cnt++;
            }
        }
        return cnt;
    }
}
