import java.io.*;
import java.util.*;

public class Main {
    static class Team {
        int id;
        int[] scores;
        int submitCount;
        int lastSubmitTime;
        int totalScore;

        public Team(int id, int k) {
            this.id = id;
            this.scores = new int[k + 1];
            this.submitCount = 0;
            this.lastSubmitTime = 0;
            this.totalScore = 0;
        }

        public void submit(int problem, int score, int time) {
            if (score > scores[problem]) {
                totalScore += score - scores[problem];
                scores[problem] = score;
            }
            submitCount++;
            lastSubmitTime = time;
        }
    }
    static int n,k,t,m;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test=0; test<T; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            Team[] teams = new Team[n + 1];
            for (int i = 1; i <= n; i++) {
                teams[i] = new Team(i, k);
            }
            for (int M = 0; M < m; M++) {
                st = new StringTokenizer(br.readLine());
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                teams[i].submit(j,s, M+1);
            }

            List<Team> list = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                list.add(teams[i]);
            }
            list.sort((a, b) -> {
                if (b.totalScore != a.totalScore)
                    return b.totalScore - a.totalScore; // 총점 높은 순
                if (a.submitCount != b.submitCount)
                    return a.submitCount - b.submitCount; // 제출 횟수 적은 순
                return a.lastSubmitTime - b.lastSubmitTime; // 마지막 제출 빠른 순
            });
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).id == t) {
                    System.out.println(i + 1); // 등수는 1부터 시작
                    break;

                }
            }
        }
    }
}
