import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String bomb = br.readLine();
        int size = bomb.length();
        StringBuffer sb = new StringBuffer();
        for(int i =0; i<str.length(); i++){
            sb.append(str.charAt(i));

            if(sb.length() >= size){
                boolean check = true;
                for(int j =0; j<size; j++){
                    if(sb.charAt(sb.length() - size +j) != bomb.charAt(j)){
                        check=false;
                        break;
                    }
                }
                if(check){
                    sb.delete(sb.length() - size, sb.length());
                }
            }
        }

        if(sb.length() ==0){
            System.out.println("FRULA");
        }else{
            System.out.println(sb);
        }
    }
}
