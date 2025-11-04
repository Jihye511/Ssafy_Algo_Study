package 신승용.VER2.WEEK03;

import java.util.*;

class PGS_389479 {
    public int solution(int[] players, int m, int k) {
        Queue<Integer> queue = new ArrayDeque<>();
        int avail = 0;
        int answer = 0;

        for (int t = 0; t < players.length; t++) {
            
            if (queue.size() == k) {
                avail -= queue.poll();
            }

            int add = players[t] / m;
            
            if (avail < add) {
                int diff = add - avail;
                queue.offer(diff);
                
                avail += diff;
                answer += diff;
            } else {
                queue.offer(0);
            }
        }
        return answer;
    }
}
