import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] intArr = new int[N+1];
        int[] answer = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
for(int i=1;i<=N;i++){
    intArr[i]=Integer.parseInt(st.nextToken());
}
        for(int i=1;i<=N;i++){
            int j=1;

            while(true){
                if(intArr[i]==0&&answer[j]==0){
                    answer[j]=i;
                    break;
                }
                else if(answer[j]==0) {
                    intArr[i]--;
                }
                    j++;
                
            }


        }
        for(int i = 1; i<=N; i++)
            System.out.print(answer[i] +" ");
    }
}
