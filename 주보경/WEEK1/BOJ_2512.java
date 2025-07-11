import java.util.*;
import java.io.*;

public class Boj_2512_예산 {
    static List<Integer> budget;
    static int limit;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        budget = new ArrayList<>();
        int sum = 0;
        int min = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            int b = Integer.parseInt(st.nextToken());
            budget.add(b);
            sum += b;

            if (max < b) max = b;
        }

        limit = Integer.parseInt(br.readLine());

        if (limit >= sum) {
            int result = 0;
            for (int b : budget) {
                if (result < b) result = b;
            }

            System.out.println(result);
            return;
        }
        //탐색필요
        while (min <= max) {
            int middle = (min + max) / 2;

            if (check(middle) <= limit) {
                min = middle + 1;
            }

            else {
                max = middle - 1;
            }
        }
        System.out.println(max);
    }

    static long check(int num) {
        long sum = 0;
        for (int b : budget) {
            if (b > num) {
                sum += num;
            }
            else {
                sum += b;
            }
        }
        return sum;
    }

}
