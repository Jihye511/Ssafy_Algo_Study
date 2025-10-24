package boj;

import java.util.*;
import java.io.*;

public class BOJ_5430 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++){
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String numbers = br.readLine();

            numbers = numbers.substring(1, numbers.length()-1);

            String[] arr = numbers.split(",");
            Deque<String> dq = new ArrayDeque<>();
            for(String num : arr){
                if(!num.equals("")) dq.add(num);
            }
            boolean dir = true;
            boolean error = false;
            for(int i = 0; i < p.length(); i++){
                char op = p.charAt(i);

                if(op=='R'){
                    dir = !dir;
                }else if(op=='D'){
                    if(dq.isEmpty()){
                        error = true;
                        break;
                    }
                    if(dir){
                        dq.removeFirst();
                    }else{
                        dq.removeLast();
                    }
                }else{
                    error = true;
                    break;
                }
            }

            if(error){
                sb.append("error" + "\n");
            }else{
                sb.append("[");
                if(dir){
                    while(!dq.isEmpty()){
                        if(dq.size()==1){
                            sb.append(dq.pollFirst());
                        }else{
                            sb.append(dq.pollFirst()).append(",");
                        }
                    }
                }else{
                    while(!dq.isEmpty()){
                        if(dq.size()==1){
                            sb.append(dq.pollLast());
                        }else{
                            sb.append(dq.pollLast()).append(",");
                        }
                    }
                }

                sb.append("]\n");
            }

        }
        System.out.println(sb.toString());
    }
}
