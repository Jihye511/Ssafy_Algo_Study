import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21921 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int max = 0;
        int maxCnt = 0;
        int window = 0;
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(i < X){
                window += arr[i];
            }
        }

        max = window;
        maxCnt = 1;

        for (int i = X; i < N; i++) {
            // 맨 앞 삭제
            window -= arr[i-X];
            // 맨 뒤 하나 추가
            window += arr[i];

            if(max < window){
                max = window;
                maxCnt = 1;
            } else if(max == window){
                maxCnt++;
            } 

        }

        if(max == 0){
            System.out.println("SAD");
            return;
        }

        System.out.println(max);
        System.out.println(maxCnt);
    }
}
