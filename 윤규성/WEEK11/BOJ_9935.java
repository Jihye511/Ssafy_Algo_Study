import java.util.*;
import java.io.*;

public class Q9935 {

public static void main(String[] args)throws IOException {
    // TODO Auto-generated method stub
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    String arr = br.readLine();
    String bomb = br.readLine();
    
    Stack<Character> stack = new Stack<>();
    for(int i =0; i<arr.length(); i++) {
    	
    	stack.push(arr.charAt(i));
    	
    	if(stack.size() >= bomb.length() && arr.charAt(i) == bomb.charAt(bomb.length()-1)) {
    		boolean flag = false;
    		for(int j = 0; j<bomb.length(); j++) {
    			if(stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)) {
    				
    				flag = true;
    			}
    		}
    		
    		if(!flag) {    			
    			for(int j = 0; j<bomb.length(); j++) {
    				stack.pop();
    			}
    		}
    	}
    }
    
    StringBuilder sb = new StringBuilder();
    for(Character c : stack) {
    	sb.append(c);
    }
   
    if(sb.length() > 0) {    	
    	System.out.println(sb);
    }else System.out.println("FRULA");
}
}