package 신승용.WEEK06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17615 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        String s = br.readLine().trim();

        int totalR = 0, totalB = 0;
        for (int i = 0; i < N; i++) {
            if (s.charAt(i) == 'R') totalR++;
            else totalB++;
        }

        int leftR = 0; 
        
        while (leftR < N && s.charAt(leftR) == 'R') {
            leftR++;
        }

        int leftB = 0; 
        
        while (leftB < N && s.charAt(leftB) == 'B') {
            leftB++;
        }

        int rightR = 0; int i = N - 1;

        while(i >= 0 && s.charAt(i) == 'R') {
            rightR++; i--; 
        }

        int rightB = 0; i = N - 1; 

        while (i >= 0 && s.charAt(i) == 'B') { 
            rightB++; i--; 
        }

        int moveRLeft  = totalR - leftR;
        int moveRRight = totalR - rightR;
        int moveBLeft  = totalB - leftB;
        int moveBRight = totalB - rightB;

        int answer = Math.min(Math.min(moveRLeft, moveRRight),Math.min(moveBLeft, moveBRight));

        System.out.println(answer);
    }
}
