import java.io.*;
import java.util.*;
public class Main {
    static int value;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();
        int size = T.length();
        value = 0;
//        for(int i  =size-1; i>=0; i--){
//            System.out.println(T);
//            if(T.length()== S.length()){
//                if(S.equals(T)) System.out.println(1);
//                else System.out.println(0);
//                break;
//            }
//            if(T.charAt(i)=='A'){
//                T = T.substring(0,i);
//            }else{
//                T = reverse(T);
//            }
//        }
        dfs(S,T);
        System.out.println(value);

    }
    public static void dfs(String S, String T){
        if(S.length()==T.length()){
            if(S.equals(T)) {
                value=1;
            }
            return;
        }
        if(T.charAt(0)=='A'&& T.charAt(T.length()-1)=='A'){
            dfs(S, T.substring(0,T.length()-1));
        }
        else if(T.charAt(0)=='B' && T.charAt(T.length()-1)=='B'){
            String temp = reverse(T);
            dfs(S, temp);
        }else if(T.charAt(0)=='B' && T.charAt(T.length()-1)=='A') {
            dfs(S, T.substring(0, T.length() - 1));
            String temp = reverse(T);
            dfs(S, temp);
        }

    }
    public static String reverse(String str){
        StringBuilder sb = new StringBuilder();

        for(int i =str.length()-1; i>0;i--){
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

}
