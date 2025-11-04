import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int test = 1; test <= T; test++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[] benefit = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				benefit[i] = Integer.parseInt(st.nextToken());

			}
			long result = 0;
			int maxPrice = 0;

			for (int i = N - 1; i >= 0; i--) {
				if (benefit[i] > maxPrice) {
					maxPrice = benefit[i];
				} else {
					result += maxPrice - benefit[i];
				}
			}
			System.out.println(result);

		}

	}

}
