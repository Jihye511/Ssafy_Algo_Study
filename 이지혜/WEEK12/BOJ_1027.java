import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] building = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =1; i<=N; i++){
            building[i] = Integer.parseInt(st.nextToken());
        }
        int rightCnt=0;
        int leftCnt=0;
        int maxCnt = 0;
        for(int i =1; i<N+1; i++){
            double max = Integer.MIN_VALUE;
            int cnt =0;
            //왼쪽
            for(int j=i-1; j>=1; j--){
                double a = (double) (building[i] - building[j])/(i-j);
                if(j == i-1 || a< max){
                    cnt++;
                    max = a;
                }
            }
            max = Integer.MIN_VALUE;
            //오른쪽
            for(int j = i+1; j<=N; j++){
                double b = (double) (building[i] - building[j])/(i-j);
                if(j == i+1 || b >max){
                        cnt++;
                        max = b;
                }
            }
            maxCnt = Math.max(cnt, maxCnt);
        }
        System.out.println(maxCnt);

    }

}
