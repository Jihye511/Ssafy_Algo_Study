import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        sb = new StringBuilder();
        String temp;
        for (int i = 0; i < N; i++) {
            temp = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = temp.charAt(j) - '0';
            }
        }

        dfs(0,0,N);
        System.out.println(sb);

    }

    public static void dfs(int x, int y, int size){
        if(check(x, y, size)){
            sb.append(map[x][y]);
            return;
        }

        sb.append('(');
        int half = size / 2;
        dfs(x, y, half);
        dfs(x, y + half, half);
        dfs(x + half, y, half);
        dfs(x + half, y + half, half);
        sb.append(')');


    }

    public static boolean check(int x, int y, int size){
        int check_num = map[x][y];
        for (int i = x; i < x + size ; i++) {
            for (int j = y; j < y + size; j++) {
                if(map[i][j] != check_num) return false;
            }
        }

        return true;
    }
}
