package boj;

import java.util.*;
import java.io.*;

public class BOJ_2493 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int[] top = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            top[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            if(stack.isEmpty()){
                stack.push(i);
                sb.append("0 ");
            }else{


                while(true){
                    if(stack.isEmpty()){
                        break;
                    }
                    if(top[stack.peek()]<=top[i]) {
                        stack.pop();
                    }else{
                        break;
                    }
                }

                if(stack.isEmpty()){
                    sb.append("0 ");
                }else{
                    sb.append(stack.peek()+1+" ");
                }

                stack.push(i);


            }

        }
        System.out.println(sb.toString());
    }
}
