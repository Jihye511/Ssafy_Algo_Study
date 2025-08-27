import java.util.*;
import java.io.*;

public class Boj_14719_빗물 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] height = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        int[] left = new int[W];
        int[] right = new int[W];

        left[0] = height[0];
        right[W-1] = height[W-1];
        for (int i = 1; i < W; i++) {
            left[i] = Math.max(left[i-1], height[i]);
            right[W-i-1] = Math.max(right[W-i], height[W-i-1]);
        }

        int sum = 0;
        for (int i = 0; i < W; i++) {
            sum += Math.max(0, Math.min(left[i], right[i]) - height[i]);
        }

        System.out.println(sum);

    }
}
