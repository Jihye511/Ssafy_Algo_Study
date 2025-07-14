import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21921 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] arr=  new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int now = 0;
        int max = 0;
        int cnt = 1;
        int j = X - 1;

        for (int i = 0; i < X; i++) {
            now += arr[i];
        } max = Math.max(now, max);

        for (int i = 0; i < N - X; i++) {

            now += arr[j + 1];
            now -= arr[i];

            if(max == now){
                cnt ++;
            }else if(max < now){
                cnt = 1;
                max = now;
            }

            j++;
        }

        if(max != 0) {
            System.out.println(max);
            System.out.print(cnt);
        }else{
            System.out.print("SAD");
        }

    }
}
