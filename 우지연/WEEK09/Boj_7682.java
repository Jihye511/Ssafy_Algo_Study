import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_7682 {
	static char[][] area;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String str = br.readLine();
			if (str.equals("end")) {
				break;
			}

			area = new char[3][3];
			int x_count = 0;
			int o_count = 0;
			int index = 0;

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					area[i][j] = str.charAt(index);
					index++;
					if (area[i][j] == 'X') {
						x_count++;
					} else if (area[i][j] == 'O') {
						o_count++;
					}
				}

			}
			if (x_count == o_count + 1) {
				if (x_count + o_count == 9 && !bingo('O')) {
					System.out.println("valid");
				} else if (!bingo('O') && bingo('X')) {
					System.out.println("valid");
				} else
					System.out.println("invalid");
			} else if (x_count == o_count) {
				if (!bingo('X') && bingo('O')) {
					System.out.println("valid");
				} else
					System.out.println("invalid");
			} else
				System.out.println("invalid");

		}

	}

	public static boolean bingo(char a) {
		for (int i = 0; i < 3; i++) {
			if (area[i][0] == a && area[i][1] == a && area[i][2] == a) {
				return true;
			}
		}
		for (int i = 0; i < 3; i++) {
			if (area[0][i] == a && area[1][i] == a && area[2][i] == a) {
				return true;
			}
		}
		if (area[0][0] == a && area[1][1] == a && area[2][2] == a) {
			return true;
		}
		if (area[0][2] == a && area[1][1] == a && area[2][0] == a) {
			return true;
		}
		return false;

	}

}
