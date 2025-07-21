import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q3758 {
	
	public static class team {
		
		int id, last_commit, cnt;
		int[] scores;
		
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		for(int test_case = 0; test_case < T; test_case++) {
			
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());		// 총 팀
			int k = Integer.parseInt(st.nextToken());		// 문제 개수
			int t = Integer.parseInt(st.nextToken());		// 내 팀
			int m = Integer.parseInt(st.nextToken());		// 로그 개수
			
			team[] teams = new team[n];
			for(int i = 0; i < n; i++) {
				teams[i] = new team();
				
				teams[i].id = i + 1;
				teams[i].scores = new int[k];
			}
			
			// 입력 순서 : 팀 , 문제 , 점수 순으로 주어진다.
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				
				int now_team = Integer.parseInt(st.nextToken()) - 1;
				int now_quiz = Integer.parseInt(st.nextToken()) - 1;
				int now_score = Integer.parseInt(st.nextToken());
				
				teams[now_team].last_commit = i;
				teams[now_team].scores[now_quiz] = Math.max(now_score, teams[now_team].scores[now_quiz]);
				teams[now_team].cnt++;
				
			}
			
			Arrays.sort(teams, ((o1, o2) -> {
				int o1_sum = Arrays.stream(o1.scores).sum();
				int o2_sum = Arrays.stream(o2.scores).sum();
				
				if(o1_sum != o2_sum) return Integer.compare(o2_sum, o1_sum);
				else if(o1.cnt != o2.cnt) return Integer.compare(o1.cnt, o2.cnt);
				else return Integer.compare(o1.last_commit, o2.last_commit);
			}));
			
			for(int j = 0; j < n; j++) {
				
				if(teams[j].id == t) {
					sb.append(j+1).append('\n');
				}
				
			}
				
		}
		
		System.out.print(sb.toString());
	}

}
