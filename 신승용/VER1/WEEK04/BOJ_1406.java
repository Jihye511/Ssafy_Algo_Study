package 신승용.WEEK04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1406 {
    public static void main(String[] args) throws IOException{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        String token = br.readLine();

        int M = Integer.parseInt(br.readLine());
        Stack<Character> fStack = new Stack<>();
        Stack<Character> bStack = new Stack<>();

        for (int i = 0; i < token.length(); i++) {
            fStack.push(token.charAt(i));
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "P":
                    fStack.push(st.nextToken().charAt(0));
                    break;
                case "L":
                    if(!fStack.isEmpty()){
                        bStack.push(fStack.pop());
                    }
                    break;
                case "D":
                    if(!bStack.isEmpty()){
                        fStack.push(bStack.pop());
                    }
                    break;
                case "B":
                    if(!fStack.isEmpty()){
                        fStack.pop();
                    }
                    break;
                default:
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!fStack.isEmpty()) {
            bStack.push(fStack.pop());
        }
        while (!bStack.isEmpty()) {
            sb.append(bStack.pop());
        }
        System.out.println(sb.toString());
    }
}
