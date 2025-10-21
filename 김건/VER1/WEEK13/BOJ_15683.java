package Baekjoon.WEEK13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15683 {
    static int[][] map;
    static int N;
    static int M;
    static int[] type = {0,1,2,3};
    static int Num;
    static List<CCTV> list;
    static int Ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        list = new ArrayList<>();
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j]!=0&&map[i][j]!=6) {
                    list.add(new CCTV(i,j,map[i][j]));
                }
            }
        }
        int sum = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (map[i][j]==0) sum++;
            }
        }
        Ans = sum;
        Num = list.size();
        perm(new int[Num], 0);
        System.out.println(Ans);


    }

    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};

    static class CCTV {
        int r, c, type;

        CCTV(int r, int c, int type) {
            this.r = r;
            this.c = c;
            this.type = type;
        }


    }

    public static void perm(int[] sel, int idx) {
        if (idx==Num) {
            draw(sel);
            return;
        }
        if (list.get(idx).type==2) {
            for (int i=0;i<2;i++) {
                sel[idx]=i;
                perm(sel, idx+1);
            }
        }
        else if (list.get(idx).type==5) {
            for (int i=0;i<1;i++) {
                sel[idx]=i;
                perm(sel, idx+1);
            }
        }
        else {
            for (int i=0;i<4;i++) {
                sel[idx]=i;
                perm(sel, idx+1);
            }
        }
    }

    public static void draw(int[] sel) {
        int idx = 0;
        int nr, nc, d;
        for (CCTV c:list) {
            switch (c.type) {
                case 1: {
                    d = sel[idx];
                    nr = c.r;
                    nc = c.c;
                    while (true) {
                        nr = nr+dr[d];
                        nc = nc+dc[d];
                        if (nr>=0&&nr<N&&nc>=0&&nc<M) {
                            if (map[nr][nc]!=6) {
                                if (map[nr][nc]==0) map[nr][nc]=-1;
                            }
                            else break;
                        }
                        else break;
                    }
                    break;
                }
                case 2: {
                    for (int i=0;i<=2;i+=2) {
                        d = (sel[idx]+i)%4;
                        nr = c.r;
                        nc = c.c;
                        while (true) {
                            nr = nr+dr[d];
                            nc = nc+dc[d];
                            if (nr>=0&&nr<N&&nc>=0&&nc<M) {
                                if (map[nr][nc]!=6) {
                                    if (map[nr][nc]==0) map[nr][nc]=-1;
                                }
                                else break;
                            }
                            else break;
                        }
                    }
                    break;
                }
                case 3: {
                    for (int i=0;i<2;i++) {
                        d = (sel[idx]+i)%4;
                        nr = c.r;
                        nc = c.c;
                        while (true) {
                            nr = nr+dr[d];
                            nc = nc+dc[d];
                            if (nr>=0&&nr<N&&nc>=0&&nc<M) {
                                if (map[nr][nc]!=6) {
                                    if (map[nr][nc]==0) map[nr][nc]=-1;
                                }
                                else break;
                            }
                            else break;
                        }
                    }
                    break;
                }
                case 4: {
                    for (int i=0;i<3;i++) {
                        d = (sel[idx]+i)%4;
                        nr = c.r;
                        nc = c.c;
                        while (true) {
                            nr = nr+dr[d];
                            nc = nc+dc[d];
                            if (nr>=0&&nr<N&&nc>=0&&nc<M) {
                                if (map[nr][nc]!=6) {
                                    if (map[nr][nc]==0) map[nr][nc]=-1;
                                }
                                else break;
                            }
                            else break;
                        }
                    }
                    break;
                }
                case 5: {
                    for (int i=0;i<4;i++) {
                        d = (sel[idx]+i)%4;
                        nr = c.r;
                        nc = c.c;
                        while (true) {
                            nr = nr+dr[d];
                            nc = nc+dc[d];
                            if (nr>=0&&nr<N&&nc>=0&&nc<M) {
                                if (map[nr][nc]!=6) {
                                    if (map[nr][nc]==0) map[nr][nc]=-1;
                                }
                                else break;
                            }
                            else break;
                        }
                    }
                    break;
                }
            }
            idx++;
        }
        int sum = 0;
        for (int i=0;i<N;i++) {
            for (int j=0; j<M; j++) {
                if (map[i][j]==0) sum++;
                else if (map[i][j]==-1) map[i][j]=0;
            }
        }
        Ans = Math.min(Ans, sum);
    }

    static class Pos {
        int r, c, d;
        Pos(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
}
