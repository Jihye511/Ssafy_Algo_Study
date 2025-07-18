import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_19941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String str = br.readLine();
        int cnt = 0;
        boolean[] visited = new boolean[N];

        // 햄버거면 1, 사람이면 0
        for(int i = 0; i<N; i++){
            if(str.charAt(i) == 'H') continue;
            for(int j = i - K; j <= i + K; j++){
                if( j < 0 || j >= N ) continue;
                if(str.charAt(j) == 'H' && !visited[j]) {
                    visited[j] = true;
                    cnt ++;
                    // System.out.println(i + "가 " + j + "먹었음");
                    break;
                }
            }
        }

        System.out.println(cnt);

    }
}
