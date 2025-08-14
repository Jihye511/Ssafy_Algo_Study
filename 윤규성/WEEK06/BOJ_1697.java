import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1697 {
		
	static final int max = 100_001;
	static int[] map;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		map = new int[max];
		Arrays.fill(map, Integer.MAX_VALUE);

		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.add(N);
		map[N] = 0;
		
		while( !q.isEmpty() ) {
			int now = q.poll();
			if(now == K) break;
			
			if(now >= 1 && map[now - 1] == Integer.MAX_VALUE) {
				map[now - 1] = map[now] + 1;
				q.add(now - 1);
			}
			if(now < max && map[now + 1] == Integer.MAX_VALUE ) {
				map[now + 1] = map[now] + 1;
				q.add(now + 1);
			}
			if(now != 0 && now * 2 <= max && map[now * 2] == Integer.MAX_VALUE) {
				map[now * 2] = map[now] + 1;
				q.add(now * 2);
			}
		}
		
		System.out.println(map[K]);

	}

}
