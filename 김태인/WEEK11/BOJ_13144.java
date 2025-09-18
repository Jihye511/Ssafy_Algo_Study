import java.util.*;
import java.io.*;

public class Main {

    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long result = 0;
        boolean[] visited = new boolean[100001];

        int left = 0;
        int right = 0;

        while (right < N){
            if(!visited[arr[right]]){
                visited[arr[right]] = true;
                result += (right - left + 1);
                right++;
            }
            else{
                visited[arr[left]] = false;
                left++;
            }
        }

        System.out.println(result);

    }
}
