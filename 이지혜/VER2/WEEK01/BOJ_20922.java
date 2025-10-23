import java.io.*;
import java.util.*;
public class Main {
    static int[][] map;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new  StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st =new  StringTokenizer(br.readLine());
        int[] cnt = new int[100001];
        int[] num = new int[N];
        for(int i =0; i<N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        int value = 0;
        Arrays.fill(cnt, 0);
        int s = 0;
        int e = 0;
        while(e<N){
            cnt[num[e]]++;
                //k중복 이상
            while(cnt[num[e]]>K){
                cnt[num[s]]--;
                s++;

            }

            value = Math.max(value, e-s+1);
            e++;
        }

        System.out.println(value);
    }
}
