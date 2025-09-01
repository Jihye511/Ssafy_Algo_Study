import java.util.*;
import java.io.*;

public class Boj_7682_틱택토 {
    static char[][] tic;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         while (true) {
             tic = new char[3][3];
             int xCount = 0;
             int oCount = 0;

             int idx = 0;

             String input = br.readLine();
             if (input.equals("end")) break;
             for (int i = 0; i < 3; i++) {
                 for (int j = 0; j < 3; j++) {
                     char c = input.charAt(idx++);
                     if (c == 'X') xCount++;
                     if (c == 'O') oCount++;
                     tic[i][j] = c;
                 }
             }

             if (oCount > xCount) {
                 System.out.println("invalid");
                 continue;
             }

             if (xCount - oCount > 1) {
                 System.out.println("invalid");
                 continue;
             }

             //X 승리
             if (xCount - oCount == 1) {
                 if (end('X') && !end('O')) {
                     System.out.println("valid");
                     continue;
                 }
             }

             //O 승리
             if (xCount == oCount) {
                 if (end('O') && !end('X')) {
                     System.out.println("valid");
                     continue;
                 }
             }

             if (xCount + oCount == 9 && !end('X') && !end('O')) {
                 System.out.println("valid");
                 continue;
             }

             System.out.println("invalid");
         }
    }

    static boolean end(char curr) {
        //가로
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tic[i][j] == curr) {
                    cnt++;
                }
            }
            if (cnt == 3) {
                return true;
            }
            else {
                cnt = 0;
            }
        }

        //세로
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tic[j][i] == curr) {
                    cnt++;
                }
            }
            if (cnt == 3) {
                return true;
            }
            else {
                cnt = 0;
            }
        }

        //대각선
        if (tic[0][0] == tic[1][1] && tic[1][1] == tic[2][2]  && tic[2][2] == curr) return true;
        if (tic[0][2] == tic[1][1] && tic[1][1] == tic[2][0]  && tic[2][0] == curr) return true;

        return false;
    }
}
