import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int arr[] = new int[N];
        for (int i = 0; i <N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Queue<Integer> q = new ArrayDeque<>();
        int max = 0;
        int sum = 0;
        int cnt = 0;
        for(int tmp : arr){
            sum += tmp;
            q.add(tmp);
            if (q.size()>X){
                sum-=q.poll();
            }
            if(q.size()!=X)continue;
            if (max == sum)cnt++;
            else if (max<sum) {
                max = sum;
                cnt = 1;
            }
        }
        if (max == 0){
            System.out.println("SAD");
            return;
        }
        System.out.print(max+"\n"+cnt);
    }
}
