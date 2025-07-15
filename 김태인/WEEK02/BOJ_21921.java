import java.io.*;
import java.util.*;

public class Main {

    static int N, X, result;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

        }

        result = 0;
        int cnt = 1;
        int max = 0;
        for (int i = 0; i < X; i++) {
            max += arr[i];
        }

        result = max;

        for (int i = 0; i < N - X; i++) {
            max = max - arr[i] + arr[X + i];
            if(result == max) cnt += 1;
            else if (result < max){
                result = Math.max(result, max);
                cnt = 1;
            }
        }

        if(result != 0){
            System.out.println(result);
            System.out.println(cnt);
        }
        else{
            System.out.println("SAD");
        }
    }
}
