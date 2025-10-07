import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1943 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		StringBuilder sb = new StringBuilder();
		for (int test = 0; test < 3; test++) {
			int N = Integer.parseInt(br.readLine());
			int[] v = new int[N];
			int[] c = new int[N];

			int sum = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				v[i] = Integer.parseInt(st.nextToken());
				c[i] = Integer.parseInt(st.nextToken());
				sum += v[i] * c[i];

			}
			if (sum % 2 == 1) {
				sb.append("0\n");
				continue;
			}

			int target = sum / 2;
			int[] dp = new int[target + 1];
			Arrays.fill(dp, -1);
			dp[0] = 0;

			for (int i = 0; i < N; i++) {
				int coin = v[i];
				int cnt = c[i];
				for (int j = 0; j <= target; j++) {
					if (dp[j] >= 0) {
						dp[j] = cnt;
					} else if (j >= coin && dp[j - coin] > 0) {
						dp[j] = dp[j - coin] - 1;
					}
				}
			}

			if (dp[target] >= 0) {
				sb.append("1\n");
			} else {
				sb.append("0\n");
			}

		}
		System.out.println(sb.toString());
	}
}
