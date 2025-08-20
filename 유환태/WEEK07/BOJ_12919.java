
import java.util.*;
import java.io.*;

public class Main {
    static String S, T;
    static boolean ans = false;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        S = br.readLine();
        T = br.readLine();

        dfs(T);

        System.out.println(ans?1:0);
    }
    static void dfs(String str){

        if(ans) return;

        if(str.length() < S.length()) return;
        if(str.equals(S)){
            ans = true;
            return ;
        }
        if(str.charAt(str.length()-1)=='A'){
            dfs(str.substring(0,str.length()-1));
        }
        if(str.charAt(0)=='B'){
            String reverse = "";
            for(int j = str.length()-1; j >= 1 ; j--){
                reverse += str.charAt(j);
            }
            dfs(reverse);
        }
    }
}

