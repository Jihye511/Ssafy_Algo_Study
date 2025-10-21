import java.util.*;
import java.io.*;
public class Boj_14916_거스름돈 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int k = num / 5;
        int cnt = 0;
        while (true) {
            //2로 나눌 수 있을 때까지
            if (k < 0) {
                System.out.println(-1);
                return;
            }

            int temp;

            if (k == 0) {
                temp = num;
            }
            else {
                temp = num - (5 * k);
            }

            if (temp % 2 == 0) {
                cnt = k + temp / 2;
                break;
            }

            k--;
        }

        System.out.println(cnt);
    }
}
