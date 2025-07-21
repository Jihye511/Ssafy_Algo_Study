package WEEK03;

import java.io.*;
import java.util.*;

public class BOJ_3758 {

    static int N, K, T, M;

    static class Team implements Comparable<Team> {
        int id;
        boolean[] solved;
        int[] scores;
        int total;
        int cnt;
        int time;

        Team() {
            solved = new boolean[K+1];
            scores = new int[K+1];
        }

        public void update(int num, int score, int time) {
            if (!solved[num]) {
                solved[num] = true;
                scores[num] = score;
                total += score;
            }
            else {
                if (scores[num] < score) {
                    total += (score - scores[num]);
                    scores[num] = score;
                }
            }
//            System.out.println("팀: " + id + " / 점수: " + total);
            ++cnt;
            this.time = time;
        }

        @Override
        public int compareTo(Team o) {
            if (this.total == o.total) {
                if (this.cnt == o.cnt) {
                    return Integer.compare(this.time, o.time);
                }

                return Integer.compare(this.cnt, o.cnt);
            }

            return Integer.compare(o.total, this.total);
        }

        @Override
        public String toString() {
            return "팀: " + id + " / 점수: " + total + " / 개수: " + cnt + " / 타임: " + time + "\n배열: " + Arrays.toString(scores);
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Ts = Integer.parseInt(br.readLine());
        for (int t=0; t<Ts; ++t) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 팀 개수
            K = Integer.parseInt(st.nextToken()); // 문제 개수
            T = Integer.parseInt(st.nextToken()); // 팀 ID
            M = Integer.parseInt(st.nextToken()); // 로그 개수

            Map<Integer, Team> map = new HashMap<>();
            for (int m=0; m<M; ++m) {
                st = new StringTokenizer(br.readLine());
                int id = Integer.parseInt(st.nextToken());
                int num = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());

                if (map.containsKey(id)) {
                    Team curr = map.get(id);
                    curr.update(num, score, m);
                }
                else {
                    Team team = new Team();
                    team.id = id;
                    team.update(num, score, m);
                    map.put(id, team);
                }
            }

            Team me = map.get(T);
            int grade = 1;
            for (int key : map.keySet()) {
//                System.out.println(map.get(key));
                if (key == T) {
                    continue;
                }

                if (me.compareTo(map.get(key)) > 0) {
                    ++grade;
                }
            }

            System.out.println(grade);
        }
    }
}
