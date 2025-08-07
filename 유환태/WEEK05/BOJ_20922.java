import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] cnt = new int[100001];
        st = new StringTokenizer(br.readLine());
        int len = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int right = 0;

        while(right < N){
           if (cnt[arr[right]] < K) {
                cnt[arr[right]]++;
                right++;
                len = Math.max(len, right - left);
            } else {
                cnt[arr[left]]--;
                left++;
            }
        }
        System.out.println(len);
        
    }
}