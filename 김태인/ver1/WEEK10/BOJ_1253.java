import java.util.*;
import java.io.*;

public class Main {

    static int N, result;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        if(N == 1) {
            System.out.println(0);
            System.exit(0);
        }

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        result = 0;

        for (int i = 0; i < N; i++) {
            if(isgood(arr[i], i)){
                result++;
            }
        }

        System.out.println(result);

    }

    public static boolean isgood(int target, int idx){
        int left = 0;
        int right = N - 1;

        while (left < right){
            if(left == idx){
                left++;
                continue;
            }

            if(right == idx){
                right--;
                continue;
            }

            int sum = arr[left] + arr[right];

            if(sum == target) return true;
            else if(sum < target) left++;
            else right--;
        }

        return false;
    }

}
