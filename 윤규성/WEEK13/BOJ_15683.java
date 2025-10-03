import java.io.*;
import java.util.*;

public class Q15683 {
	
	public static int[][] cctvs, map;
	public static int[] selected_dir;
	public static int cctv_cnt, N, M;
	public static int[] dX = {-1, 0, 1, 0};
	public static int[] dY = {0, 1, 0, -1};
	public static int min = Integer.MAX_VALUE;
	
	public static class Node{
		int x, y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer(br.readLine());
	
		 N = Integer.parseInt(st.nextToken());
		 M = Integer.parseInt(st.nextToken());
	
		map = new int[N][M];
		cctv_cnt = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j< M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] > 0 && map[i][j] < 6) {
					cctv_cnt++;
				}
			}
		}
	
		System.out.println(Arrays.deepToString(map));	
		
	cctvs = new int[cctv_cnt][2];
	int cnt = 0;
	for (int i = 0; i < N; i++) {
		for(int j =0; j<M; j++) {
			if(map[i][j] > 0 && map[i][j] < 6) {
				cctvs[cnt][0] = i;
				cctvs[cnt][1] = j;
				
				cnt++;
			}
		}
	}

	// 모든 cctv 방향의 조합을 구해야 함
	selected_dir = new int[cctv_cnt];
	select_dir(0);
	
	System.out.println(min);
}

private static void print(int[][] arr) {
	// TODO Auto-generated method stub
	for (int i = 0; i < arr.length; i++) {
		System.out.println(Arrays.toString(arr[i]));
	}
}

private static void select_dir(int sum) {
	if(sum == cctv_cnt) {
		get_safe();
		return;
	}
	
	// 방향 설정
	for(int i=1; i<5; i++) {
		selected_dir[sum] = i;
		select_dir(sum+1);
	}
}

private static void get_safe() {
	//System.out.println(Arrays.toString(selected_dir));
	int[][] mc = arr2_c(map);

	for(int i =0; i<cctv_cnt; i++) {	// cctv 개수만큼 돌면서
		int x = cctvs[i][0];
		int y = cctvs[i][1];
		int type = map[x][y];
		
		int[] dir;
		if(type == 1) {
			dir = new int[1];
			dir[0] = selected_dir[i] % 4;
		}else if(type == 2) {
			dir = new int[2];
			dir[0] = selected_dir[i] % 4;
			dir[1] = (2 + selected_dir[i]) % 4;
		}else if(type == 3) {
			dir = new int[2];
			dir[0] = selected_dir[i] % 4;
			dir[1] = (1 + selected_dir[i]) % 4;
		}
		else if(type == 4) {
			dir = new int[3];
			dir[0] = selected_dir[i] % 4;
			dir[1] = (1 + selected_dir[i]) % 4;
			dir[2] = (2 + selected_dir[i]) % 4;				
		}else{// type == 5
			dir = new int[4];
			dir[0] = selected_dir[i] % 4;
			dir[1] = (1 + selected_dir[i]) % 4;
			dir[2] = (2 + selected_dir[i]) % 4;
			dir[3] = (3 + selected_dir[i]) % 4;
		}
		//System.out.println("dirs : " + Arrays.toString(dir));

		for(int d = 0; d<dir.length; d++) {
			int nX = x;
			int nY = y;
			mc[nX][nY] = 9;
			
			while(true) {
				nX += dX[dir[d]];
				nY += dY[dir[d]];	
				
				//System.out.println(nX + ":"+ nY);
				
				if(nX >= N || nX < 0 || nY >= M || nY < 0) break;	
				if(map[nX][nY] == 6) break;
				
				mc[nX][nY] = 9;
			}
			//print(mc);
			//System.out.println( " ------- ");
		}
	}
	//System.out.println("함수 하나 끝");
	//print(mc);

	int cnt = 0;
	// i개 다 칠하면 사각지대 확인
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if(mc[i][j] == 0) cnt++;
		}
	}
	min = Math.min(cnt, min);
	
}

private static int[][] arr2_c(int[][] map2) {
	// TODO Auto-generated method stub
	
	int[][] to_return = new int[N][M];
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			to_return[i][j] = map2[i][j];
		}
	}
	
	return to_return;
}

}
