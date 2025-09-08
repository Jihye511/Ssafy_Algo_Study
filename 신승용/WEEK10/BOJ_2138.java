package 신승용.WEEK10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2138 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[] switches = br.readLine().toCharArray();
        char[] switches2 = switches.clone();
        String lights = br.readLine();

        int answer = Integer.MAX_VALUE;
        
        int count1 = 1;
        int count2 = 0;

        // 첫번째 스위치 누름
        if(switches[0] == '0') switches[0] = '1';
        else switches[0] = '0';
        if(switches[1] == '0') switches[1]= '1';
        else switches[1] = '0';
        for (int i = 1; i < switches.length-1; i++) {
            if(switches[i-1]==lights.charAt(i-1)) continue;
            else{
                if(switches[i-1] == '0') switches[i-1] = '1';
                else switches[i-1] = '0';
                if(switches[i] == '0') switches[i]= '1';
                else switches[i] = '0';
                if(switches[i+1] == '0') switches[i+1] = '1';
                else switches[i+1] = '0';
                count1++;
            }
        }

        if(switches[switches.length-1] != lights.charAt(lights.length()-1)){
            if(switches[switches.length-2] == '0') switches[switches.length-2] = '1';
                else switches[switches.length-2] = '0';
                if(switches[switches.length-1] == '0') switches[switches.length-1]= '1';
                else switches[switches.length-1] = '0';
                count1++;
        }

        if(String.valueOf(switches).equals(lights)){
            answer = Math.min(answer, count1);
        }

        for (int i = 1; i < switches2.length-1; i++) {
            if(switches2[i-1]==lights.charAt(i-1)) continue;
            else{
                if(switches2[i-1] == '0') switches2[i-1] = '1';
                else switches2[i-1] = '0';
                if(switches2[i] == '0') switches2[i] = '1';
                else switches2[i] = '0';
                if(switches2[i+1] == '0') switches2[i+1] = '1';
                else switches2[i+1] = '0';
                count2++;
            }
        }
        if(switches2[switches.length-1] != lights.charAt(lights.length()-1)){
            if(switches2[switches2.length-2] == '0') switches2[switches2.length-2] = '1';
                else switches2[switches2.length-2] = '0';
                if(switches2[switches2.length-1] == '0') switches2[switches2.length-1]= '1';
                else switches2[switches2.length-1] = '0';
                count2++;
        }
        if(String.valueOf(switches2).equals(lights)){
            answer = Math.min(answer, count2);
        }

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }
}
