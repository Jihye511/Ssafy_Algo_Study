import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] sushi = new int[N];
        List<Integer> round = new ArrayList<>();
        int[] cnt = new int[d+1];

        for(int i=0;i<N;i++){
            sushi[i] = Integer.parseInt(br.readLine());
        }
        for(int i=N-k+1;i<N;i++){
            round.add(sushi[i]);
        }
        for(int i=0;i<N;i++){
            round.add(sushi[i]);
        }
        for(int i=0;i<k;i++){
            round.add(sushi[i]);
        }

        int count = 0;
        for (int i = 0; i < k; i++) {
            if(cnt[round.get(i)] == 0) count++;
            cnt[round.get(i)]++;
        }
        int ans = Integer.MIN_VALUE;
        int max = count + (cnt[c] == 0 ? 1 : 0);
        ans = max;
        for(int i=k;i<round.size();i++){
            cnt[round.get(i-k)]--;
            if(cnt[round.get(i-k)] == 0) count--;
            if(cnt[round.get(i)] == 0) count++;
            cnt[round.get(i)]++;
            max = count + (cnt[c] == 0 ? 1 : 0);
            ans = Math.max(ans, max);
        }

        System.out.println(ans);
    }
}
