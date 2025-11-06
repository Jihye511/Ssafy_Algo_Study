import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1522 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int a_count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'a') {
				a_count++;
			}
		}

		int result = Integer.MAX_VALUE;
		for (int i = 0; i < str.length(); i++) {
			int now = 0;
			for (int j = i; j < i + a_count; j++) {
				if (str.charAt(j % str.length()) == 'b') {
					now++;
				}

			}
			result = Math.min(result, now);
		}
		System.out.println(result);

	}

}
