package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1927 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> que = new PriorityQueue<>();
		for (int i=0; i<N; i++) {
			int n = Integer.parseInt(br.readLine());
			
			if (n==0) {
				if (que.isEmpty()) sb.append(0).append("\n");
				else sb.append(que.poll()).append("\n");
			}
			else que.add(n);
		}
		
		System.out.println(sb.toString());
	}
}
