package boj;

import java.util.*;
import java.io.*;

public class BOJ_13144 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] num = new int[N];
        int[] check = new int[100001];
        for(int i=0;i<N;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        long ans = 0;
        while(true){
            if(right==N){
                ans +=  (right - left);
                left++;
                if(left==N){
                    break;
                }
            }else if(check[num[right]]==0){
                check[num[right]]++;
                right++;
            }else{
                ans +=  (right - left);
                check[num[left]]=0;
                left++;
            }
        }
        System.out.println(ans);
    }
}
