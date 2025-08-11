import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        char[] arr = br.readLine().trim().toCharArray();

        // 전부 같은 색이면 0
        boolean allSame = true;
        for (int i = 1; i < N; i++) {
            if (arr[i] != arr[0]) {
                allSame = false;
                break;
            }
        }
        if (allSame) {
            System.out.println(0);
            return;
        }

        int redCnt = 0, blueCnt = 0;
        for (char c : arr) {
            if (c == 'R') redCnt++;
            else blueCnt++;
        }

        int ans = Integer.MAX_VALUE;

        ans = Math.min(ans, redCnt - countFromStart(arr, 'R'));
        ans = Math.min(ans, redCnt - countFromEnd(arr, 'R'));
        ans = Math.min(ans, blueCnt - countFromStart(arr, 'B'));
        ans = Math.min(ans, blueCnt - countFromEnd(arr, 'B'));

        System.out.println(ans);
    }

    public static int countFromStart(char[] arr, char color) {
        int cnt = 0;
        for (char c : arr) {
            if (c == color) cnt++;
            else break;
        }
        return cnt;
    }

    public static int countFromEnd(char[] arr, char color) {
        int cnt = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == color) cnt++;
            else break;
        }
        return cnt;
    }
}
