package boj;

import java.util.*;
import java.io.*;

public class BOJ_7682 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        while(true){
            String s = br.readLine();
            String ans = "valid";
            if(s.equals("end")){
                break;
            }else{
                int X_cnt = 0;
                int O_cnt = 0;
                int d_cnt = 0;
                for(int i = 0; i < s.length(); i++){
                    if(s.charAt(i) == 'X'){
                        X_cnt++;
                    }else if(s.charAt(i) == 'O'){
                        O_cnt++;
                    }else{
                        d_cnt++;
                    }
                }

                if(X_cnt == O_cnt || X_cnt - O_cnt == 1){


                    if(X_cnt - O_cnt == 1){
                        if(check('O', s)){
                            ans = "invalid";
                        }
                        if(!check('X', s) && d_cnt > 0){
                            ans = "invalid";
                        }
                    }else{
                        if(check('X', s) && check('O', s)){
                            ans = "invalid";
                        }else if(!check('X', s) && !check('O', s)){
                            ans = "invalid";
                        }else if(check('X', s)){
                            ans = "invalid";
                        }
                    }
                }else{
                    ans = "invalid";
                }
            }
            System.out.println(ans);
        }

    }

    private static boolean check(char mark, String s) {
        int[][] line = {{0,1,2}, {3,4,5}, {6,7,8}, {0,4,8}, {2,4,6}, {0,3,6},{1,4,7},{2,5,8}};
        boolean flag = false;
        for(int i = 0; i < line.length; i++){
            int cnt = 0;
            for(int num : line[i]){

                if(s.charAt(num)==mark){
                    cnt++;
                }
                if(cnt == 3){
                    flag = true;
                }
            }
        }
        return flag;
    }
}
