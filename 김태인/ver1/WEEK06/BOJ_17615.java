import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int result = Integer.MAX_VALUE;
    static char[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = br.readLine().toCharArray();

        result = Math.min(result, check_move('R', true));
        result = Math.min(result, check_move('R', false));
        result = Math.min(result, check_move('B', true));
        result = Math.min(result, check_move('B', false));

        System.out.println(result);

    }

    // dire == true : 오른족
    public static int check_move(char color, boolean dire){
        int idx = 0;
        if(dire){
            idx = N-1;
        }

        if (dire) {
            while (idx >= 0 && arr[idx] == color) idx--;
        } else {
            while (idx < N && arr[idx] == color) idx++;
        }
        
        int cnt = 0;
        if (dire) {
            for (int i = 0; i <= idx; i++) {
                if (arr[i] == color) cnt++;
            }
        } else {
            for (int i = idx; i < N; i++) {
                if (arr[i] == color) cnt++;
            }
        }

        return cnt;

    }


}
