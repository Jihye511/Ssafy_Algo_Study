
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] a = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        };

        int[] freq = new int[100001];
        int right = 0;
        long ans = 0;

        for (int l = 0; l < N; l++) {
            while (right < N && freq[a[right]] == 0) {
                freq[a[right]]++;
                right++;
            }

            ans += (right - l);
            freq[a[l]]--;
        }

        System.out.println(ans);
    }
}
