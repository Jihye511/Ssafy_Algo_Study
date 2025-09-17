package boj;

import java.util.*;
import java.io.*;

public class BOJ_9935 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String bomb = br.readLine();

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < line.length(); i++){
            stack.push(line.charAt(i));

            if(stack.size() >= bomb.length()){
                boolean is_valid = true;

                for(int j = 0; j < bomb.length(); j++){
                    char s = stack.get(stack.size() - j - 1 );
                    if(s!=bomb.charAt(bomb.length() - j - 1)){
                        is_valid = false;
                    }
                }

                if(is_valid){
                    for(int j = 0; j < bomb.length(); j++){
                        stack.pop();
                    }
                }
            }

        }
        if(stack.isEmpty()){
            System.out.println("FRULA");
        }else{
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < stack.size(); i++){
                sb.append(stack.get(i));
            }
            System.out.println(sb.toString());
        }

    }
}
