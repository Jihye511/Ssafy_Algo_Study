import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[N];
        for(int i =0; i<N; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        long cnt = 0;
        int l = 0;
        int r = 0;
        int[] freq = new int[100001];
        while (l < N) {
            while (r < N && freq[a[r]] == 0) {
                freq[a[r]]++;
                r++;
            }
            cnt += (r - l);

            freq[a[l]]--;
            l++;
        }

        System.out.println(cnt);
    }
}
