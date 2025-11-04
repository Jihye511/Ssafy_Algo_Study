import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_1863 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		Stack<Integer> stack = new Stack();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			// 스택에는 나보다 큰 것들이 들어있으면 안됨
			while (!stack.isEmpty() && (int) stack.peek() > y) {
				stack.pop();
				answer++;
			}

			// 높이가 0이면 무조건 건물은 없음
			if (y == 0)
				continue;

			// 동일 높이이면 넣을 필요 없음
			if (!stack.isEmpty() && stack.peek() == y)
				continue;

			stack.add(y);
		}

		while (!stack.isEmpty()) {
			stack.pop();
			answer++;
		}

		// 3. 출력
		System.out.println(answer);

	}

}
