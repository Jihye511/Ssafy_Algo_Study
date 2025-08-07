import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] num = new int[N];
        st = new StringTokenizer(br.readLine());
        int max =0;
        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(st.nextToken());
            max = Math.max(num[i], max);
        }
        int start=0;
        int end =0;
        int len = 0;
        int[]cnt = new int[max+1];
        while(end<N ){
            cnt[num[end]]++;

            while(cnt[num[end]] >K){
                cnt[num[start]]--;
                start++;
            }

            len = Math.max(len,end-start+1);
            end++;
        }
        System.out.println(len);

    }
}
