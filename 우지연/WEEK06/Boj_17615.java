import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_17615 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int r_count = 0;
		int r_result = 0;
		int b_count = 0;
		int b_result = 0;
		int result = 0;
		for (int i = 0; i < N; i++) {
			if (str.charAt(i) == 'R') {
				r_count++;
				if (b_count != 0) {
					b_result += b_count;
					b_count = 0;
				}
			} else if (str.charAt(i) == 'B') {
				b_count++;
				if (r_count != 0) {
					r_result += r_count;
					r_count = 0;
				}
			}

		}
		result = Math.min(r_result, b_result);

		r_count = 0;
		r_result = 0;
		b_count = 0;
		b_result = 0;
		for (int i = N - 1; i >= 0; i--) {
			if (str.charAt(i) == 'R') {
				r_count++;
				if (b_count != 0) {
					b_result += b_count;
					b_count = 0;
				}
			} else if (str.charAt(i) == 'B') {
				b_count++;
				if (r_count != 0) {
					r_result += r_count;
					r_count = 0;
				}
			}

		}
		result = Math.min(result, Math.min(r_result, b_result));
		System.out.println(result);

	}

}
