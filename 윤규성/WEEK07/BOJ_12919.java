import java.io.*;
import java.util.*;

public class Q12919 {

	public static String S;
	public static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		S = br.readLine();
		String T = br.readLine();
						
		go(T);
		
		System.out.println(ans);
	}
	
	public static void go(String now) {
		if(now.length() == S.length()) {
			if(now.equals(S)) ans = 1;
			return;
		}
		
		if(now.charAt(now.length() - 1) == 'A') {
			String next = now.substring(0, now.length()-1);
			go(next);
		}
		
		if(now.charAt(0) == 'B') {
			String next = now.substring(1, now.length());
			StringBuilder rev = new StringBuilder(next);
			go(rev.reverse().toString());
		}
	}

}
