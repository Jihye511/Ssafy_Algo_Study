import java.util.*;
import java.io.*;

public class Boj_1253_좋다 {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        //위치가 다르면 값이 같아도 다름
        int ans = 0;

        for (int target = 0; target < N; target++) {
            int left = 0;
            int right = N-1;

            while (left < right) {
                if (left == target) {
                    left++;
                    continue;
                }
                if (right == target) {
                    right--;
                    continue;
                }

                int temp = arr[left] + arr[right];
                if (temp == arr[target]) {
                    ans++;
                    break;
                }

                if (temp < arr[target]) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        System.out.println(ans);
    }
}
