import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;

        for (int i = 0; i < N; i++) {
            int visible = 0;

            for (int j = i + 1; j < N; j++) {
                double slope = (double)(arr[j] - arr[i]) / (j - i);
                boolean canSee = true;

                for (int k = i + 1; k < j; k++) {
                    double heightOnLine = arr[i] + slope * (k - i);
                    if (arr[k] >= heightOnLine) { 
                        canSee = false;
                        break;
                    }
                }

                if (canSee) visible++;
            }

            for (int j = i - 1; j >= 0; j--) {
                double slope = (double)(arr[j] - arr[i]) / (j - i);
                boolean canSee = true;

                for (int k = j + 1; k < i; k++) {
                    double heightOnLine = arr[i] + slope * (k - i);
                    if (arr[k] >= heightOnLine) {
                        canSee = false;
                        break;
                    }
                }

                if (canSee) visible++;
            }

            result = Math.max(result, visible);
        }

        System.out.println(result);
    }
}
