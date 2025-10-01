import java.util.*;
import java.io.*;
class Node{
    int x;
    int y;
    int cnt;
    boolean crush;
    public Node(int x, int y, int cnt, boolean crush){
        this.x= x;
        this.y = y;
        this.cnt = cnt;
        this.crush = crush;
    }
}
public class Main {
    static int N,M;
    static int[][] map;
    static boolean[][][] visited;
    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M][2]; // [][][1] -> 벽 부숨 [][][0] -> 벽 안 부숨
        for(int i =0; i<N; i++){
            String str = br.readLine();
            for(int j =0; j<M; j++){
                map[i][j] = str.charAt(j)-'0';
            }
        }
        int v = bfs();
        System.out.println(v);

    }
    public static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 1, false));
        visited[0][0][0] = true;
        while (!q.isEmpty()) {
            Node node = q.poll();
            if(node.x ==N-1 && node.y == M-1) return node.cnt;
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];


                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if(map[nx][ny]==0){
                    if(!node.crush && !visited[nx][ny][0]) { //벽 부수기 x
                        visited[nx][ny][0] =true;
                        q.offer(new Node(nx,ny,node.cnt+1, false));
                    }
                    else if(node.crush && !visited[nx][ny][1]){// 벽 부순 상태로 방문
                        visited[nx][ny][1] =true;
                        q.offer(new Node(nx,ny,node.cnt+1, true));
                    }
                }else if(map[nx][ny] ==1 &&!node.crush){
                    visited[nx][ny][1] =true;
                    q.offer(new Node(nx,ny, node.cnt+1, true));

                }

            }
        }
        return -1;
    }

}
