package 신승용.VER2.WEEK01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1992 {
    static StringBuilder sb;
    static int[][] map;
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String token = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(token.charAt(j)+"");
            }
        }

        dfs(N,0,0);

        System.out.println(sb.toString());
    }

    static void dfs(int C, int sX, int sY){
        if(C==1) {
            sb.append(map[sX][sY]);
            return;
        }
        boolean valid = true;
        int flag = map[sX][sY];

        a:for (int i = sX; i < sX + C; i++) {
            for (int j = sY; j < sY + C; j++) {
                if(map[i][j] != flag){
                    valid = false;
                    break a;
                }
            }
        }

        if(valid){
            sb.append(flag);
            return;
        }

        sb.append("(");
        dfs(C/2, sX, sY);
        dfs(C/2, sX, sY+C/2);
        dfs(C/2, sX+C/2, sY);
        dfs(C/2, sX+C/2, sY+C/2);
        sb.append(")");
    }
}
