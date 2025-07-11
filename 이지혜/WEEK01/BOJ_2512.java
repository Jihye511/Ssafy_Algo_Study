import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[]city;
    static int total;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        city = new int[N];
        for(int i=0;i<N;i++){
            city[i]=Integer.parseInt(st.nextToken());
        }
        total=Integer.parseInt(br.readLine());

        Arrays.sort(city);
        int max =0;
        if(city[N-1] * N <= total){
            max = city[N-1];
        }else{
            max = binary();
        }
        System.out.println(max);
    }
    public static int binary(){
        int lo =0;
        int hi = city[N-1];
        int result=0;

        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(cal(mid)> total){
                hi =mid -1;
            }else{
                result = mid;
                lo = mid+1;
            }
        }
        return result;
    }
    //합계산
    public static int cal(int mid){
        int hap = 0;
        for(int i =0; i<N; i++){
            if(city[i] <mid){
                hap+=city[i];
            }else{
                hap+=mid;
            }
        }
        return hap;
    }
}
