import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());	
        int[] line = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            int big = Integer.parseInt(st.nextToken());
            int count = -1;

            for(int j = 0; j < N; j++){
                if(line[j]==0) count++;
                if(count==big) {
                    line[j] = i;
                    break;
                }
            }
        }
       for(int i = 0; i < N; i++){
           System.out.print(line[i] + " ");
       }
    }


}
