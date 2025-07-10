import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static long[] dp1;
    static long[] dp2;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp1 = new long[N-1];
        dp2 = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N-1;i++){
            dp1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            dp2[i] = Integer.parseInt(st.nextToken());
        }

        long min = Integer.MAX_VALUE;
        long result = 0;
        for (int i = 0; i < N-1; i++) {
            if(min > dp2[i]){
                min = dp2[i];
            }

            result += min * dp1[i];
        }

        System.out.println(result);
    }
}
