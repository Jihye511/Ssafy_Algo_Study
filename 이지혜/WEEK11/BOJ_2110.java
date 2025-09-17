import java.io.*;
import java.util.*;

public class Main {
    static int N, C;
    static int[] x;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        x = new int[N];
        for (int i = 0; i < N; i++) x[i] = Integer.parseInt(br.readLine());
        Arrays.sort(x);

        int lo = 1;                       
        int hi = x[N - 1] - x[0];  
        int ans = 0;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2; 
            if (canPlace(mid)) {    
                ans = mid;
                lo = mid + 1;
            } else { 
                hi = mid - 1;
            }
        }
        System.out.println(ans);
    }

    static boolean canPlace(int d) {
        int count = 1;
        int last = x[0];
        for (int i = 1; i < N; i++) {
            if (x[i] - last >= d) {
                count++;
                last = x[i];
                if (count >= C) return true;
            }
        }
        return false;
    }
}
