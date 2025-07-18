import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());  
        int K = Integer.parseInt(st.nextToken()); 
        char[] line = br.readLine().toCharArray(); 
        boolean[] used = new boolean[N]; 
        int count = 0;

        for (int i = 0; i < N; i++) {
            if (line[i] == 'P') {
                int start = Math.max(0, i - K);
                int end   = Math.min(N - 1, i + K);
                for (int j = start; j <= end; j++) {
                    if (line[j] == 'H' && !used[j]) {
                        used[j] = true;  
                        count++;
                        break;          
                    }
                }
            }
        }

        System.out.println(count);
    }
}
