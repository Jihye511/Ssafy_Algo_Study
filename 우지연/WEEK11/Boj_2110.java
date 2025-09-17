import java.io.*;
import java.util.*;

public class Main_2110 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int result = 0;
        int left = 0;
        int right = arr[N - 1] - arr[0]; // 최대 간격

        while (left <= right) {
            int cnt = 1;
            int cur = arr[0]; // 첫 번째 집부터 시작

            int mid = (right + left) / 2; //공유기 설치의 최소 간격

            for (int i = 1; i < N; i++) { // 첫 번째집은설치했으니 두번째집부터 시작
                if (arr[i] - cur >= mid) {
                    cnt++;
                    cur = arr[i]; // 현재 바라보는 인덱스(커서)를 설치한 집으로 이동
                }
            }

            if (cnt >= C) { // 공유기간의 거리를 적당히 설정해서 최소 C개만큼 설치했을 경우
                result = mid;

                // 좀더 좋은 결과값을 찾기위해 간격을 넓혀본다
                left = mid + 1;
            } else {
                // 결과값을 찾기위해 간격을 좁힌다
                right = mid - 1;
            }
        }
        System.out.println(result);
    }
}
