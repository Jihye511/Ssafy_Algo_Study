    import java.util.*;
    import java.io.*;

    public class Main {
        static int N;
        public static void main(String[] args) throws Exception{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int num;

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                num = Integer.parseInt(br.readLine());
                if(num == 0){
                    if(pq.isEmpty()){
                        sb.append(0).append("\n");
                    }
                    else {
                        sb.append(pq.poll()).append("\n");
                    }
                }
                else {
                    pq.add(num);
                }
            }

            System.out.println(sb);
        }
    }
