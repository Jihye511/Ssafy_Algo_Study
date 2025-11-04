import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] budget = new int[N];
        int max_budget ;
        int count = N;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            budget[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(budget);
        st = new StringTokenizer(br.readLine());
        max_budget = Integer.parseInt(st.nextToken());

        int result = max_budget / N;
        int plus=0;
        for (int i = 0; i < N; i++) {
            if(budget[i]<result){
                count--;
                plus+=budget[i];
              // System.out.println(budget[i]);

            }
            else if(budget[i]>=result){
                result=((max_budget-plus)/count);
                if(budget[i]<result){
                    count--;
                    plus+=budget[i];

                }
                else{
                    break;
                }

            }

        }
        if(result>budget[N-1]){
            result=budget[N-1];
        }


        System.out.print(result);
    }
}
