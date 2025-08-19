import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q13549 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int MAX = 100_001;
		
		int[] time = new int[MAX];
		Arrays.fill(time, -1);
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.add(N);
		time[N] = 0;

		while(!q.isEmpty()) {
			int now = q.poll();
			if(now > 0 && (time[now - 1] == -1 || time[now - 1] > time[now])) {
				time[now - 1] = time[now] + 1;
				q.add(now - 1);
			}
			
			if(now < MAX-1 && (time[now + 1] == -1 || time[now + 1] > time[now])) {
				time[now + 1] = time[now] + 1;
				q.add(now + 1);
			}
			
			if(now * 2 < MAX && (time[now * 2] == -1 || time[now * 2] > time[now])) {
				time[now * 2] = time[now];
				q.add(now * 2);
			}
			
		}
		
		System.out.println(time[K]);
		
	}

}
