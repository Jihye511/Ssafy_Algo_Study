import java.io.*;
import java.util.*;
public class Main {
    static int N,M;
    static String[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new String[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map[i][0] = st.nextToken();
            map[i][1] = st.nextToken();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(br.readLine());
            int idx = binary(num);
            sb.append(map[idx][0]).append("\n");
        }
        System.out.println(sb);

    }
    public static int binary(int num){
        int lo = 0;
        int hi = N-1;
        while(lo<=hi){
            int mid =  lo+(hi-lo)/2;
            int com = Integer.parseInt(map[mid][1]);
            if(num>com){
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        }
        return lo;
    }
}
