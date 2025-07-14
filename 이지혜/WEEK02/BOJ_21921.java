import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N, X;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N =Integer.parseInt(st.nextToken());
        X =Integer.parseInt(st.nextToken());

        arr = new int[N];
        int hap =0;
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(i <X) hap+=arr[i];
        }

        int max = hap;
        int count = 1;

        for (int i = X; i < N; i++) {
            hap = hap - arr[i - X] + arr[i];

            if (hap > max) {
                max = hap;
                count = 1;
            } else if (hap == max) {
                count++;
            }
        }
        StringBuilder sb = new StringBuilder();
        if(hap ==0){
            sb.append("SAD");
        }else{
            sb.append(max).append("\n");
            sb.append(count);
        }
        System.out.println(sb);
    }
}
