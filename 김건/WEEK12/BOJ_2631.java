package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2631 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		int[] length = new int[N];
		
		for (int i=0;i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i=0; i<N; i++) {
			length[i] = 1;
			for (int j=0; j<i; j++) {
				if (arr[j]<arr[i]) {
					length[i] = Math.max(length[i], length[j]+1);
				}
			}
		}
		
		int max = 0;
		for (int i=0; i<N; i++) {
			max = Math.max(max, length[i]);
		}
		System.out.println(N-max);
	}
}
