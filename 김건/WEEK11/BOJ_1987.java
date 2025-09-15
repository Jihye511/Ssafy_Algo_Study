package Baekjoon.WEEK11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1987 {
    static int R, C, maxL=0;
    static int[][] arr;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[R][C];

        char[] charArr;
        for (int i=0; i<R; i++) {
            charArr = br.readLine().toCharArray();

            for (int j=0; j<C; j++) {
                arr[i][j] = charArr[j]-'A';
            }
        }

        dfs(0,0,1<<arr[0][0],1);
        if (maxL!=Integer.MAX_VALUE)
            System.out.println(maxL);
        else
            System.out.println(-1);
    }

    static void dfs(int r, int c, int v, int cnt) {
        boolean f = false;
        for (int d=0;d<4;d++) {
            int nr = r+dr[d];
            int nc = c+dc[d];

            if (nr>=0&&nr<R&&nc>=0&&nc<C) {
                if ((v&1<<arr[nr][nc])==0) {
                    f = true;
                    dfs(nr, nc, v|1<<arr[nr][nc], cnt+1);
                }
            }
        }

        if (!f) {
            maxL = Math.max(maxL, cnt);
        }
    }
}
