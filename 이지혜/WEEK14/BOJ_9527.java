import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long ans = countOnesUpTo(B) - countOnesUpTo(A - 1);
        System.out.println(ans);
    }

    static long countOnesUpTo(long n) {
        if (n <= 0) return 0;
        long total = 0;

        for (int bit = 0; bit < 61; bit++) {
            long block = 1L << bit;
            long cycle = block << 1;
            long fullCycles = (n + 1) / cycle;
            long rem = (n + 1) % cycle;

            total += fullCycles * block + Math.max(0L, rem - block);
        }
        return total;
    }
}
