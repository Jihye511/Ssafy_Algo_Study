package 신승용.VER2.WEEK02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2343 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] videos = new int[N];

        int left = 0;
        int right = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            videos[i] = Integer.parseInt(st.nextToken());
            left = Math.max(videos[i], left);
            right += videos[i];
        }

        int answer = 0;

        while(left <= right){
            int mid = (left + right) / 2;

            int temp = 0;
            int tempCnt = 1;

            for (int i = 0; i < N; i++) {
                if(temp + videos[i] > mid){
                    temp = videos[i];
                    tempCnt++;
                } else {
                    temp += videos[i];
                }
            }

            if(tempCnt <= M) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            
        }

        System.out.println(answer);
    }
}