import java.util.*;
import java.io.*;
public class Boj_14658_하늘에서별똥별이빗발친다 {
    static int N,M,L,K;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());  //가로
        N = Integer.parseInt(st.nextToken());  //세로
        L = Integer.parseInt(st.nextToken());  //트램펄린 한 변 길이
        K = Integer.parseInt(st.nextToken());  // 별똥별 개수

        int[][] stars = new int[K][2];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            stars[i] = new int[]{y, x};
        }

        //맵 저장하면 터짐
        //별똥별로 판단해야됨

        int ans = 0;
        //별똥별 몇 개 들어오는지 확인
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < K; j++) {
                int temp = 0;
                int start_r = stars[i][0];
                int end_r = start_r + L;
                int start_c = stars[j][1];
                int end_c = start_c + L;
                //해당 점 기준으로
                for (int[] s : stars) {
                    if (s[0] >= start_r && s[0] <= end_r && s[1] >= start_c && s[1] <= end_c) {
                        temp++;
                    }
                }

                ans = Math.max(temp, ans);
        }

        }

        System.out.println(K-ans);
    }
}
