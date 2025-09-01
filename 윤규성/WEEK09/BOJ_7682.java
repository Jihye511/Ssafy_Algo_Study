import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q7682 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		StringBuilder sb = new StringBuilder();

		while(true) {
			
			st = new StringTokenizer(br.readLine());
			
			String str = st.nextToken();
			if(str.equals("end")) {
				System.out.print(sb);
				break;
			}
			
			if(isValid(str)) {
				sb.append("valid");
			}else {
				sb.append("invalid");
			}
			sb.append('\n');
		}
		
	}

	private static boolean isValid(String str) {
		int xCount = 0;
		int oCount = 0;
		
		for(int i = 0; i < 9; i++) {
			if(str.charAt(i) == 'X') xCount++;
			else if(str.charAt(i) == 'O') oCount++;
		}
		
		// o 가 많거나, x가 2개 이상 많으면 
		if(xCount < oCount) return false;
		else if(xCount > oCount + 1) return false;
		
		if(xCount == oCount) {
			if(check_O_win(str) && !check_X_win(str)) return true;
		} else if(xCount == oCount + 1) {
			if(check_X_win(str) && !check_O_win(str)) return true;
			// 승부가 안나는 경우
			if(oCount + xCount == 9 && check_non_win(str)) {
				return true;
			}
		}
		
		return false;
	}

	private static boolean check_non_win(String str) {
		// 하나라도 이기는 경우가 있다면 false임
		
		// 가로
		A : for(int i = 0; i < 3; i++) {
			char first = str.charAt(i * 3);
			for(int j = 0; j < 3; j++) {
				if(j == 0) first = str.charAt(i * 3 + j);
				// 처음이랑 다르면 나가
				if (str.charAt(i * 3 + j) != first) continue A;
			}
			return false;
		}
		
		// 세로
		A : for(int i = 0; i < 3; i++) {
			char first = '?';
			for(int j = 0; j < 3; j++) {
				if(j == 0) first = str.charAt(j * 3 + i);
				if(str.charAt(j * 3 + i) != first) continue A;
			}
			return false;
		}

		char first = str.charAt(0);
		if(str.charAt(4) == first && str.charAt(8) == first) return false;

		first = str.charAt(2);
		if(str.charAt(4) == first && str.charAt(6) == first) return false;

		return true;
	}

	private static boolean check_X_win(String str) {
		
		// 가로
		A : for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if (str.charAt(i * 3 + j) != 'X') continue A;
			}
			return true;
		}
		
		// 세로
		A : for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(str.charAt(j * 3 + i) != 'X') continue A;
			}
			return true;
		}
		
		if(str.charAt(0) == 'X' && str.charAt(4) == 'X' && str.charAt(8) == 'X') return true;
		if(str.charAt(2) == 'X' && str.charAt(4) == 'X' && str.charAt(6) == 'X') return true;
		
		return false;
	}

	private static boolean check_O_win(String str) {
		
		// 가로
		A : for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if (str.charAt(i * 3 + j) != 'O') continue A;
			}
			return true;
		}
		
		// 세로
		A : for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(str.charAt(j * 3 + i) != 'O') continue A;
			}
			return true;
		}
		
		if(str.charAt(0) == 'O' && str.charAt(4) == 'O' && str.charAt(8) == 'O') return true;
		if(str.charAt(2) == 'O' && str.charAt(4) == 'O' && str.charAt(6) == 'O') return true;
		
		return false;
	}

}
