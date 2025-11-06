import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_3687 {

	static int[] stick = { 0, 2, 5, 5, 4, 5, 6, 3, 7, 6, 6 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int test = 0; test < N; test++) {
			int cnt = Integer.parseInt(br.readLine());

			System.out.println(small(cnt) + " " + big(cnt));
		}
	}

	public static String small(int c) {
		StringBuilder sb = new StringBuilder();
		long[] mindp = new long[101];

		/////////////////// 작은 숫자 구하기///////////////////
		Arrays.fill(mindp, Long.MAX_VALUE);
		mindp[2] = 1;
		mindp[3] = 7;
		mindp[4] = 4;
		mindp[5] = 2;
		mindp[6] = 6;
		mindp[7] = 8;
		mindp[8] = 10;
		String[] addmin = { "1", "7", "4", "2", "0", "8" };

		// mindp의 값을 주어진 범위만큼 모두 구한다.
		for (int i = 9; i <= 100; i++) {
			for (int j = 2; j <= 7; j++) {
				String str = mindp[i - j] + addmin[j - 2];
				mindp[i] = Math.min(mindp[i], Long.parseLong(str));
			}
		}
		sb.append(mindp[c]);
		return sb.toString();
	}

	public static String big(int c) {
		StringBuilder sb = new StringBuilder();

		if (c % 2 == 0) {
			for (int i = 0; i < c / 2; i++) {
				sb.append("1");
			}

		} else {
			sb.append("7");
			for (int i = 0; i < (c - 3) / 2; i++) {
				sb.append("1");
			}

		}

		return sb.toString();
	}

}
