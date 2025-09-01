import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String str = br.readLine();
            if (str.equals("end")) break;

            int ocnt = 0, xcnt = 0, dot = 0;
            for (int i = 0; i < 9; i++) {
                char c = str.charAt(i);
                if (c == 'X') xcnt++;
                else if (c == 'O') ocnt++;
                else if (c == '.') dot++;
            }

            if (!(xcnt == ocnt || xcnt == ocnt + 1)) {
                sb.append("invalid").append("\n");
                continue;
            }

            boolean xWin = checkingBinggo(str, 'X');
            boolean oWin = checkingBinggo(str, 'O');

            // 둘 다 승리 불가
            if (xWin && oWin) {
                sb.append("invalid").append("\n");
                continue;
            }

            if (xWin) {
                sb.append(xcnt == ocnt + 1 ? "valid" : "invalid").append("\n");
                continue;
            }
            if (oWin) {
                sb.append(xcnt == ocnt ? "valid" : "invalid").append("\n");
                continue;
            }

            // 승자 없음 → 보드가 꽉 차 있고 선공이 하나 더 많아야 함
            if (dot == 0 && xcnt == ocnt + 1) sb.append("valid").append("\n");
            else sb.append("invalid").append("\n");
        }
        System.out.print(sb);
    }

    public static boolean checkingBinggo(String str, char ch) {
        char[] arr = str.toCharArray();

        // 가로
        if (line(arr, 0,1,2, ch)) return true;
        if (line(arr, 3,4,5, ch)) return true;
        if (line(arr, 6,7,8, ch)) return true;

        // 세로
        if (line(arr, 0,3,6, ch)) return true;
        if (line(arr, 1,4,7, ch)) return true;
        if (line(arr, 2,5,8, ch)) return true;

        // 대각
        if (line(arr, 0,4,8, ch)) return true;
        if (line(arr, 2,4,6, ch)) return true;

        return false;
    }

    private static boolean line(char[] a, int i, int j, int k, char ch) {
        // 세 칸이 모두 ch인지 확인 ('.' 금지 포함)
        return a[i] == ch && a[j] == ch && a[k] == ch;
    }
}
