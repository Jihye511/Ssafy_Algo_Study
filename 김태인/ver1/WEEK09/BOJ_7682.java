import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            String word = br.readLine();
            if(word.equals("end")) break;

            int[] result = count_o_x(word);
            int count_x = result[0];
            int count_o = result[1];

            if(count_x < count_o || count_x - count_o > 1) {
                sb.append("invalid").append("\n");
                continue;
            }

            int[] win = check_value(word);
            boolean x_win = win[0] == 1;
            boolean o_win = win[1] == 1;

            if(x_win && o_win){
                sb.append("invalid").append("\n");
                continue;
            }

            if(x_win && count_x == count_o + 1){
                sb.append("valid").append("\n");
                continue;
            }

            if(o_win && count_x == count_o){
                sb.append("valid").append("\n");
                continue;
            }

            if(!x_win && !o_win && count_x + count_o == 9){
                sb.append("valid").append("\n");
                continue;
            }

            sb.append("invalid").append("\n");
        }

        System.out.println(sb);
    }

    public static int[] count_o_x(String word){
        int count_x = 0;
        int count_o = 0;
        int[] result = new int[2];

        for (int i = 0; i < 9; i++) {
            if(word.charAt(i) == 'O') count_o++;
            else if (word.charAt(i) == 'X') count_x++;
        }

        result[0] = count_x;
        result[1] = count_o;

        return result;
    }

    public static int[] check_value(String word){
        int x_win = 0;
        int o_win = 0;

        // row
        for (int i = 0; i < 9; i += 3) {
            char c1 = word.charAt(i), c2 = word.charAt(i+1), c3 = word.charAt(i+2);
            if(check_row_col(c1, c2, c3)){
                if(c1 == 'X') x_win = 1;
                if(c1 == 'O') o_win = 1;
            }
        }

        // col
        for (int i = 0; i < 3; i++) {
            char c1 = word.charAt(i), c2 = word.charAt(i+3), c3 = word.charAt(i+6);
            if(check_row_col(c1, c2, c3)){
                if(c1 == 'X') x_win = 1;
                if(c1 == 'O') o_win = 1;
            }
        }

        // cross
        if(check_row_col(word.charAt(0), word.charAt(4), word.charAt(8))){
            if(word.charAt(0) == 'X') x_win = 1;
            if(word.charAt(0) == 'O') o_win = 1;
        }
        if(check_row_col(word.charAt(2), word.charAt(4), word.charAt(6))){
            if(word.charAt(2) == 'X') x_win = 1;
            if(word.charAt(2) == 'O') o_win = 1;
        }

        return new int[]{x_win, o_win};
    }

    public static boolean check_row_col(char x1, char x2, char x3){
        if(x1 == '.' || x2 == '.' || x3 == '.') return false;
        if(x1 == x2 && x2 == x3) return true;
        return false;
    }

}
