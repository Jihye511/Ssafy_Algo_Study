import java.io.*;
import java.util.*;
public class Main {
    static int[][] map;
    static ArrayList<int[]> zero;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[9][9];
        zero = new ArrayList<>(); //0 좌표 모아두기
        for(int i =0; i<9; i++){
            String str = br.readLine();
            for(int j =0; j<9; ++j){
                map[i][j] = str.charAt(j) - '0';
                if(map[i][j] == 0){
                    zero.add(new int[]{i,j});
                }
            }
        }

        dfs(0);
    }
    public static void dfs(int depth){
        if(zero.size() == depth){
            for(int [] r : map){
                for(int i : r){
                    System.out.print(i);
                }
                System.out.println();
            }
            System.exit(0);
        }
        int n = zero.get(depth)[0];
        int m = zero.get(depth)[1];

        for(int i=1; i<=9; i++){
            if(check(n,m,i)){
                map[n][m] = i;
                dfs(depth+1);
                map[n][m]=0;
            }
        }
    }
    public static boolean check(int n, int m, int x){
        for(int i =0; i<9; i++){
            if(i == m) continue;
            if(map[n][i] == x) return false;
        }

        for(int  i=0; i<9; i++){
            if(i ==n )continue;
            if(map[i][m] ==x)return false;
        }

        int rowS = (n/3)*3;
        int colS = (m/3)*3;

        for(int i =rowS; i<rowS +3; i++){
            for(int j =colS; j<colS+3; j++){
                if(i==n && j ==m) continue;
                if(map[i][j] ==x) return false;
            }
        }
        return  true;
    }
}
