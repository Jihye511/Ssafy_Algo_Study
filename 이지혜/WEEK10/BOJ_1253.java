import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) a[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(a);
        int count = 0;

        for (int k = 0; k < N; k++) {
            long target = a[k]; 
            int l = 0, r = N - 1;

            while (l < r) {
                if (l == k) { l++; continue; }
                if (r == k) { r--; continue; }

                long sum = (long)a[l] + (long)a[r];
                if (sum == target) {
                    count++;
                    break;               
                } else if (sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        System.out.println(count);
    }
}
