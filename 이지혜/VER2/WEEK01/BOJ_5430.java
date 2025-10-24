import javax.print.attribute.standard.PrintQuality;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t =0; t<T; t++){
            String str = br.readLine();
            int n = Integer.parseInt(br.readLine());

            String input = br.readLine();
            input = input.substring(1,input.length()-1);

            Deque<String> q = new ArrayDeque<>();

            if(!input.isEmpty()){
               for(String s : input.split(","))  q.offer(s);
            }

            boolean reverse = false; //true면 역으로 뽑아내기
            boolean check = false;//에러 확인용
            for(int i =0; i<str.length(); i++){
                char c = str.charAt(i);
                if(c=='R'){
                    reverse = !reverse;
                }else {
                    if(q.isEmpty()){
                        sb.append("error");
                        check = true;
                        break;
                    }else{
                        if(!reverse){
                            q.pollFirst();
                        }else{
                            q.pollLast();
                        }
                    }
                }
            }
            if(!check){
                sb.append("[");
                if(reverse){
                    while(!q.isEmpty()){
                        sb.append(q.pollLast());
                        if(q.size() >0) {
                            sb.append(",");
                        }
                    }
                }else{
                    while(!q.isEmpty()){
                        sb.append(q.poll());
                        if(q.size() >0){
                            sb.append(",");
                        }
                    }
                }
                sb.append("]");
            }
            sb.append("\n");

        }
        System.out.println(sb);
    }
}
