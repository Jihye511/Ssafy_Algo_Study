package boj;

import java.util.*;
import java.io.*;

public class BOJ_20055 {
    static int N, K;
    static int[] belt;
    static Queue<Integer> robots = new ArrayDeque<>();
    static boolean[] v;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        belt = new int[2*N];
        v = new boolean[2*N];
        for(int i=0;i<2*N;i++){
            belt[i] = Integer.parseInt(st.nextToken());
        }
        int ans = 0;
        while(true){
            if(!check_K()){
                break;
            }
            rotate();
            robot_Move();
            robot();
            ans += 1;

        }
        System.out.println(ans);
    }

    private static boolean check_K() {
        int cnt = 0;
        for(int i=0;i<2*N;i++){
            if(belt[i]<=0){
                cnt++;
            }
        }
        if(cnt>=K){
            return false;
        }else{
            return true;
        }
    }

    private static void robot() {
        if(belt[0] > 0){
            belt[0] -= 1;
            robots.add(0);
            v[0] = true;
        }
    }

    private static void robot_Move() {
        int size = robots.size();
        for(int i = 0; i < size; i++) {
            int temp = robots.poll();
            v[temp] = false;
            if(!v[temp + 1] && belt[temp + 1] > 0) {
                belt[temp + 1] -= 1;
                if (temp + 1 != N - 1) {

                    v[temp + 1] = true;
                    robots.add(temp + 1);
                }
            }
            else{
                robots.add(temp);
                v[temp] = true;
            }
        }
    }

    private static void rotate() {
        int save = belt[2*N-1];
        for(int i=2*N-1;i>=1;i--){
            belt[i] = belt[i-1];
        }
        belt[0] = save;
        int size = robots.size();
        for(int i = 0; i < size; i++){
            int temp = robots.poll();
            v[temp] = false;
            if(temp != N-2){
                robots.add(temp+1);
                v[temp+1] = true;
            }

        }

    }
}

