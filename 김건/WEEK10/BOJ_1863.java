import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int n;
        Stack<Integer> que = new Stack<>();
        int c =0;

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            n=Integer.parseInt(st.nextToken());
            if (n==0) {
                que.clear();
                continue;
            }
            
            while (!que.isEmpty()&&que.peek()>n) que.pop();
            if (que.isEmpty()) {
                que.add(n);
                c++;
            }
            else {
                if (que.peek()!=n) {
                    que.add(n);
                    c++;
                }
            }
        }        

        System.out.println(c);
    }
}