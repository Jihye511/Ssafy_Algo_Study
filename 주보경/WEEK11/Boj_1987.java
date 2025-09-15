import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int R,C;
    static char[][] map;
    static int ans;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        ans = 0;
        int mask = 1 << (map[0][0] - 'A');
        dfs(0,0,mask,1);
        System.out.println(ans);
    }

    static void dfs(int r, int c, int mask, int depth) {
        ans = Math.max(ans, depth);
        if (ans == 26) {
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (inRange(nr,nc))  {
                int id = map[nr][nc] - 'A';
                int bit = 1 << id;

                //아직 지나가지 않은 알파벳
                if ((mask & bit) == 0) {
                    dfs(nr,nc,mask | bit, depth + 1);
                }
            }
        }


    }

    static boolean inRange(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }
}
