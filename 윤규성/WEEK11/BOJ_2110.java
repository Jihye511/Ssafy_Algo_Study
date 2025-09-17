import java.io.*;
import java.util.*;

public class Q2110_R {
	
	public static int[] homes;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());	// 공유기 개수
		
		homes = new int[N];
		for(int i = 0; i < N; i++) {
			homes[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(homes);
		
		// 가장 인접한 두 공유기 사이의 거리를 최대로
		int l = 0;
		int r = homes[N-1] - homes[0];
		int m = (l + r + 1) / 2;
		// 최소 거리를 m으로 했을 때 C대의 공유기를 넣을 수 있으면 참 / 없으면 m을 줄여야 함.
		
		while(l < r) {
			m = (l + r + 1) / 2;
			
			int tar = set_interval(m);
			if(tar < C) {	// 줄여
				r = m - 1;
			}else {			// 늘려
				l = m;
			}
			
		}
		
		System.out.println(r);
		
	}

	private static int set_interval(int interval) {
		int cnt = 1;
		int prev = homes[0];
		
		for(int i = 1; i < homes.length; i++) {
			if(homes[i] >= prev + interval) {
				cnt++;
				prev = homes[i];
			}
		}
		
		return cnt;
	}

}
