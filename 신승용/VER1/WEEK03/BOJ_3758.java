import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_3758 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 팀의 갯수
            int n = Integer.parseInt(st.nextToken());
            // 문제의 갯수
            int k = Integer.parseInt(st.nextToken());
            // 내 팀의 아이디
            int t = Integer.parseInt(st.nextToken())-1;
            // 로그 갯수
            int m = Integer.parseInt(st.nextToken());

            int[][] best = new int[n][k];
            int[] submit = new int[n];
            int[] last = new int[n];

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int team = Integer.parseInt(st.nextToken())-1;
                int no = Integer.parseInt(st.nextToken())-1;
                int score = Integer.parseInt(st.nextToken());

                best[team][no] = Math.max(best[team][no], score);
                submit[team]++;
                last[team] = i+1;
            }

            int[] total = new int[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < k; j++) {
                    total[i] += best[i][j];
                }
            }

            int answer = 1;
            for (int i = 0; i < n; i++) {
                if(i!=t){
                    if(total[i] > total[t] || (total[i] == total[t] && submit[i] < submit[t]) ||
                    (total[i] == total[t] && submit[i] == submit[t] && last[i] < last[t])){
                        answer++;
                    }
                }
            }
            
            System.out.println(answer);
        }
    }
}
