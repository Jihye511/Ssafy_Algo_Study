import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st= new StringTokenizer(br.readLine());
        Stack<int[]> stack = new Stack<>();
        for(int i =1; i<=N; i++){
            int top = Integer.parseInt(st.nextToken());
            while(!stack.empty()){
                if(stack.peek()[0] >top){
                    sb.append(stack.peek()[1] + " ");
                    break;
                }
                stack.pop();
            }
            if(stack.empty()){
                sb.append("0").append(" ");
            }
            stack.push(new int[] {top,i});
        }
        System.out.println(sb);
    }
}
