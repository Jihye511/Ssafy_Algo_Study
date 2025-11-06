import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main_1987 {
	static int[][] area;
	static int R;
	static int C;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int days;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		area = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			String eng = br.readLine();
			for (int j = 0; j < C; j++) {
				area[i][j] = Integer.parseInt((eng.charAt(j) - 65) + "");
			}
		}

		boolean[] visited = new boolean[26];
		visited[area[0][0]]=true;
		dfs(new int[] {0, 0, 1}, visited);

		System.out.println(days);
	}

	public static void dfs(int[] array,boolean[] visited) {
		int[] pos = array;
		int x=pos[0],y=pos[1],z=pos[2];
		
			days = Math.max(days, z);

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[area[nx][ny]]) {
					
					visited[area[nx][ny]] = true;

					dfs(new int[] {nx, ny, z + 1},visited);
					visited[area[nx][ny]] = false;
				
					
				}
			}

		}

	}


