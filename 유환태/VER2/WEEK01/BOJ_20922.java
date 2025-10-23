import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] num = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        int[] cnt = new int[100001];

        int ans = Integer.MIN_VALUE;

        int left = 0;
        int right = 0;

        while(right < N){
            if (cnt[num[right]] < K) {
                cnt[num[right]]++;
                right++;
                ans = Math.max(ans, right - left);
            } else {
                cnt[num[left]]--;
                left++;
            }
        }

        System.out.println(ans);
    }
}