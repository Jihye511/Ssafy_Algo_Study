package boj;

import java.util.*;
import java.io.*;

public class BOJ_1253 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
                list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        int ans = 0;

        for(int i = 0; i < N; i++){
            int target = list.get(i);
            int left = 0;
            int right = N-1;
            while(left<right){
                if(list.get(left)+list.get(right)==target){
                    if(left!=i && right!=i){
                        ans++;
                        break;
                    }else if(left==i){
                        left++;
                    }else if(right==i){
                        right--;
                    }

                }else if(list.get(left)+list.get(right)>target){
                    right--;
                }else{
                    left++;
                }
            }
        }
        System.out.println(ans);
    }
}
