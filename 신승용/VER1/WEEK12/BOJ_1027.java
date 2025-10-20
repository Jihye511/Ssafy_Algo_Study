package 신승용.WEEK12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1027 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            int count = 0;

            for (int j = i-1; j >= 0; j--) {
                boolean visible = true;
                for (int k = j+1; k < i; k++) {
                    if((arr[k] - arr[i]) * ((long)j-(long)i) <= (arr[j]-arr[i]) * ((long)k-(long)i)){
                        visible = false;
                        break;
                    }
                }
                if(visible) count++;
            }

            for (int j = i + 1; j < N; j++) {
                boolean visible = true;
                for (int k = i + 1; k < j; k++) {
                    if ((arr[k] - arr[i]) * ((long)j - (long)i) >= (arr[j] - arr[i]) * ((long)k - (long)i)) {
                        visible = false;
                        break;
                    }
                }
                if (visible) count++;
            }

            answer = Math.max(answer, count);
        }

        System.out.println(answer);

    }
}
