import java.io.*;
import java.util.*;

public class Q1927 {

	public static void main(String[] args) throws IOException {

		 BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		 StringBuilder sb = new StringBuilder();
		 
		 int N = Integer.parseInt(br.readLine());
		 PriorityQueue<Integer> pq = new PriorityQueue<>();
		 
		 int now = 0;
		 for(int i = 0; i< N; i++) {
			 now = Integer.parseInt(br.readLine());
			 //System.out.println(now); 
			 
			 if(now == 0) {
				 if(pq.isEmpty()) sb.append('0').append('\n');
				 else sb.append(pq.poll()).append('\n');
			 }else {
				 pq.add(now);
			 }
			 
		 }
		 
		 System.out.println(sb);
	}

}
