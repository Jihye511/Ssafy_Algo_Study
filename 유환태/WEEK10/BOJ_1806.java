import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] num = new int[N+1];
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int ans = Integer.MAX_VALUE;
        int sum = 0;

        while(left<=right && right <= N){
            if(sum < S){
                sum += num[right++];
            }else {
                ans = Math.min(ans, right-left);
                sum -= num[left++];
            }
        }
        System.out.println(ans==Integer.MAX_VALUE?0:ans);
    }
}