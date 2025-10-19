import java.util.*;
import java.io.*;

public class Main {

    static class Node{
        int x, y, population;

        Node(int x, int y, int population){
            this.x = x;
            this.y = y;
            this.population = population;
        }
    }

    static int N, L, R;
    static boolean[][] visited;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        int x, y;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }

        }
        boolean flag = true;
        int result = 0;
        while (flag){

            flag = false;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(!visited[i][j]){
                        if(bfs(i, j)){
                            flag = true;
                        };

                    }
                }
            }
            if(flag) result++;
        }


        System.out.println(result);


    }

    public static boolean bfs(int x, int y){
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(new Node(x, y, map[x][y]));
        ArrayList<Node> group = new ArrayList<>();
        group.add(new Node(x, y, map[x][y]));
        visited[x][y] = true;

        Node temp;
        int nx, ny;
        boolean flag = false;
        while (!q.isEmpty()){
            temp = q.poll();
            for (int i = 0; i < 4; i++) {
                nx = temp.x + dx[i];
                ny = temp.y + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;

                if(check_population(temp.population, map[nx][ny])){
                    group.add(new Node(nx, ny, map[nx][ny]));
                    q.add(new Node(nx, ny, map[nx][ny]));
                    flag =true;
                    visited[nx][ny] = true;
                }

            }
        }

        int sum = 0;
        int group_len = group.size();
        for (Node node : group) {
            sum += node.population;
        }
        int avg = sum / group_len;
        for (Node node : group) {
            map[node.x][node.y] = avg;
        }


        return flag;
    }

    public static boolean check_population(int now, int next){
        int diff = Math.abs(now - next);

        return diff >= L && diff <= R;
    }
}
