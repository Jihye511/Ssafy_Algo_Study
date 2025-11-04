import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int N = Integer.parseInt(br.readLine());
long[] road = new long[N-1];
long[] gas = new long[N];
long result=0;
StringTokenizer st = new StringTokenizer(br.readLine());
for(int i=0;i<N-1;i++){
    road[i] = Integer.parseInt(st.nextToken());
}
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            gas[i] = Integer.parseInt(st.nextToken());
        }
        int cnt=1;
        long gascheck=0;
        gascheck=gas[0];
       result+=gas[0]*road[0];
        for(int i=0;i<N-2;i++){
            if(gascheck>=gas[i+1]){
                gascheck=gas[i+1];
                result+=gascheck*road[cnt];
            }
            else{
                result+=gascheck*road[cnt];
            }
            cnt++;
        }
        System.out.println(result);
    }
}
