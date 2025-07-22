package boj;

import java.util.*;

import java.io.*;

public class BOJ_3758 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    public static void main(String[] args) throws IOException {


        int T =  Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            contest();
        }
    }
    public static void contest() throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken())-1;
        int m = Integer.parseInt(st.nextToken());

        int[][] scores = new int[n][k];
        int[] count = new int[n];
        int[] submit = new int[n];

        for(int log=0;log<m;log++){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken())-1;
            int j = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken());

            scores[i][j] = Math.max(scores[i][j], s);
            count[i]++;
            submit[i] = Math.max(submit[i], log);
        }

        int myteam = 0;

        for(int i=0;i<k;i++){
            myteam += scores[t][i];
        }


        int ans = 0;


        for(int j=0;j<n;j++){
            if(j!=t){
                int sum = 0;
                for(int i=0;i<k;i++){
                    sum += scores[j][i];
                }

                if(myteam<sum){
                    ans++;
                }else if(myteam==sum){
                    if(count[t]>count[j]){
                        ans++;
                    }else if(count[t]==count[j]){
                        if(submit[t]>submit[j]){
                            ans++;
                        }
                    }
                }
            }

        }

        System.out.println(ans+1);
    }
}
