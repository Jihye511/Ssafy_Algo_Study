import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1992 {

	static int N;
	static int[][] area;
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		area = new int[N][N];

		for (int i = 0; i < N; i++) {
			String a = br.readLine();
			for (int j = 0; j < N; j++) {
				area[i][j] = Integer.parseInt(a.charAt(j) + "");

			}
		}
		recursive(0, 0, N);
		System.out.println(sb);

	}

	public static void recursive(int x, int y, int size) {

		if (check(x, y, size)) {
			sb.append(area[x][y]);
			return;
		} else {
			sb.append("(");
			int new_size = size / 2;
			recursive(x, y, new_size); // 왼쪽 위
			recursive(x, y + new_size, new_size); // 오른쪽 위
			recursive(x + new_size, y, new_size); // 왼쪽 아래
			recursive(x + new_size, y + new_size, new_size); // 오른쪽 아래

		}
		sb.append(")");
	}

	public static boolean check(int x, int y, int size) {
		int start = area[x][y];
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (start != area[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

}
