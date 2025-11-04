import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_1406 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = Integer.parseInt(br.readLine());

		Stack<String> left = new Stack<>();
		Stack<String> right = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			left.push(str.charAt(i) + "");
		}

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			String op = st.nextToken();

			if (op.equals("L")) {
				if (!left.isEmpty())
					right.push(left.pop());
			} else if (op.equals("D")) {
				if (!right.isEmpty())
					left.push(right.pop());
			} else if (op.equals("B")) {
				if (!left.isEmpty())
					left.pop();
			} else if (op.equals("P")) {
				String key = st.nextToken();
				left.push(key);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (String c : left)
			sb.append(c);
		while (!right.isEmpty())
			sb.append(right.pop());

		System.out.println(sb);
	}

}
