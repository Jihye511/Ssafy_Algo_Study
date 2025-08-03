import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] stock = new int[N];
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                stock[i] = Integer.parseInt(st.nextToken());
            }

            int tempMax = 0;
            long sum = 0;
            for (int i = N-1; i >= 0; i--) {
                if (stock[i] > tempMax) {
                    tempMax = stock[i];
                }
                else {
                    sum += (tempMax - stock[i]);
                }
            }

            System.out.println(sum);
        }
    }
}
