import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<N;i++){
            int input = Integer.parseInt(br.readLine());
            if(input>0){
                pq.add(input);
            }
            else{
                if(!pq.isEmpty()){
                    System.out.println(pq.poll());
                }
                else{
                    System.out.println(0);
                }
            }
        }

    }
}
