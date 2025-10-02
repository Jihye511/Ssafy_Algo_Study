import java.util.*;
import java.io.*;


// a + b <= 건물의 개수 + 1
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if(a+b > N + 1){
            System.out.println("-1");
        }else{
            int[] h = new int[a+b-1];
            int cnt= N - h.length;
            if(a >= b){
                for(int i = 0; i < a; i++){
                    h[i] = i + 1;
                }
                for(int i= h.length-1;i>=a;i--){
                    h[i] = h.length - i;
                }
            }else{
                for(int i= h.length-1;i>(h.length-1)-b;i--){
                    h[i] = h.length - i;
                }

                for(int i = 0; i <= (h.length-1)-b; i++){
                    h[i] = i + 1;
                }

            }
            StringBuilder sb = new StringBuilder();
            sb.append(h[0] + " ");
            for(int i = 0; i < cnt; i++){
                sb.append("1 ");
            }
            for(int i = 1; i < h.length; i++){
                sb.append(h[i] + " ");
            }
            System.out.println(sb.toString());
        }
    }
}
