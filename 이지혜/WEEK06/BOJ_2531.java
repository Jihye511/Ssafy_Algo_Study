import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        ArrayList<Integer> idx = new ArrayList<>();
        int[] dish = new int[N];
        int[] count = new int[d+1];
        for(int i =0; i<N; i++){
            int n = Integer.parseInt(br.readLine());
            dish[i] = n;
        }

        int unique = 0;
        for(int i =0; i<k; i++){
            if(count[dish[i]]==0) unique++;
            count[dish[i]]++;
        }

        int max = unique + (count[c] ==0 ?1:0);

        for(int i =1; i<N; i++){
            //앞
            int remove = dish[i-1];
            count[remove]--;
            if(count[remove]==0) unique--;
            //뒤
            int add =dish[(i+k-1)%N];
            if(count[add] ==0) unique++;
            count[add]++;

            int currentMax = unique + (count[c] == 0 ? 1 : 0);
            max = Math.max(max,currentMax);
        }
        System.out.println(max);
    }
}
