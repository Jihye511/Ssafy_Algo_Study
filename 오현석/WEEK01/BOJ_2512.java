import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int left = 0;
        int right = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, arr[i]); // 최대값 갱신
        }

        int target = Integer.parseInt(br.readLine());
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = sumValue(arr, mid);

            if (sum <= target) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }

    public static int sumValue(int[] arr, int cap) {
        int sum = 0;
        for (int value : arr) {
            sum += Math.min(value, cap);
        }
        return sum;
    }
}
