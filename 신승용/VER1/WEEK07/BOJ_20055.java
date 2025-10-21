package 신승용.WEEK07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20055 {
    static int count;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); 
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] belt = new int[2*N];
        int[] robots = new int[N];
        for (int i = 0; i < 2 * N; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        count = 0;
        int answer = 0;

        while (count < K) {
            answer++;
            rotateBelt(belt, robots);
            moveRobots(belt, robots);
            if(belt[0] > 0 && robots[0] == 0){
                robots[0] = 1;
                belt[0]--;
            }
            checkBelt(belt);        
        }

        System.out.println(answer);
    }

    static void checkBelt(int[] belt) {
        int count0 = 0;
        for (int i = 0; i < belt.length; i++) {
            if(belt[i] == 0){
                count0++;
            }
        }
        count = count0;
    }

    static void moveRobots(int[] belt, int[] robots) {
        for (int i = robots.length-2; i >=0; i--) {
            if(robots[i]>0){
                if(robots[i] == 1 && robots[i + 1] == 0 && belt[i+1]>0){
                    robots[i+1] = 1;
                    belt[i+1]--;
                    robots[i] = 0;
                }
            }
        }
    }

    static void rotateBelt(int[] belt, int[] robots) {
        int last = belt[belt.length-1];
        for (int i = belt.length-2; i >=0; i--) {
            belt[i+1] = belt[i];
        }
        for (int i = robots.length-2; i >= 0; i--) {
            robots[i+1] = robots[i];
        }
        belt[0] = last;
        robots[0] = 0;
        robots[robots.length-1] = 0;
    }
}