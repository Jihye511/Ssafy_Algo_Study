import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q2493 {
	
	public static class Node{
		int num, idx;
		
		public Node(int num, int idx) {
			this.num = num;
			this.idx = idx;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Node> stack = new Stack<>();
		for(int i = 0; i < N-1; i++) {
			stack.push(new Node(Integer.parseInt(st.nextToken()), i));
		}

		int[] dp = new int[N];
		Stack<Node> unPoped = new Stack<>();
		unPoped.push(new Node(Integer.parseInt(st.nextToken()), N-1));
		
		while(!stack.isEmpty() && !unPoped.isEmpty()) {
			Node un = unPoped.peek();
			Node now = stack.peek();
			
			if(un.num <= now.num) {			// 도달
				dp[un.idx] = stack.size();
				unPoped.pop();
			}else {							// 도달 X
				unPoped.push(stack.pop());
			}
			
			if(!stack.isEmpty() && unPoped.isEmpty()) unPoped.push(stack.pop());
		}
		
		while(!unPoped.isEmpty()) {
			Node now = unPoped.pop();
			dp[now.idx] = 0;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(dp[i] + " ");
		}
		System.out.print(sb);
	}
}
