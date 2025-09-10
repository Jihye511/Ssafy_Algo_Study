package boj;

import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.io.*;

public class BOJ_1863 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int[] buildings = new int[1000001];

        int N =  Integer.parseInt(br.readLine());

        st= new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q =  Integer.parseInt(st.nextToken());
        buildings[1] = q;
        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            buildings[a] = b;
            for(int j=p+1;j<a;j++){
                buildings[j] =  q;
            }
            p = a;
            q = b;
        }
        for(int i=p+1;i<1000001;i++){
            buildings[i] = q;
        }
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for(int i=1;i<1000001;i++){
          if(buildings[i]==0){
              ans += stack.size();
              stack.clear();
          }else if(!stack.isEmpty()){

                  if(stack.peek()<buildings[i]){
                      stack.push(buildings[i]);
                  }else{
                      while(!stack.isEmpty() && stack.peek() > buildings[i]){
                          stack.pop();
                          ans++;
                      }
                      if(!stack.isEmpty() && stack.peek()<buildings[i]){
                          stack.push(buildings[i]);
                      }
                      if(stack.isEmpty()){
                          stack.push(buildings[i]);
                      }
                  }


          }else{
              stack.push(buildings[i]);
          }

        }

        System.out.println(ans + stack.size());
    }


    //
    //
    //   O
    // O OOOOO
    // OOOOOOO
    // OOOOOOO
    // OOOOOOO
}
