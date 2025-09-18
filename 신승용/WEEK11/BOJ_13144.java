package 신승용.WEEK11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_13144 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine().trim());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long result = 0;
        Set<Integer> set = new HashSet<>();
        int right = 0;

        for (int left = 0; left < N; left++) {
            while (right < N && !set.contains(arr[right])) {
                set.add(arr[right]);
                right++;
            }

            result += (right - left);

            set.remove(arr[left]);
        }

        System.out.println(result);
    }
}
