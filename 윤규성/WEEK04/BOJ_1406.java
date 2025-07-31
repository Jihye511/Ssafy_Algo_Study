import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Q1406 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Character> stack1 = new Stack<>();
		Stack<Character> stack2 = new Stack<>();
		
		// 입력 부
		String str = br.readLine();
		for(int i =0; i<str.length(); i++) {
			stack1.push(str.charAt(i));
		}
		
		int order_num = Integer.parseInt(br.readLine());
		String[] orders = new String[order_num];
		

		for(int i=0; i<order_num; i++) {
			orders[i] = br.readLine();
		}
				
		// 연산 수행
		for(String order : orders) {
			
			if(order.charAt(0) == 'L') {
				if(!stack1.isEmpty()) stack2.push(stack1.pop());
				
			}else if(order.charAt(0) == 'D') {
				if(!stack2.isEmpty()) stack1.push(stack2.pop());
				
			}else if(order.charAt(0) == 'B') {
				if(!stack1.isEmpty()) stack1.pop();

			}else if(order.charAt(0) == 'P') {
				stack1.push(order.charAt(2));
			}
		}
		
		
		// 출력
		while(!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		
		StringBuilder sb = new StringBuilder();
		while(!stack2.isEmpty()){
			sb.append(stack2.pop());
		}
		
		System.out.print(sb.toString());
	}
}
