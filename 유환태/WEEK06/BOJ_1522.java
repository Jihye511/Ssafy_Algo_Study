import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        String line = br.readLine();
        int len = line.length();
        int a_cnt = 0;
        for(int i = 0; i < len; i++){
            if(line.charAt(i) == 'a'){
                a_cnt++;
            }
        }
        
        String round = line.substring(len - a_cnt, len) + line + line.substring(0, a_cnt);
        int b_cnt = 0;
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < a_cnt; i++){
            if(round.charAt(i)=='b'){
                b_cnt++;
            }
        }
        ans = Math.min(ans, b_cnt);
        for(int i = a_cnt; i < round.length(); i++){
            if(round.charAt(i)=='b'){
                b_cnt++;
            }
            if(round.charAt(i-a_cnt)=='b'){
                b_cnt--;
            }
            ans = Math.min(ans, b_cnt);
        }

        System.out.println(ans);
    }
}