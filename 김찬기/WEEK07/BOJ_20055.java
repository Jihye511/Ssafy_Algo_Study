package WEEK07;

import java.io.*;
import java.util.*;

/**
 * 로봇을 올리거나 로봇이 이동하면 해당 칸의 내구도는 즉시 1만큼 감소
 * 1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다
 * 2. 가장 먼저 올라간 로봇부터, 회전 방향으로 이동할 수 있으면 이동
 * 2-1. 이동할 수 있다 = 이동하려는 칸에 로봇이 없으며 내구도가 1 이상
 * 3. 올리는 위치에서 내구도가 0이면 못 올림
 * 4. 내구도 0인 칸의 개수가 K개 이상이라면 종료
 * 종료했을 때 몇 번째 단계가 진행중이었는가? 시작 시 1단계
 */

public class BOJ_20055 {

    static class Belt {
        int num;
        boolean used;
        int life;

        public Belt() {}
        public Belt(int num, int life) {
            this.num = num;
            this.life = life;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Deque<Belt> upBelt = new ArrayDeque<>();
        Deque<Belt> downBelt = new ArrayDeque<>();
        List<Belt> beltList = new ArrayList<>();
        int num = 0;
        for (int i=0; i<N; ++i) {
            int life = Integer.parseInt(st.nextToken());
            Belt belt = new Belt(num++, life);
            upBelt.add(belt);
            beltList.add(belt);
        }

        for (int i=0; i<N; ++i) {
            int life = Integer.parseInt(st.nextToken());
            Belt belt = new Belt(num++, life);
            downBelt.addFirst(belt);
            beltList.add(belt);
        }

        int cnt = 0;
        int step = 0;
        while (cnt < K) {
            ++step;

            // 1. 벨트 이동
            Belt upToDown = upBelt.pollLast();
            upToDown.used = false;
            downBelt.addLast(upToDown);
            upBelt.peekLast().used = false;

            Belt downToUp = downBelt.pollFirst();
            upBelt.addFirst(downToUp);



            // 2. 로봇 이동
            int curr = upBelt.peekFirst().num;
//            System.out.println("cur: " + curr);
            for (int i=N-2; i>=0; --i) {
                int idx = (curr + i + 2*N) % (2*N);
//                System.out.println("idx: " + idx);
                Belt currBelt = beltList.get(idx);
                if (!currBelt.used) {
                    continue;
                }

                int nextIdx = (idx+1) % (2*N);
                Belt nextBelt = beltList.get(nextIdx);
                if (!nextBelt.used && nextBelt.life > 0) {
                    currBelt.used = false;
                    nextBelt.used = true;
                    --nextBelt.life;
                    if (nextBelt.life == 0) {
                        ++cnt;
                    }
                }
            }

            // 3. 로봇 올리기
            Belt peek = upBelt.peekFirst();
            if (peek.life > 0) {
                peek.used = true;
                --peek.life;
                if (peek.life == 0) {
                    ++cnt;
                }
            }
        }

        System.out.println(step);
    }
}
