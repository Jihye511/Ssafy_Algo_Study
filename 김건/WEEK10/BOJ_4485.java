import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_4485 {
    static int N;
    static int[][] arr;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] v;
    static PriorityQueue<Pos> que = new PriorityQueue<>();

    

    static class Pos implements Comparable<Pos> {
        int r, c, d;
        
        Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
        
        Pos(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
        
        public int compareTo(Pos o) {
            return Integer.compare(this.d, o.d);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int c=0;
        while (true) {
            c++;
            N = Integer.parseInt(br.readLine());
            if (N==0) break;
            arr=new int[N][N];
            v=new int[N][N];
            for (int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    v[i][j]=Integer.MAX_VALUE;
                }
            }
            sb.append("Problem "+c+": ").append(bfs()).append('\n');
        }
        System.out.print(sb.toString());
    }
    
    static int bfs() {
        que.clear();
        
        que.add(new Pos(0,0,arr[0][0]));
        while (!que.isEmpty()) {
            Pos cur = que.poll();
            if (v[cur.r][cur.c]<cur.d) continue;
            if (cur.r==N-1&&cur.c==N-1) return cur.d;
            for (int i=0; i<4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                
                if (nr>=0&&nr<N&&nc>=0&&nc<N&&v[nr][nc]>arr[nr][nc]+cur.d) {
                    que.add(new Pos(nr, nc, cur.d+arr[nr][nc]));
                    v[nr][nc]=arr[nr][nc]+cur.d;
                }
            }
        }
        return 0;
    }
}
