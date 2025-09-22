import java.util.*;
import java.io.*;

public class Boj_1027_고층건물 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] building = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            building[i] = Integer.parseInt(st.nextToken());
        }

        //양쪽 다 점검해야됨
        int ans = 0;
        for (int i = 0; i < N; i++) {
            //왼쪽
            int tempAns = 0;
            double minSlope = Integer.MAX_VALUE;
            for (int l = i-1; l >= 0; l--) {
                double slope = (building[l] - building[i]) / (double) (l-i);
                if (slope < minSlope) {
                    tempAns++;
                    minSlope = slope;
                }
            }


            //오른쪽
            double maxSlope = Integer.MAX_VALUE * -1;
            for (int r = i+1; r < N; r++) {
                double slope = (building[r] - building[i]) / (double) (r-i);
                if (slope > maxSlope) {
                    tempAns++;
                    maxSlope = slope;
                }
            }
            ans = Math.max(ans, tempAns);
        }
        System.out.println(ans);
    }
}
