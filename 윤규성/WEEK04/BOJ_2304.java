import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q2304 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		final int width = 1001;
		
		int[] map = new int[width];
		int end = 0, start = Integer.MAX_VALUE, max = 0;
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map[a] = b;
		
			end = Math.max(end, a);
			start = Math.min(start, a);
			max = Math.max(max, b);
		}
		
		ArrayList<Integer> list = new ArrayList<>(); 
		for(int i = start; i <= end; i++) {
			if(map[i] == max) list.add(i);
		}
		
		int firstMax = list.get(0);
		int lastMax = list.get(list.size() - 1);
		int shortfall = 0;
		int nMax = 0;
		
		// 앞에서 자르고
		for(int i = start; i <= firstMax; i++) {
			nMax = Math.max(nMax, map[i]);
			shortfall += max - nMax;
		}

		// 뒤에서 자르고
		nMax = 0;
		for(int i = end; i >= lastMax; i--) {
			nMax = Math.max(nMax, map[i]);
			shortfall += max - nMax;
		}

		
		int res = (end - start + 1) * max - shortfall;
		
		System.out.println(res);
		
	}

}
