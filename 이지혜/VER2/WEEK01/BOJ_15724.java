import java.io.*;
import java.util.*;
public class Main {
    static int[][] map;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new  StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        for(int i=1;i<=N;i++){
            st= new  StringTokenizer(br.readLine());
            for(int j=1;j<=M;j++){
                int n  =Integer.parseInt(st.nextToken());
                map[i][j] = map[i][j-1] + map[i-1][j] - map[i-1][j-1] + n;
            }
        }
        int K = Integer.parseInt(br.readLine());
        for(int i=0;i<K;i++){
            st = new  StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int value = map[x2][y2] - map[x2][y1-1] - map[x1-1][y2] + map[x1-1][y1-1];
            sb.append(value).append("\n");
        }
        System.out.println(sb);

    }
}
