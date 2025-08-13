import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] arr = new char[str.length()];
        int acnt = 0;
        for(int i =0; i<str.length(); i++){
            arr[i] = str.charAt(i);
            if(arr[i] =='a') acnt++;
        }
        if(acnt ==0 || acnt ==str.length()){
            System.out.println(0);
            return;
        }
        int bwindow = 0;
        for(int i =0; i<acnt; i++){
            if(arr[i] =='b') bwindow++;
        }
        int value = bwindow;

        for(int i =1; i<str.length(); i++){
            if(arr[i-1] =='b'){
                bwindow--;
            }

            int idx = (i +acnt -1) % str.length();
            if(arr[idx] =='b') bwindow++;

            value=Math.min(value,bwindow);
        }
        System.out.println(value);

    }
}
