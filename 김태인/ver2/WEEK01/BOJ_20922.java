import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        int[] num = new int[100001];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        num[arr[left]]++;

        int cnt = 0;
        for (int right = 1; right < N; right++) {
            num[arr[right]]++;
            if(num[arr[right]] > K){
                while (num[arr[right]] > K){
                    num[arr[left]]--;
                    left++;
                }
            }
            else{
                cnt = Math.max(cnt, right - left + 1);
            }



        }

        System.out.println(cnt);

    }
}
