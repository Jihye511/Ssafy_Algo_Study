import java.util.*;
import java.io.*;

//순위 & 문제
public class Main {

    static class Team implements Comparable<Team>{
        int team;
        int time;
        int score;
        int cnt;

        public Team(int team, int time, int score, int cnt) {
            this.team = team;
            this.time = time;
            this.score = score;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Team o) {
            if (o.score != this.score) {
                return o.score - this.score;
            }
            if (o.cnt != this.cnt) {
                return this.cnt - o.cnt;
            }
            return this.time - o.time;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()); //팀
            int K = Integer.parseInt(st.nextToken()); //문제 개수
            int my = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] scoresPerTeam = new int[N+1][K+1]; //각 팀의 문제별 점수
            int[] submitCount = new int[N+1]; //각 팀당 제출 횟수
            int[] time = new int[N+1]; //제출 시간

            for (int p = 0; p < m; p++) {
                st = new StringTokenizer(br.readLine());
                int id = Integer.parseInt(st.nextToken());
                int problem = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());

                submitCount[id] += 1;
                time[id] = p;

                //문제 최고점 갱신
                if (scoresPerTeam[id][problem] < score) scoresPerTeam[id][problem] = score;
            }

            //최종 팀 정보
            List<Team> teams = new ArrayList<>();

            for (int j = 1; j <= N; j++) {
                //팀 당 총점 계산
                int sum = 0;
                for (int k = 1; k <= K; k++) {
                    sum += scoresPerTeam[j][k];
                }
                teams.add(new Team(j,time[j],sum,submitCount[j]));
            }

            Collections.sort(teams);

            int rank = 1;
            for (Team t : teams) {
                if (t.team == my) {
                    System.out.println(rank);
                    break;
                }
                rank++;
            }

        }
    }
}
