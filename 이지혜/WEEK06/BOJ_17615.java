import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        boolean[] color = new boolean[str.length()];

        for(int i =0; i<str.length(); i++) {
            if (str.charAt(i) == 'R') {
                //R일때 true
                color[i] = true;
            }else color[i] = false;
        }
        int size = str.length();
        //R을 맨 오른쪽으로
        boolean change = false;
        int minValue =Integer.MAX_VALUE;
        int  temp =0;
        for(int i =size-1; i>=0; i--){
            if(!change && color[i]) continue;
            else if(!change && !color[i]) {
                change = true; //이제부터는 r 카운트
            }else if(change){
                if(color[i]) temp++;
            }
        }
        minValue = Math.min(minValue, temp);
        temp =0;
        change = false;
        //R을 맨 왼쪽
        for(int i =0; i<size; i++){
            if(!change && color[i]) continue;
            else if(!change && !color[i]) {
                change = true; //이제부터는 r 카운트
            }else if(change){
                if(color[i]) temp++;
            }
        }
        minValue = Math.min(minValue, temp);
        temp =0;
        change = false;
        //B을 맨 오른쪽
        for(int i =size-1; i>=0; i--){
            if(!change && !color[i]) continue;
            else if(!change && color[i]) {
                change = true; //이제부터는 r 카운트
            }else if(change){
                if(!color[i]) temp++;
            }
        }

        minValue = Math.min(minValue, temp);
        temp =0;
        change = false;
        //B를 맨 왼쪽
        for(int i =0; i<size; i++){
            if(!change && !color[i]) continue;
            else if(!change && color[i]) {
                change = true; //이제부터는 r 카운트
            }else if(change){
                if(!color[i]) temp++;
            }
        }
        minValue = Math.min(minValue, temp);

        System.out.println(minValue);


    }
}
