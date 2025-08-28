import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static class Node{
        int end;
        int v;
        int cnt;
        public Node(int end, int v,int cnt){
            this.end = end;
            this.v = v;
            this.cnt = cnt; // 누적 여물
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ArrayList<Node>[] list = new ArrayList[N+1];
        for(int i =1; i<N+1; i++){
            list[i] = new ArrayList<>();
        }

        int[] w = new int[N+1];
        Arrays.fill(w, Integer.MAX_VALUE);
        for(int i =0; i<M; i++){
            st= new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cow = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b,cow,Integer.MAX_VALUE));
            list[b].add(new Node(a,cow,Integer.MAX_VALUE));
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]- b[1]);
        pq.offer(new int[]{1,0}); //출발지와 누적 값
        boolean[] v= new boolean[N+1];
        v[1] = true;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(cur[0] ==N) {
                System.out.println(cur[1]);
                return;
            }
            for(int i =0; i<list[cur[0]].size(); i++){
                int next = list[cur[0]].get(i).end;
                int value = list[cur[0]].get(i).v;
                if(w[next] >cur[1] + value){
                    w[next] =cur[1] + value;
                    pq.offer(new int[]{next, cur[1] + value});
                }
            }
        }
    }
}
