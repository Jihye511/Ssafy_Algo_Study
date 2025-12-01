import java.util.*;

class Solution {
    static class Node {
        int x, y, dist;
        Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        map = new int[102][102];

        for(int[] square : rectangle) {
            paint(square[0] * 2, square[1] * 2, square[2] * 2, square[3] * 2);
        }

        int answer = move(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
        return answer / 2;
    }

    public static void paint(int x1, int y1, int x2, int y2) {
        for(int x = x1; x <= x2; x++) {
            for(int y = y1; y <= y2; y++) {
                if(map[x][y] == 2) continue;

                if(x == x1 || x == x2 || y == y1 || y == y2) {
                    if(map[x][y] != 2) map[x][y] = 1;
                } else {
                    map[x][y] = 2;
                }
            }
        }
    }

    public static int move(int start_x, int start_y, int end_x, int end_y) {
        Queue<Node> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[102][102];

        q.add(new Node(start_x, start_y, 0));
        visited[start_x][start_y] = true;

        while(!q.isEmpty()) {
            Node now = q.poll();

            if(now.x == end_x && now.y == end_y) {
                return now.dist;
            }

            for(int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if(check(nx, ny) || map[nx][ny] != 1 || visited[nx][ny]) continue;

                visited[nx][ny] = true;
                q.add(new Node(nx, ny, now.dist + 1));
            }
        }
        return 0;
    }

    public static boolean check(int nx, int ny) {
        return nx < 0 || nx > 100 || ny < 0 || ny > 100;
    }
}
