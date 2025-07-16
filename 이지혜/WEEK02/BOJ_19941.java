import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String str = br.readLine();
        char[] arr = str.toCharArray();
        boolean[] visited = new boolean[N];
        int num=0;
        for(int i =0; i<N; i++){
            if(arr[i] =='H') continue;
                for(int j =-K; j<=K; j++){
                    int idx = i +j;
                    if(idx <0 || idx>=N )continue;
                    if(arr[idx] == 'H' && !visited[idx]){
//                        System.out.println("i: " +i + " idx : " +idx);
                        visited[idx] = true;
                        num++;
                        break;
                    }
                }
            }
        System.out.println(num);
    }
}
