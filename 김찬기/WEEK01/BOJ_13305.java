package WEEK01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_13305 {
    public static BufferedReader br;
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] dist = new long[N-1];
        long[] price = new long[N];

        long sum = input(dist);

        input(price);

        long[] buy = new long[N];
        buy[0] = sum;
        int idx = 0;
        long min = price[idx];

        // 앞에서부터 가면서 싼곳 나오면 buy[idx], min 바꾸고 idx 갱신 / sum은 i 올리면서 변경
        // sum = 남은 가야 할 거리
        for (int i=1; i<price.length; ++i) {
            sum -= dist[i-1];
            if (min > price[i]) {
                buy[idx] -= sum;
                idx = i;
                buy[i] = sum;
                min = price[i];
            }
        }

//        System.out.println(Arrays.toString(buy));

        long result = 0;
        for (int i=0; i<buy.length; ++i) {
            result += buy[i] * price[i];
        }

        System.out.println(result);

    }

    public static long input(long[] arr) throws Exception {
        long sum = 0;

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<arr.length; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        return sum;
    }
}
