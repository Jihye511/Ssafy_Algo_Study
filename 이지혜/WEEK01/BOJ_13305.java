import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[] cost; // 리터당 비용
    static int[] dist; // 인접 거리
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dist = new int[N-1];
        cost = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N-1; i++){
            dist[i] = Integer.parseInt(st.nextToken());
        }
        st= new  StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }
        long m = 0;
        long minValue = cost[0];
        for(int i = 0; i < N-1; i++){

            if(minValue>cost[i]){
                minValue = cost[i];
            }
            m +=minValue*(long) dist[i];
        }

        System.out.println(m);
    }
}
