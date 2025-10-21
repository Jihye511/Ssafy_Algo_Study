package 신승용.WEEK13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15683 {
    static int N, M;
    static int[][] map;
    static List<Camera> cameraSet;
    static ArrayList<int[]> test;
    static int result;
    // angle이 0부터 기본, 1 증가 시 시계방향 90도
    static class Camera {
        int x, y, way, angle;
        Camera(int x, int y, int way, int angle){
            this.x = x;
            this.y = y;
            this.way = way;
            this.angle = angle;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        cameraSet = new ArrayList<>();
        test = new ArrayList<>();
        result = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]>0 && map[i][j]<6){
                    cameraSet.add(new Camera(i, j, map[i][j], 0));
                }
            }
        }

        permu(0, new int[cameraSet.size()]);

        System.out.println(result);
    }

    // 각 카메라의 앵글리스트 중복순열 (0~3) (0,0,0,0) , (0,0,0,1) ...
    static void permu(int depth, int[] sel){
        if(depth==cameraSet.size()){
            simulate(sel);
            return;
        }

        for (int i = 0; i < 4; i++) {
            sel[depth] = i;
            permu(depth+1, sel);
        }
    }

    static void simulate(int[] cameraAngles){
        for (int i = 0; i < cameraSet.size(); i++) {
            Camera target = cameraSet.get(0);
            cameraSet.remove(0);
            target.angle = cameraAngles[i];
            cameraSet.add(target);
        }

        boolean[][] visited = new boolean[N][M];
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]==6) visited[i][j] = true;
            }
        }

        for (Camera target : cameraSet) {
            markingCamera(target, visited);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visited[i][j]){
                    count++;
                }
            }
        }
        result = Math.min(count, result);
    }

    static void markingCamera(Camera camera, boolean[][] visited){
        if (camera.way == 1) {
            if (camera.angle == 0) {
                watchRight(camera, visited);
            } else if (camera.angle == 1) {
                watchUnder(camera, visited);
            } else if (camera.angle == 2) {
                watchLeft(camera, visited);
            } else if (camera.angle == 3) {
                watchUp(camera, visited);
            }
        } else if (camera.way == 2) {
            if (camera.angle == 0 || camera.angle == 2) {
                watchRight(camera, visited);
                watchLeft(camera, visited);
            } else if (camera.angle == 1 || camera.angle == 3) {
                watchUp(camera, visited);
                watchUnder(camera, visited);
            }
        } else if (camera.way == 3) {
            if (camera.angle == 0) {
                watchUp(camera, visited);
                watchRight(camera, visited);
            } else if (camera.angle == 1) {
                watchRight(camera, visited);
                watchUnder(camera, visited);
            } else if (camera.angle == 2) {
                watchUnder(camera, visited);
                watchLeft(camera, visited);
            } else if (camera.angle == 3) {
                watchLeft(camera, visited);
                watchUp(camera, visited);
            }
        } else if (camera.way == 4) {
            if (camera.angle == 0) {
                watchLeft(camera, visited);
                watchUp(camera, visited);
                watchRight(camera, visited);
            } else if (camera.angle == 1) {
                watchUp(camera, visited);
                watchRight(camera, visited);
                watchUnder(camera, visited);
            } else if (camera.angle == 2) {
                watchUnder(camera, visited);
                watchRight(camera, visited);
                watchLeft(camera, visited);
            } else if (camera.angle == 3) {
                watchUnder(camera, visited);
                watchLeft(camera, visited);
                watchUp(camera, visited);
            }
        } else if (camera.way == 5) {
            watchLeft(camera, visited);
            watchRight(camera, visited);
            watchUnder(camera, visited);
            watchUp(camera, visited);
        }
    }
    

    static void watchRight(Camera camera, boolean[][] visited){
        for (int i = camera.y; i < M; i++) {
            if(map[camera.x][i]==6){
                break;
            }
            visited[camera.x][i] = true;
        }
    }

    static void watchUnder(Camera camera, boolean[][] visited){
        for (int i = camera.x; i < N; i++) {
            if(map[i][camera.y]==6){
                break;
            }
            visited[i][camera.y] = true;
        }
    }

    static void watchLeft(Camera camera, boolean[][] visited){
        for (int i = camera.y; i >= 0; i--) {
            if(map[camera.x][i]==6){
                break;
            }
            visited[camera.x][i] = true;
        }
    }

    static void watchUp(Camera camera, boolean[][] visited){
        for (int i = camera.x; i >= 0; i--) {
            if(map[i][camera.y]==6){
                break;
            }
            visited[i][camera.y] = true;
        }
    }
}