import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] sticks = new int[1001];
        int N = Integer.parseInt(br.readLine());

        int maxH = 0;
        int maxL = -1;

        int start = 1001;
        int end = 0;
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int loc = Integer.parseInt(st.nextToken());
            int hei = Integer.parseInt(st.nextToken());
            if (loc < start) start = loc;
            if (loc > end) end = loc;
            if (hei > maxH) {
                maxH = hei;
                maxL = loc;
            }
            sticks[loc] = hei;
        }

        int total = maxH;
        //왼쪽
        int tempMax = sticks[start];
        for (int i = start; i < maxL; i++) {
            //System.out.println(total);
            if (sticks[i] <= tempMax) {
                total+=tempMax;
            }
            else {
                total += sticks[i];
                tempMax = sticks[i];
            }
        }

        tempMax = sticks[end];
        for (int i = end; i > maxL; i--) {
            //System.out.println(total);
            if (sticks[i] <= tempMax) {
                total+=tempMax;
            }
            else {
                total += sticks[i];
                tempMax = sticks[i];
            }
        }

        System.out.println(total);
    }
}
