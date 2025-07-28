import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Q22233 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashSet<String> memo = new HashSet<>();
		for(int i = 0; i<N; i++) {
			memo.add(br.readLine());
		}
		
		for(int i = 0; i < M; i++) {
			String post = br.readLine();
			String[] words = post.split(",");
		
			for(String str : words) {
				
				if(memo.contains(str)) {
					memo.remove(str);
				}
			
			}
			
			sb.append(memo.size()).append('\n');
			
		}
		
		System.out.print(sb);	
		
	}
}
