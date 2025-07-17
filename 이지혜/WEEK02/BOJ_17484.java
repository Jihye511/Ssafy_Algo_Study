import java.io.*;
import java.util.*;
public class Main {
    static class Node{
        int x,y;
        int sum;
        int dir;

        public  Node(int x,int y, int sum, int dir){
            this.x=x;
            this.y=y;
            this.sum=sum;
            this.dir=dir;
        }
    }
    static int N,M;
    static int[][] map;
    static int[] dy = {-1,0,1}; //왼, 가운데, 오
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        Queue<Node> queue = new LinkedList<>();
        for(int i=0;i<N;i++){
            st = new  StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(i==0){
                    queue.offer(new Node(i,j,map[i][j],-1));
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            if(cur.x==N-1) {
                list.add(cur.sum);
                continue;
            }
            for(int i =0; i<3; i++){
                if(i == cur.dir)continue;
                int nx = cur.x +1;
                int ny = cur.y +dy[i];

                if(nx>=N || ny<0 || ny>=M)continue;

                queue.offer(new Node(nx,ny, cur.sum+map[nx][ny], i));
            }

        }
        Collections.sort(list);
        System.out.println(list.get(0));

    }
}
