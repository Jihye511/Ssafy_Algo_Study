package 신승용.WEEK08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_7682 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String token = br.readLine();
            if(token.equals("end")) break;
            boolean valid = true;

            // X, O의 갯수가 가능한 갯수인지 판별
            int cntX = 0;
            int cntO = 0;
            for (int i = 0; i < token.length(); i++) {
                if(token.charAt(i) == 'X') cntX++;
                if(token.charAt(i) == 'O') cntO++;
            }

            if(cntX != cntO && cntX != cntO + 1) {
                System.out.println("invalid");
                continue;
            }

            // 대각, 가로, 세로 중 하나
            if(!isFin(token, cntO, cntX)){
                System.out.println("invalid");
                continue;
            }

            System.out.println("valid");
        }
    }

    private static boolean isFin(String token, int cntO, int cntX) {
        char[][] map = new char[3][3];
        boolean XWin = false;
        boolean OWin = false;

        for (int i = 0; i < token.length(); i++) {
            int row = i / 3;
            int col = i % 3;
            map[row][col] = token.charAt(i);
        }

        //대각: 1행의 1열과 3열만 확인하면 됨
        if(map[0][0]!='.' && (map[0][0] == map[1][1]) && (map[1][1] == map[2][2])
        || (map[0][2] == map[1][1]) && (map[1][1] == map[2][0])){
            if(map[1][1] == 'X') XWin = true;
            else if(map[1][1] == 'O') OWin = true;
        }
        
        //가로: 1열만 확인하면 됨
        for (int i = 0; i < 3; i++) {
            if(map[i][0]!='.' && (map[i][0] == map[i][1]) && map[i][1] == map[i][2]){
                if(map[i][0] == 'X') XWin = true;
                else if(map[i][0] == 'O') OWin = true;
            }
        }


        //세로
        for (int i = 0; i < 3; i++) {
            if(map[0][i]!='.' && (map[0][i] == map[1][i]) && map[1][i] == map[2][i]){
                if(map[0][i] == 'X') XWin = true;
                else if(map[0][i] == 'O') OWin = true;
            }
        }

        if(XWin && OWin) return false;
        if(XWin) {
            return cntX == cntO + 1;
        }
        if(OWin) {
            if(cntO == cntX)
                return OWin;
        } 

        if(!XWin && !OWin){
            if(cntX + cntO == 9) return true;
        }

        return false;
    }
}

/**
 * .XX
 * X.X
 * OOO
 * 
 * 
 * XXO
 * OOX
 * XOX
 */