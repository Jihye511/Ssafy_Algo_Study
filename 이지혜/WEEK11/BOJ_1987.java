import javax.print.attribute.standard.PrinterMessageFromOperator;
import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int x;
        int y;
        ArrayList<Character> list;

        public Node(int x, int y, ArrayList<Character> list) {
            this.x = x;
            this.y = y;
            this.list = list;
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            map[i] = str.toCharArray();
        }
        HashMap<Character, Integer> hash = new HashMap<>();
        hash.put(map[0][0], 1);
        boolean[][] v = new boolean[R][C];
        v[0][0]=true;
        dfs(1, map, hash,0,0,v);
        System.out.println(result);

    }
    static int result =0;
    public static void dfs(int cnt,char[][] map, HashMap<Character, Integer> hash, int x, int y, boolean[][] v){
        if(result<cnt){
            result =cnt;
        }
        for(int i =0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 || nx>= map.length || ny<0 || ny>=map[0].length ) continue;
            if(v[nx][ny]) continue;
            if(hash.containsKey(map[nx][ny])) continue;
            v[nx][ny] = true;
            hash.put(map[nx][ny],1);
            dfs(cnt+1, map, hash ,nx, ny,v);
            hash.remove(map[nx][ny]);
            v[nx][ny] = false;
        }
    }
}
