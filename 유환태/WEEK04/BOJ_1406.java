import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        String N = br.readLine();
        int M = Integer.parseInt(br.readLine());
        
        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();

        for (char ch : N.toCharArray()) {
            left.addLast(ch);
        }

        for(int i = 0; i < M; i++){
            String op = br.readLine();

            if(op.equals("L")){
                if(!left.isEmpty()){
                    right.addFirst(left.removeLast());
                }
            } else if(op.equals("D")){
                if(!right.isEmpty()){
                    left.addLast(right.removeFirst());
                }
            } else if(op.equals("B")){
                if(!left.isEmpty()){
                    left.removeLast();
                }
            } else if(op.startsWith("P ")){
                char ch = op.charAt(2);
                left.addLast(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char ch : left) sb.append(ch);
        for(char ch : right) sb.append(ch);
        System.out.println(sb.toString());
    }
}