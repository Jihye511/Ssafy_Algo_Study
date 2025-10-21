package 신승용.WEEK07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12919 {
    static String S;
    static String T;
    static boolean answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();
        answer = false;

        StringBuilder sb = new StringBuilder();
        sb.append(S);

        dfs(sb);

        System.out.println(answer ? 1 : 0);
    }

    static void dfs(StringBuilder sb){
        if(answer) return;
        if(sb.length() > T.length()) return;
        if(sb.length() == T.length()){
            if(sb.toString().equals(T)){
                answer = true;
            }
            return;
        }

        String cur = sb.toString();
        String reverse = sb.reverse().toString();

        sb.reverse();

        if(!T.contains(reverse) && !T.contains(cur)) return;

        StringBuilder sb2 = new StringBuilder();
        sb2.append(sb.toString());

        sb.append('A');
        dfs(sb);

        sb2.append('B');
        sb2.reverse();
        dfs(sb2);
    }
}