import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_4485 {

	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	static int INF = 10000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int cnt = 1;

		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N == 0) break;

			sb.append("Problem ").append(cnt++).append(": ");
			int[][] arr = new int[N][N];

			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++)
					arr[i][j] = Integer.parseInt(st.nextToken());
			}

			sb.append(dijkstra(arr, N)).append('\n');
		}

		System.out.println(sb);
		br.close();

	}

	static int dijkstra(int[][] arr, int n) {
		PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);

		int[][] dijk = new int[n][n];
		for(int i=0;i<n;i++)
			Arrays.fill(dijk[i], INF);

		q.offer(new int[] {0, 0, arr[0][0]});
		dijk[0][0] = arr[0][0];

		while(!q.isEmpty()) {
			int temp[] = q.poll();
			int row = temp[0];
			int col = temp[1];

			for(int i=0;i<4;i++) {
				int nextRow = row + dx[i];
				int nextCol = col + dy[i];

				if(nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n
						&& dijk[nextRow][nextCol] > dijk[row][col] + arr[nextRow][nextCol]) {
					dijk[nextRow][nextCol] = dijk[row][col] + arr[nextRow][nextCol];
					q.offer(new int[] {nextRow, nextCol, dijk[nextRow][nextCol]});
				}
			}
		}

		return dijk[n - 1][n - 1];

	}

}




