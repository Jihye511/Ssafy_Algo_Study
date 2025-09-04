package 신승용.WEEK09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BOJ_7490 {
    static char[] op = {'+', ' ', '-'};
    static List<String> list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        

        for (int test_case = 0; test_case < T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            dfs(N, 1, new StringBuilder());
            Collections.sort(list);
            for (String str : list) {
                System.out.println(str);
            }
            System.out.println();
        }
    }

    static void dfs(int N, int depth, StringBuilder sb){
        if(depth == N){
            sb.append(depth);
            // 문자열 계산
            if(calc(sb.toString())){
                list.add(sb.toString());
            }
            return;
        }

        sb.append(depth);

        for (int i = 0; i < 3; i++) {
            sb.append(op[i]);
            dfs(N, depth+1, new StringBuilder(sb));
            sb.deleteCharAt(sb.length()-1);
        }
    }

    static boolean calc(String str) {
        String token = str.replaceAll(" ", "");
        int cal = 0;
        
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < token.length(); i++) {
            stack.push(token.charAt(i));
        }

        while (!stack.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty() && stack.peek() != '+' && stack.peek() != '-') {
                char ch = stack.pop();
                sb.append(ch);
            }
            sb.reverse();
            int num = Integer.parseInt(sb.toString());
            if(!stack.isEmpty()){
                char op = stack.pop();
                if(op == '+'){
                    cal += num;
                } else if(op =='-'){
                    cal -= num;
                }
            } else {
                cal += num;
            }
        }

        if(cal == 0 ) return true;
        else return false;
    }
}