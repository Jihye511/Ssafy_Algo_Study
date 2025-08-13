import java.util.*;
import java.io.*;

public class Q1522 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int a = 0;
		int b = 0;
		int ans = Integer.MAX_VALUE;
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == 'a') a++;
		}
		
		for(int i = 0; i< str.length(); i++) {
			b = 0;
			for(int j = 0; j < a; j++) {
				if(str.charAt((i + j) % str.length()) == 'b') b++;
			}
			ans = Math.min(ans, b);
		}
		
		System.out.println(ans);
	}

}
