import java.awt.Point;
import java.util.*;
import java.io.*;

public class Main {
    static int MAX_INT = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //0 : 이동 가능 , 1 : 벽
        //한 번 벽 부수고 이동 가능
        //(1,1)부터 시작
        //시작 + 끝 칸 포함
        //사방탐색
        //N : 행 M : 열
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[][][] distance = new int[2][N+1][M+1];   //현재 위치까지 오는데 걸리는 거리 + 벽을 부쉈는지 (이미 부쉈거나 or 안부쉈거나)
        // 0 : 안부숨 1 : 부숨
        //bfs 최단경로 찾으면 끝
        boolean[][][] visited = new boolean[2][N+1][M+1];

        //입력
        int[][] maps = new int[N+1][M+1];
        for (int i = 1; i < N+1; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                maps[i][j+1] = line.charAt(j) - '0';
                distance[0][i][j+1] = MAX_INT;
                distance[1][i][j+1] = MAX_INT;
            }
        }


        //첫 값 초기화
        distance[0][1][1] = 1;
        visited[0][1][1] = true;


        //탐색
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        Deque<Point> dq = new ArrayDeque<>();
        dq.add(new Point(1,1));

        while (!dq.isEmpty()) {
            Point p = dq.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nr = p.x + dr[i];
                int nc = p.y + dc[i];
                if (inRange(nr,nc,N,M)) {
                    //1.벽이 아닐 때
                    if (maps[nr][nc] == 0) {
                        //1-1 벽 안부수고 온 경우 확인
                        if (!visited[0][nr][nc] && distance[0][p.x][p.y] != MAX_INT) {
                            //값 갱신
                            distance[0][nr][nc] = distance[0][p.x][p.y] + 1;
                            dq.add(new Point(nr,nc));
                            visited[0][nr][nc] = true;

                        }
                        //1-2 이전에 벽을 부쉈던 경우 확인
                        if (!visited[1][nr][nc] && distance[1][p.x][p.y] != MAX_INT) {
                            //값 갱신
                            distance[1][nr][nc] = distance[1][p.x][p.y] + 1;
                            dq.add(new Point(nr,nc));
                            visited[1][nr][nc] = true;
                        }

                    }

                    //2. 벽 -> 부숴야됨
                    else {
                        if (!visited[1][nr][nc] && distance[0][p.x][p.y] != MAX_INT) {
                            distance[1][nr][nc] = distance[0][p.x][p.y] + 1;
                            dq.add(new Point(nr,nc));
                            visited[1][nr][nc] = true;
                        }
                    }
                }
            }
        }

        //탐색 끝
        //최소거리 선택

        //둘 다 도달 불가
        if (distance[0][N][M] == MAX_INT && distance[1][N][M] == MAX_INT) {
            System.out.println(-1);
        }

        //
        else if (distance[0][N][M] == MAX_INT) {
            System.out.println(distance[1][N][M]);
        }

        else if (distance[1][N][M] == MAX_INT) {
            System.out.println(distance[0][N][M]);
        }

        else {
            System.out.println(Math.min(distance[0][N][M], distance[1][N][M]));
        }

    }

    static boolean inRange(int r, int c, int N, int M) {
        return 0< r && r <= N && 0<c && c <= M;
    }
}
