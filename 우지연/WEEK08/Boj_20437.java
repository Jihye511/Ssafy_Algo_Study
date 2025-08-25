import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_20437 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			String W = br.readLine();
			int K = Integer.parseInt(br.readLine());

			// 문자별 인덱스 저장
			List<Integer>[] pos = new ArrayList[200];
			for (int i = 0; i < 200; i++) {
				pos[i] = new ArrayList<>();
			}

			for (int i = 0; i < W.length(); i++) {
				pos[W.charAt(i)].add(i);
			}

			List<Integer> result = new ArrayList<>();

			for (int c = 0; c < 200; c++) {
				if (pos[c].size() < K)
					continue;

				for (int i = 0; i <= pos[c].size() - K; i++) {
					int len = pos[c].get(i + K - 1) - pos[c].get(i) + 1;
					result.add(len);
				}
			}

			if (!result.isEmpty()) {
				Collections.sort(result);
				sb.append(result.get(0)).append(" ").append(result.get(result.size() - 1)).append("\n");
			} else {
				sb.append("-1\n");
			}
		}
		System.out.print(sb.toString());
	}
}
