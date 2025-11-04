import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int n;
	static int m;
	static int[][] area;
	static boolean[][] visited;
	static int[][] result;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int start_x = 0;
		int start_y = 0;

		area = new int[n][m];
		visited = new boolean[n][m];
		result = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
				if (area[i][j] == 2) {
					start_x = i;
					start_y = j;
					result[i][j] = 0;

				} else if (area[i][j] == 0) {
					visited[i][j] = true;
					result[i][j] = 0;
				} else {
					result[i][j] = -1;
				}

			}
		}
		bfs(start_x, start_y);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(result[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y });
		while (!queue.isEmpty()) {
			int tmp[] = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = tmp[0] + dx[i];
				int ny = tmp[1] + dy[i];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
					if (!visited[nx][ny] && area[nx][ny] == 1) {
						visited[nx][ny] = true;
						result[nx][ny] = result[tmp[0]][tmp[1]] + 1;
						queue.add(new int[] { nx, ny });
					}
				}
			}
		}
	}

}
