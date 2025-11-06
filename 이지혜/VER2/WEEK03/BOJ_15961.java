import java.io.*;
import java.util.*;

public class Main {
    static int N, d, k, c;
    static int[] sushi;
    static int[] eaten;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        sushi = new int[N];
        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        eaten = new int[d + 1];
        int distinct = 0;

        for (int i = 0; i < k; i++) {
            if (eaten[sushi[i]] == 0) distinct++;
            eaten[sushi[i]]++;
        }

        int answer = distinct + (eaten[c] == 0 ? 1 : 0);

      
        for (int i = 1; i < N; i++) {
            int remove = sushi[i - 1];
            eaten[remove]--;
            if (eaten[remove] == 0) distinct--;

            int add = sushi[(i + k - 1) % N];
            if (eaten[add] == 0) distinct++;
            eaten[add]++;

            int withCoupon = distinct + (eaten[c] == 0 ? 1 : 0);
            if (withCoupon > answer) answer = withCoupon;
        }

        System.out.println(answer);
    }
}
