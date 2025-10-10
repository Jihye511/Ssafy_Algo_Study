import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2169 {

	static int[] dx = { -1, 1, 0 };
	static int[] dy = { 0, 0, 1 };
	static int N;
	static int M;
	static int[][] area, temp, dp;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		area = new int[N][M];
		dp = new int[N][M];
		temp = new int[2][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());

			}
		}

		dp[0][0] = area[0][0];
		for (int i = 1; i < M; i++) {
			dp[0][i] = dp[0][i - 1] + area[0][i];
		}
		for (int i = 1; i < N; i++) {
			// 왼쪽+위쪽
			temp[0][0] = dp[i - 1][0] + area[i][0];
			for (int j = 1; j < M; j++) {
				temp[0][j] = Math.max(temp[0][j - 1], dp[i - 1][j]) + area[i][j];
			}
			// 오른+위쪽
			temp[1][M - 1] = dp[i - 1][M - 1] + area[i][M - 1];
			for (int j = M - 2; j >= 0; j--) {
				temp[1][j] = Math.max(temp[1][j + 1], dp[i - 1][j]) + area[i][j];
			}

			for (int j = 0; j < M; j++) {
				dp[i][j] = Math.max(temp[0][j], temp[1][j]);
			}

		}
		System.out.println(dp[N - 1][M - 1]);
	}

}
