import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
     static class Rode implements Comparable<Rode>{
        int s;
        int e;
        int d;
        Rode(int s, int e, int d){
            this.s = s;
            this.e = e;
            this.d = d;
        }
        @Override
		public int compareTo(Rode o) {
			return this.d - o.d;
		}
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] dp = new int[D+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        List<Rode> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            if(e <= D && (e-s) > d) {
                list.add(new Rode(s,e,d));
            }
        }

        Collections.sort(list);

        for(int i = 0; i <= D; i++){
            if(i > 0) dp[i] = Math.min(dp[i], dp[i - 1] + 1);
        
            for(Rode r : list){
                if(r.s == i){
                    dp[r.e] = Math.min(dp[r.e], dp[i] + r.d);
                }
            }
        }

        System.out.println(dp[D]);
        
       
    }
}