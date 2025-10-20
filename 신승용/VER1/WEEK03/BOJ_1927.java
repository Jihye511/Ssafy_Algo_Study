import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1927 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int cmd = Integer.parseInt(br.readLine());
            if(cmd == 0){
                if(pq.size() > 0){
                    sb.append(pq.poll()+"\n");
                } else {
                    sb.append(0  + "\n");
                }
            } else {
                pq.offer(cmd);
            }
        }

        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }
}
