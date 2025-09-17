import java.util.*;
import java.io.*;

public class Main {
    static int N, C;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int[] home = new int[N];
        for (int i = 0; i < N; i++) {
            home[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(home);

        int left = 1;
        int right = home[N-1] - home[0];
        //집에 다 설치할 수 있는 최대 거리를 찾아야함
        //upper bound ?
        while (left <= right) {
            int middle = (left + right) / 2;
            int cnt = 1;
            int lastHome = home[0];
            //모두 설치
            for (int i = 1; i < N; i++) {
                if (lastHome + middle <= home[i]) {
                    cnt++;
                    lastHome = home[i];
                }
            }

            if (cnt < C) {
                //더 좁혀야됨
                right = middle - 1;
            }

            else {
                //더 넓혀야함
                left = middle + 1;
            }
        }

        System.out.println(right);
    }
}
