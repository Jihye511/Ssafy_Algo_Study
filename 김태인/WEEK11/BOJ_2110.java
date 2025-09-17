import java.util.*;
import java.io.*;

public class Main {

    static int N, C, result;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        result = 0;
        binary();


    }

    public static void binary(){
        int left = 1;
        int right = arr[N-1] - arr[0];

        while (left <= right){
            int mid = (left + right) / 2;
            if(count(mid)){
                result = mid;
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        System.out.println(result);


    }

    public static boolean count(int mid){
        int cnt = 1;
        int last = arr[0];
        for (int i = 1; i < N; i++) {
            if(arr[i] - last >= mid){
                cnt++;
                last = arr[i];
            }
        }

        return cnt >= C;
    }
}
