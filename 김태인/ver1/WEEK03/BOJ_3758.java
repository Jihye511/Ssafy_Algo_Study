import java.io.*;
import java.util.*;

public class Main {

    static int T, n, k, id, m, rank;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            id = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            int[][] arr = new int[n + 1][k + 3];

            int i, j, s;
            // 0인덱스에 합 저장, k+1에 최종 제출 시간, k+2에 제출 횟수
            for (int i1 = 0; i1 < m; i1++) {
                st = new StringTokenizer(br.readLine());
                i = Integer.parseInt(st.nextToken());
                j = Integer.parseInt(st.nextToken());
                s = Integer.parseInt(st.nextToken());
                if (arr[i][j] < s) {
                    arr[i][0] = arr[i][0] - arr[i][j] + s;
                    arr[i][j] = s;
                }
                arr[i][k + 1] = i1;
                arr[i][k + 2]++;

            }

            rank = 1;

            for (int l = 1; l <= n; l++) {
                if (l == id) continue;

                if (arr[l][0] > arr[id][0]) rank++;
                else if (arr[l][0] == arr[id][0]) {
                    if (arr[id][k + 2] > arr[l][k + 2]) {
                        rank++;
                    } else if (arr[id][k + 2] == arr[l][k + 2]) {
                        if (arr[id][k + 1] > arr[l][k + 1]) rank++;
                    }
                }
            }

            System.out.println(rank);

        }
    }


}
