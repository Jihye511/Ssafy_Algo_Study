import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] h = new int[W];
        st = new StringTokenizer(br.readLine());
        for(int i =0;i<W; i++){
            h[i] = Integer.parseInt(st.nextToken());
        }
        int[] leftmax = new int[W];
        int[] rightmax = new int[W];

        leftmax[0] = h[0];
        for(int i =1; i<W; i++){
            leftmax[i] = Math.max(leftmax[i-1],h[i]);

        }
        rightmax[W-1] = h[W-1];
        for(int i =W-2; i>=0; i--) {
            rightmax[i] = Math.max(rightmax[i+1] , h[i]);
        }
        int water = 0;
        for(int i =0; i<W; i++){
            int level = Math.min(leftmax[i] , rightmax[i]);
            if(level > h[i]) water += (level-h[i]);
        }
        System.out.println(water);
    }
}
