import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2607 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int ans = 0;
		
		String std = br.readLine();
		int std_len = std.length();
		int[] std_alpha = getAlpha(std);
				
		w : for(int i = 0; i < N - 1; i++) {
			String str = br.readLine();
			int[] str_alpha = getAlpha(str);
			
			if(str.length() == std_len) {			// 같은 구성 or 한 문자만 차이
					
				int diff = 0;
				for(int ch = 0; ch < 26; ch++) {
					if(str_alpha[ch] - std_alpha[ch] != 0) {
						if(diff == 0) {
							diff = str_alpha[ch] - std_alpha[ch];
							if(diff < -1 || diff > 1) continue w;
						}
						else {
							if(diff + str_alpha[ch] - std_alpha[ch] != 0) continue w;
						}
					}
				}
				
			}else {									// 하나를 더하거나 뺌
				
				boolean flag = false;
				for(int ch = 0; ch < 26; ch++) {
					if(str_alpha[ch] != std_alpha[ch]) {
						if(!flag) flag = true;
						else continue w;
					}
				}
				
			}
			
			ans++;
			//System.out.println(str);
			
		}
		
		System.out.println(ans);
		
	}

	private static int[] getAlpha(String str) {
		int[] alpha = new int[26];
		
		for(int i = 0; i<str.length(); i++) {
			char ch = str.charAt(i);
			alpha[ch - 'A']++;
		}
				
		return alpha;
	}


}
