import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        int left = 1;
        int right = K;
        int result = 0;
        while(left <= right){
            int mid = (left + right) / 2;
            int cnt = 0;
            for (int i = 1; i <= N ; i++) {
                cnt += Math.min(N, mid / i);
            }

            if(cnt >= K){
                result = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }

        System.out.println(result);

    }
}
