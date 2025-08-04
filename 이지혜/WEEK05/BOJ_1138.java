import java.io.*;
import java.text.CollationElementIterator;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[N+1];
        int [] position = new int[N+1];
        Arrays.fill(position, 0);
        for(int i = 1; i <= N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i <= N; i++){
            int cnt = num[i];
            int idx =1;
            boolean check = false;
            while(!check){
                if(cnt == 0){ // 젤 앞부터 채우기
                    for(int j = idx; j <= N; j++){
                        if(position[j] == 0){
                            position[j] = i;
                            check = true;
                            break;
                        }
                    }
                }else if(cnt>0 && position[idx] == 0){
                    cnt--;
                    idx++;
                }else  if(cnt>0 && position[idx] !=0){
                    idx++;

                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i =1; i<=N; i++){
            sb.append(position[i]).append(" ");
        }
        System.out.println(sb);
    }
}
