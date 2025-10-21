import java.io.*;
import java.util.*;

public class Main {

    static String S;
    static int len;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        len = S.length();
        boolean[] arr = new boolean[len];
        int cnt_0 = 0;
        int cnt_1 = 0;

        // 1이면 true, 0이면 false
        for (int i = 0; i < len; i++) {
            if(S.charAt(i) == '1'){
                arr[i] = true;
                cnt_1++;
            }
            else{
                arr[i] = false;
                cnt_0++;
            }
        }

        StringBuilder sb = new StringBuilder();
        int temp_1 = cnt_1;
        int temp_0 = 0;
        for (int i = 0; i < len; i++) {
            if(arr[i]){
                if(temp_1 > cnt_1 / 2){
                    temp_1 --;
                }
                else{
                    sb.append('1');
                }
            }
            else{
                if(temp_0 < cnt_0 / 2){
                    sb.append('0');
                    temp_0++;
                }
            }
        }
        System.out.println(sb);

    }


}
