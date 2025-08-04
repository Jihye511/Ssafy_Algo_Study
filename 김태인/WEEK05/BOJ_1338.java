import java.util.*;
import java.io.*;

public class Main {

    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] num_ord = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            num_ord[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[N+1];

        for (int i = 1; i < N+1; i++) {
            int cnt = 0;
            for(int j = 0; j < N+1; j++){
                if(result[j] == 0 && cnt == num_ord[i]){
                    result[j] = i;
                    break;
                }
                else if(result[j] == 0){
                    cnt ++;
                }

            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);

    }
}
