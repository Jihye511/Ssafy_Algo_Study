import java.io.*;
import java.util.*;

public class Main {

    static int n,k,t,m;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char [] ch = str.toCharArray();
        boolean[] check = new boolean[str.length()];
        int cntOne = 0;
        int cntZero = 0;
        for(int i =0; i<str.length(); i++){
            int n =  ch[i]-'0';
            if(n ==1) cntOne++;
            else if(n ==0) cntZero++;
        }
        int idx =0;
        int removeOne = cntOne/2;
        while(removeOne>0){
            if(str.charAt(idx) == '1'){
                check[idx] = true;
                removeOne--;
            }
            idx++;
        }
        idx= str.length()-1;
        int removeZero = cntZero/2;
        while(removeZero>0 ){
            if(str.charAt(idx)=='0'){
                check[idx] = true;
                removeZero--;
            }
            idx--;
        }
        StringBuilder sb = new StringBuilder();
        for(int i =0; i< str.length(); i++){
            if(!check[i]){
                sb.append(ch[i]);
            }
        }
        System.out.println(sb);
    }
}
