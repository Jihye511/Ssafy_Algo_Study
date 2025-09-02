import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main_2668 {
	static int N;
	static int[] num;
	static boolean[] visited;
	static boolean[] finished;
	static Set<Integer> result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		result = new HashSet<>();
		num = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		visited = new boolean[N + 1];
		finished = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				dfs(i);
			}
		}
		List<Integer> list = new ArrayList<>(result);
		Collections.sort(list);
		System.out.println(list.size());
		for (int x : list) {
			System.out.println(x);
		}
	}

	private static void dfs(int cur) {
		visited[cur] = true;
		int next = num[cur];

		if (!visited[next]) {
			dfs(next);
		} else if (!finished[next]) {
			int v = next;
			while (true) {
				result.add(v);
				v = num[v];
				if (v == next)
					break;
			}
		}
		finished[cur] = true;
	}

}
