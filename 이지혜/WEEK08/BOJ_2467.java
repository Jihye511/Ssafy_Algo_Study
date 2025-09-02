import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] req;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        req =new int[N];
        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++){
            req[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(req);
        int[] answer = binary();
        Arrays.sort(answer);
        System.out.println(answer[0]+" " + answer[1]);

    }
    static long min = Long.MAX_VALUE;
    public static int[] binary() {
        int[] ans = new int[2];
        int start = 0;
        int end = N-1;
        while (start < end) {
            long diff =(long) req[end] + req[start];
            if( Math.abs(diff) <min){
                ans[0] = req[start];
                ans[1] = req[end];
                min = Math.abs(diff);
            }
            if (diff < 0) {
                start++;
            } else {
                end--;
            }

        }
        return ans;
    }
}
