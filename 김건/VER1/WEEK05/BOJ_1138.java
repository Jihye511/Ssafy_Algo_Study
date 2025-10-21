package Baekjoon.WEEK5;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1138 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        int[] ans = new int[N];
        for (int i =0; i<N; i++) {
            arr[i] = i;
        }

        for (int i =0; i<N; i++) {
            int n = Integer.parseInt(st.nextToken());
            for (int j=0; j<N; j++) {
                if (arr[j]==n) {
                    ans[j] = i+1;
                    arr[j] = -1;
                    for (int k=j+1; k<N; k++) {
                        if (arr[k]>0) arr[k]--;
                    }
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(ans[0]);
        for (int i = 1; i< N; i++) {
            sb.append(' ').append(ans[i]);
        }
        System.out.println(sb.toString());
    }
}
