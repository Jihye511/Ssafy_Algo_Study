import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_20310 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		int zero = 0, one = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '1') {
				one++;
			} else {
				zero++;
			}
		}
		int removeZero = zero / 2;
		int removeOne = one / 2;

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '1') {
				if (removeOne > 0) {
					removeOne--;
				} else {
					sb.append("1");
				}
			} else {
				sb.append("0");
			}
		}
		for (int i = sb.length() - 1; i >= 0; i--) {
			if (sb.charAt(i) == '0') {

				if (removeZero > 0) {
					sb.deleteCharAt(i);
					removeZero--;
				}
			}

		}
		System.out.println(sb);

	}

}
