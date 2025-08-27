import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q14719 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean[][] map = new boolean[N][M];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			int len = Integer.parseInt(st.nextToken());
			for(int j = 0; j < len; j++) {
				map[N-1-j][i] = true;
			}
		}

		int ans = 0;
		for(int i = 0; i < N; i++) {
			
			int cnt = 0;
			boolean wall = false;
			
			for(int j = 0; j<M; j++) {
				if(map[i][j] && !wall) {	// 벽 안지난 상태에서 만남
					wall = true;
				}else if(!map[i][j] && wall) {	// 벽 지난 상태에서 빈 공산
					cnt++;
				}else if(map[i][j] && wall) {	// 벽 지난 상태에서 벽 만남
					ans += cnt;
					cnt = 0;
				}
			}
		}
		
		System.out.println(ans);
		
	}

}
