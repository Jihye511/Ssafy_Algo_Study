import java.util.*;
import java.io.*;

public class Boj_1138_한줄로서기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] sort = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int t = Integer.parseInt(st.nextToken());

            int empty = 0;
            for (int j = 0; j < N; j++) {
                if (sort[j] == 0) {
                    empty++;
                    if (empty == t+1) {
                        sort[j] = i+1;
                        break;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int s : sort) {
            sb.append(s + " ");
        }
        System.out.println(sb);
    }
}
