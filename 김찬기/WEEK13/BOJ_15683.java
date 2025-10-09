package WEEK13;

import java.io.*;
import java.util.*;

public class BOJ_15683 {
    static int min;
    static int[][] map;

    static class Camera {
        int r;
        int c;
        int rotate;
        List<Integer> directions;

        Camera(int r, int c, int rotate, List<Integer> d) {
            this.r = r;
            this.c = c;
            this.rotate = rotate;
            this.directions = d;
        }
    }

    static class Point {
        int r;
        int c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static List<Camera> cameraList;

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        min = Integer.MAX_VALUE;
        int cnt = 0;
        cameraList = new ArrayList<>();

        map = new int[N][M];
        for (int i=0; i<N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    ++cnt;
                }
                else if (map[i][j] != 6) {
                    setCamera(i, j, map[i][j]);
                }
            }
        }

        dfs(0, cnt);

        System.out.println(min);

    }

    public static void dfs(int idx, int cnt) {
        if (idx == cameraList.size()) {
            min = Math.min(min, cnt);
            return;
        }

        Camera curr = cameraList.get(idx);

        for (int i=0; i<curr.rotate; ++i) {
            int newCnt = 0;

            List<Point> list = new ArrayList<>();

            for (int j=0; j<curr.directions.size(); ++j) {
                int direct = (curr.directions.get(j) + i) % 4;
                int nextR = curr.r + dr[direct];
                int nextC = curr.c + dc[direct];

                while (isValid(nextR, nextC) && map[nextR][nextC] != 6) {
                    if (map[nextR][nextC] == 0) {
                        list.add(new Point(nextR, nextC));
                        map[nextR][nextC] = -1;
                        ++newCnt;
                    }
                    nextR += dr[direct];
                    nextC += dc[direct];
                }
            }
            // 다음 카메라
            dfs(idx+1, cnt - newCnt);

            for (Point p : list) {
                map[p.r][p.c] = 0;
            }

//			min = Math.min(min, cnt);
        }

    }

    public static void setCamera(int r, int c, int type) {
        List<Integer> list = new ArrayList<>();
        int rotate = 4;

        if (type == 1) {
            list.add(0);
        }
        else if (type == 2) {
            list.add(0);
            list.add(2);
            rotate = 2;
        }
        else if (type == 3) {
            list.add(0);
            list.add(1);
        }
        else if (type == 4) {
            list.add(0);
            list.add(1);
            list.add(2);
        }
        else {
            list.add(0);
            list.add(1);
            list.add(2);
            list.add(3);
            rotate = 1;
        }

        cameraList.add(new Camera(r, c, rotate, list));
    }

    public static boolean isValid(int r, int c) {
        return r >= 0 && r < map.length && c >= 0 && c < map[r].length;
    }
}
