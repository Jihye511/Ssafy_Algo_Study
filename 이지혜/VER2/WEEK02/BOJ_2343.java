import java.io.*;
import java.util.*;
public class Main {
    static int sum,N,M;
    static int[] num;
    static int small;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new  StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        small = Integer.MIN_VALUE;
        st = new   StringTokenizer(br.readLine());
        num = new int[N];
        sum=0;
        for(int i =0; i<N; i++){
           num[i] = Integer.parseInt(st.nextToken());
           sum += num[i];
           small = Math.min(small,num[i]);
        }

        System.out.println(binary());

    }
    public static long binary(){
        long s =0;
        long e = sum+1;
        while(s<e){
            long mid = (e-s)/2 + s;
            if(countB(mid)>M){
                s = mid+1;
            }else{
                e = mid;
            }
        }
        return s;
    }
    public static int countB(long size){
        if(size <small) return Integer.MAX_VALUE;
        int[] blue = new int[N+1];
        int idx=0;
        Arrays.fill(blue,0);
        for(int i =0; i<N; i++){
            while(true){
                if(blue[idx] + num[i] <=size){
                    blue[idx] += num[i];
                    break;
                }else{
                    idx++;
                }
                if(size < num[i]){
                    return Integer.MAX_VALUE;
                }
            }

        }
        return idx+1;
    }
}
