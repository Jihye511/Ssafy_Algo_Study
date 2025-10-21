package Baekjoon.WEEK7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_20055 {
    static int[] arr;
    static boolean[] v;
    static int N, K;

    static class Robot {
        int p;

        Robot(int p) {
            this.p = p;
            v[p] = true;
            arr[p]--;
        }

        public void move() {
            int nx = p+1 == 2*N ? 0 : p+1;
            if (!v[nx]&&arr[nx]>0) {
                v[p] = false;
                p = nx;
                v[p] = true;
                arr[p]--;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[2*N];
        v = new boolean[2*N];
        List<Robot> robots = new LinkedList<>();

        st = new StringTokenizer(br.readLine());

        for (int i =0; i<2*N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0;
        int e = N-1;

        int c = 0;

        do {
            c++;
            // 1. 컨베이어 벨트 이동
            s = move(s);
            e = move(e);
            // 끝에 도달한지 확인
            if (!robots.isEmpty()&&robots.getFirst().p == e) {
                robots.removeFirst();
                v[e] = false;
            }

            // 2. 로봇 이동
            for (Robot r: robots) {
                r.move();
            }

            // 끝에 도달한지 확인
            if (!robots.isEmpty()&&robots.getFirst().p == e) {
                robots.removeFirst();
                v[e] = false;
            }

            // 3. 로봇 올리기
            if (arr[s]>0) robots.add(new Robot(s));
        } while(validation());
        System.out.println(c);
    }

    static boolean validation() {
        int c=0;
        for (int i=0; i<2*N; i++) {
            if (arr[i]==0) c++;
        }

        if (c>=K) return false;
        else return true;
    }

    static int move(int p) {
        return --p < 0 ? 2*N-1 : p;
    }

}
