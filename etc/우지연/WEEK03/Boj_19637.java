import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_19637 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());  // 칭호의 개수
		int M = Integer.parseInt(st.nextToken()); // 캐릭터들의 개수

		String[] title = new String[N]; // 칭호의 이름
		int[] titlePower = new int[N]; // 칭호의 전투력

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			title[i] = st.nextToken();
			titlePower[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(br.readLine());

			int start = 0;
			int last = N - 1;

			while (start <= last) {
				int mid = (start + last) / 2;

				if (titlePower[mid] < num) { 
					start = mid + 1;
				}

				else { 
					last = mid - 1;
				}
			}
			sb.append(title[start]).append("\n"); 
		}
		System.out.println(sb.toString());
	}
}
