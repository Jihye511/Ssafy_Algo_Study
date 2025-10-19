import java.util.*;
import java.io.*;

public class Main {

    static int H, W;
    static int[][] board;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        // 0: 공백, 1 : 벽, 2 : 물
        board = new int[H][W];
        st = new StringTokenizer(br.readLine());
        int[] heights = new int[W];
        for (int i = 0; i < W; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        int pos = 0;
        int result = 0;
        for (int i = 1; i < W; i++) {
            if(heights[pos] <= heights[i]){
                for (int j = pos + 1; j < i; j++) {
                    result += heights[pos] - heights[j];
                }
                pos = i;
            }
        }
        int end_pos = W - 1;

        if(pos < W){
            for (int i = W - 2; i >= pos ; i--) {
                if(heights[end_pos] <= heights[i]){
                    for (int j = end_pos; j > i; j--) {
                        result += heights[end_pos] - heights[j];
                    }
                    end_pos = i;
                }
            }
        }


        System.out.println(result);




    }
}
