import java.io.*;
import java.util.*;
public class Main {
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String str =br.readLine();
            for(int j=0;j<n;j++){
                map[i][j] = str.charAt(j)-'0';
            }
        }

        divide(0,0,n);

        System.out.println(sb);
    }
    static StringBuilder sb = new StringBuilder();
    public static void divide(int startx, int starty, int len){
        int n = map[startx][starty];
        for(int i = startx;i<startx+ len;i++){
            for(int j = starty;j<starty+ len;j++){
                if(map[i][j] != n){
                    sb.append("(");
                    divide(startx, starty,len/2);
                    divide(startx, starty+len/2, len/2);
                    divide(startx+len/2, starty, len/2);

                    divide(startx+len/2, starty+len/2, len/2);
                    sb.append(")");
                    return;
                }
            }
        }
        sb.append(n);
    }
}
