import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_2239 {
	static final int SIZE = 9;
	static int[][] board = new int[SIZE][SIZE];
	static List<int[]> blanks = new ArrayList<>();
	static boolean solved = false;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < SIZE; i++) {
			String line = br.readLine().trim(); // 공백 없는 9자리
			for (int j = 0; j < SIZE; j++) {
				board[i][j] = line.charAt(j) - '0';
				if (board[i][j] == 0)
					blanks.add(new int[] { i, j });
			}
		}
		dfs(0);
	}

	static void dfs(int idx) {
		if (solved)
			return; // 이미 해답을 찾았으면 더 진행 X
		if (idx == blanks.size()) { // 모든 빈칸 채움 -> 출력
			printBoard();
			solved = true;
			return;
		}

		int r = blanks.get(idx)[0];
		int c = blanks.get(idx)[1];

		for (int v = 1; v <= 9; v++) {
			if (canPlace(r, c, v)) {
				board[r][c] = v;
				dfs(idx + 1);
				board[r][c] = 0; // 백트래킹
				if (solved)
					return; // 해답 찾았으면 조기 종료
			}
		}
	}

	static boolean canPlace(int row, int col, int val) {
		// 행/열 체크
		for (int i = 0; i < 9; i++) {
			if (board[row][i] == val)
				return false;
			if (board[i][col] == val)
				return false;
		}
		// 3x3 박스 체크
		int sr = (row / 3) * 3;
		int sc = (col / 3) * 3;
		for (int i = sr; i < sr + 3; i++) {
			for (int j = sc; j < sc + 3; j++) {
				if (board[i][j] == val)
					return false;
			}
		}
		return true;
	}

	static void printBoard() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				sb.append(board[i][j]); // 공백 없이 출력
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}
}
