import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_21921 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int[] visited = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			visited[i] = Integer.parseInt(st.nextToken());
		}

		List<Integer> list = new ArrayList<>();
		int sum = 0;
		for (int i = 0; i < X; i++) {
			sum += visited[i];
		}
		list.add(sum);
		for (int i = X; i < N; i++) {
			sum = sum - visited[i - X] + visited[i];
			list.add(sum);
		}
		Collections.sort(list, Collections.reverseOrder());
		int check = list.get(0);
		int count = 0;
		for (int x : list) {
			if (x != 0 && x == check) {
				count++;
			}
		}
		if (count != 0) {
			System.out.println(check);
			System.out.println(count);
		} else {
			System.out.println("SAD");
		}
	}
}
