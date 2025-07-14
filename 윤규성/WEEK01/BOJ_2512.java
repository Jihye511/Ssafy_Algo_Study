import java.io.*;
import java.util.*;

public class BOJ_2512 {

    public static int N, T;
    public static int[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        int l = 0;
        int r = arr[N-1];
        int m = 0;

        while(l < r) {

            m = (l + r + 1) / 2;
            int rest = distribute(m);
            if(rest >= 0){       // 상한액이 높
                l = m;
            }else {             // 상한액이 낮거나 적절
                r = m - 1;
            }
        }

        System.out.println(r);
    }

    public static int distribute(int high){
        int total = T;

        for(int i = 0; i<N; i++){
            if(high > arr[i]) total -= arr[i];
            else total -= high;
        }

        return total;
    }
}
