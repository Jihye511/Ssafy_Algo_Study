import java.util.*;
import java.io.*;

public class Main {

    static int N, D, K, C;
    static int[] sushi, cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        sushi = new int[N];
        cnt = new int[D+1];
        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int kind = 0;

        for (int i = 0; i < K; i++) {
            if(cnt[sushi[i]] == 0) kind++;
            cnt[sushi[i]]++;
        }

        int result = kind + (cnt[C] == 0 ? 1 : 0);

        for (int i = 1; i < N; i++) {
            cnt[sushi[i-1]]--;
            if(cnt[sushi[i-1]] == 0) kind--;

            int next = sushi[(i+K-1) % N];
            if (cnt[next] == 0) kind++;
            cnt[next]++;

            result = Math.max(result, kind + (cnt[C] == 0 ? 1 : 0));
        }

        System.out.println(result);

    }


}
