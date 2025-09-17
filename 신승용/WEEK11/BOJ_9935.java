package 신승용.WEEK11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9935 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String token = br.readLine();
        String bomb = br.readLine();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < token.length(); i++) {
            stack.push(token.charAt(i));

            if(stack.peek() == bomb.charAt(bomb.length()-1)){
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < bomb.length(); j++) {
                    if(!stack.isEmpty()){
                        sb.append(stack.pop());
                    }
                }

                sb.reverse();
                if(!sb.toString().equals(bomb)){
                    String revert = sb.toString();
                    for (int j = 0; j < revert.length(); j++) {
                        stack.push(revert.charAt(j));
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        String answer = sb.reverse().toString();

        if(answer.isEmpty()){
            System.out.println("FRULA");
        } else {
            System.out.println(answer);
        }
    }
}
