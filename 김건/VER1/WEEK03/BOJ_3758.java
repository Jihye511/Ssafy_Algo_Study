package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_3758 {
    static class Score implements Comparable<Score> {
        int score;
        int teamId;
        int submits;
        int seq;

        Score(int score, int teamId, int submits) {
            this.score = score;
            this.teamId = teamId;
            this.submits = submits;
        }

        public int compareTo(Score o) {
            if (o.score == this.score)
                if (o.submits == this.submits)
                    return Integer.compare(this.seq, o.seq);
                else
                    return Integer.compare(this.submits, o.submits);
            else
                return Integer.compare(o.score, this.score);
        }
    }

    static class Team implements Comparable<Team> {
        public int teamId;
        public int seq;

        Team(int teamId, int seq) {
            this.teamId = teamId;
            this.seq = seq;
        }
        public void setSeq(int seq) {
            this.seq = seq;
        }

        public int compareTo(Team o) {
            return Integer.compare(this.seq, o.seq);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine());
            int teamNum = Integer.parseInt(st.nextToken());
            int proNum = Integer.parseInt(st.nextToken());
            int myTeamId = Integer.parseInt(st.nextToken())-1;
            int logNum =  Integer.parseInt(st.nextToken());

            int[][] scores = new int[teamNum][proNum];
            int[] sunmits = new int[teamNum];
            Team[] teams = new Team[teamNum];

            for (int i = 0; i<teamNum; i++) {
                teams[i] = new Team(i, Integer.MAX_VALUE);
            }

            for (int i =0; i<logNum; i++) {
                st = new StringTokenizer(br.readLine());
                int teamId = Integer.parseInt(st.nextToken())-1;
                int proId = Integer.parseInt(st.nextToken())-1;
                int score = Integer.parseInt(st.nextToken());

                scores[teamId][proId] = Math.max(score, scores[teamId][proId]);
                sunmits[teamId]++;
                teams[teamId].seq = i;
            }

            Score[] totalScores = new Score[teamNum];

            for (int i=0; i<teamNum; i++) {
                int sum = 0;
                for (int j=0; j<proNum; j++) {
                    sum += scores[i][j];
                }
                totalScores[i] = new Score(sum, i, sunmits[i]);
            }

            Arrays.sort(teams);

            for (int i=0; i<teamNum; i++) {
                totalScores[teams[i].teamId].seq = i;
            }

            Arrays.sort(totalScores);

            for (int i=0; i<teamNum; i++) {
                if (totalScores[i].teamId == myTeamId) {
                    System.out.println(i+1);
                    break;
                }
            }

            System.out.println();
        }
    }
}
