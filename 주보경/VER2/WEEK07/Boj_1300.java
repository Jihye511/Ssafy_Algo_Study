import java.util.*;
import java.io.*;
import javax.swing.JCheckBox;

public class Boj_1300_K번째수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //A[i][j] = i×j
        //B -> 일차원 배열
        // N <= 10^5

        //0x0 0x1 0x2 0x3 1x0 1x1 1x2 1x3
        //i번째 행 -> ix0, ix1 ix2 .... ixN < X
        //ixP < X  -> P < (x/i)
        //i번째 행에서 X이하 개수 X / i
        //k번째 수
        //X이하인 수의 개수가 K인 X의 값
        //각 행마다 X보다 작은 수 개수 세기 -> K랑 비교

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        long start = 1; //인덱스 1부터 시작
        long end = K;
        while (start <= end) {
            long mid = (start + end) / 2;
            long res = check(mid, N);

            //X 이하가 K개 이상이 되는 가장 작은 X
            if (res < K) {
                //X보다 작은 수가 더 적음
                //X 증가
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        System.out.println(start);

    }

    static long check(long x, int N) {
        long cnt = 0;
        for (int i = 1; i <= N; i++) {
            cnt += Math.min(N, x / i);
        }

        return cnt;
    }
}
