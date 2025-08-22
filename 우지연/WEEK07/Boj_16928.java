import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16928 {
	static int arr[], N, M;
	static boolean visited[];
	static int result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[101];
		visited = new boolean[101];

		for (int i = 0; i < N + M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x] = y;
		}
		bfs(1);
		System.out.println(result);
	}

	static void bfs(int start) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { start, 0 });
		visited[start] = true;

		while (!q.isEmpty()) {
			int p[] = q.poll();

			if (p[0] == 100) {
				result = p[1];

				return;
			}
			for (int i = 1; i < 7; i++) {
				int next = p[0] + i;
				if (next <= 100) {
					if (arr[next] != 0 && arr[p[0]] <= arr[next]) {
						next = arr[next];
					}
					if (!visited[next]) {
						visited[next] = true;
						q.add(new int[] { next, p[1] + 1 });

					}
				}
			}
		}
	}

}
