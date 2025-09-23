import java.io.*;
import java.util.*;

public class Q2179 {
 
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		String[] strs = new String[N];
		for(int i = 0; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			strs[i] = st.nextToken();
		}
		
		int max = 0;
		String ans_S = strs[0];
		String ans_T = strs[1];
		
		for(int i = 0; i < N; i++) {
			for(int j = i + 1; j < N; j++) {
				if(check(strs[i], strs[j]) > max) {
					max = check(strs[i], strs[j]);
					ans_S = strs[i];
					ans_T = strs[j];
				}
			}
		}
		
		System.out.println(ans_S);
		System.out.println(ans_T);
	
	}

	private static int check(String str, String cmp) {
		if(str.equals(cmp)) return 0;
		
		int cnt = 0;
		for(int i = 0; i < str.length(); i++) {
			if(i >= cmp.length()) break;
			
			if(str.charAt(i) == cmp.charAt(i)) cnt++;
			else break;
		}
		
		return cnt;
	}

}
