import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_19941 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[] arr = new char[N];
        boolean[] visited = new boolean[N];
        String token = br.readLine();

        for (int i = 0; i < N; i++) {
            arr[i] = token.charAt(i);
        }

        int count = 0;

        for (int i = 0; i < N; i++) {
            char cur = arr[i];
            if(cur == 'P'){
                for (int j = i-K; j <= i+K; j++) {
                    if(j>=0 && j<N && !visited[j] && arr[j]=='H'){
                        visited[j] = true;
                        count++;
                        break;
                    }
                }
            }
        }

        System.out.println(count);
    }
}