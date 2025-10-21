import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[] costs;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        costs = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = 0;
        int end = 0;
        int num;
        for(int i = 0; i < N; i++){
            num = Integer.parseInt(st.nextToken());
            if (num > end) end = num;
            costs[i] = num;
        }

        M = Integer.parseInt(br.readLine());
        int mid = 0;
        int temp;
        int result = 0;
        while(start <= end){
            mid = (start + end) / 2;

            temp = sum(mid);
            if(temp > M) {
                end = mid-1;
            }
            else{
                result = mid;
                start = mid+1;
            }


        }
        System.out.println(result);


    }
    public static int sum(int midnum){
        int result = 0;
        for(int k : costs){
            if(k > midnum){
                result += midnum;
            }
            else{
                result += k;
            }
        }
        return result;
    }
}
