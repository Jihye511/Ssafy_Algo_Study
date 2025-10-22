import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static char[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map[i] = st.nextToken().toCharArray();
        }

        //상 하 좌 우 분할정복
        //한 사이클 하고 나올 때 괄호 추가
        System.out.println(divide(0,0,N));
    }

    static String divide(int r, int c, int n) {
        if (n == 1) {
            return String.valueOf(map[r][c]);
        }

        //전체가 같은지 확인
        boolean result = isEqual(r,c,n);
        if (result) {
            return String.valueOf(map[r][c]);
        }

        StringBuilder s = new StringBuilder();
        s.append("(");
        //오상
        s.append(divide(r,c,n/2));
        //왼상
        s.append(divide(r,c+n/2,n/2));
        //오하
        s.append(divide(r+n/2,c,n/2));
        //왼하
        s.append(divide(r+n/2,c+n/2,n/2));

        s.append(")");

        return s.toString();
    }

    static boolean isEqual(int r, int c, int n) {
        char p = map[r][c];
        for (int i = r; i < r+n; i++) {
            for (int j = c; j < c+n; j++) {
                if (map[i][j] != p) return false;
            }
        }
        return true;
    }
}
