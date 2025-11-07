import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node>{
        long start, end;
        Node(long start, long end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node o){
            if(this.end == o.end) return Long.compare(this.start, o.start);
            return Long.compare(this.end, o.end);
        }
    }
    static int N, result;
    static ArrayList<Node> arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        result = 0;
        arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            arr.add(new Node(a, b));

        }

        Collections.sort(arr);
        long prev = 0;
        for (int i = 0; i < N; i++) {
            if(prev <= arr.get(i).start){
                result++;
                prev = arr.get(i).end;
            }

        }

        System.out.println(result);

    }
}
