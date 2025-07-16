import java.io.*;
import java.util.*;

public class Main {

    static int N, K, result;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        result = 0;
        String str = br.readLine();
        boolean[] check = new boolean[N];
        for (int i = 0; i < N; i++) {
            if(str.charAt(i) == 'P'){
                for (int j = i - K; j <= i + K; j++) {
                    if (j < 0) continue;
                    else if (j >= N) break;
                    if(str.charAt(j) == 'H' && !check[j]){
                        check[j] = true;
                        result += 1;
                        break;
                    }
                }
            }
        }

        System.out.println(result);



    }
}
