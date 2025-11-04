package VER2.WEEK03;

import java.io.*;
import java.util.*;

class PGS_389479 {
    public int solution(int[] players, int m, int k) {
        int answer = 0;

        Queue<Integer> q = new ArrayDeque<>();
        for (int i=0; i<players.length; ++i) {
            while (!q.isEmpty() && i - q.peek() >= k) {
                q.poll();
            }
            int cnt = players[i] / m - q.size(); // 증설해야 하는 서버 개수
            // System.out.println(i + " , " + cnt + " , " + q.size());

            while (cnt > 0) {
                q.add(i);
                ++answer;
                --cnt;
            }
        }


        return answer;
    }
}