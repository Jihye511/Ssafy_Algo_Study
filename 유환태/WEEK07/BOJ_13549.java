package boj;

import java.util.*;
import java.io.*;

public class BOJ_13549 {
    static class Node{
        int p;
        int t;
        Node(int p,int t){
            this.p=p;
            this.t=t;
        }
    }
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(N,0));
        boolean[] visited = new boolean[100001];
        visited[N]=true;
        while(!q.isEmpty()){
            Node cur = q.poll();

            if(cur.p==K){
                ans = Math.min(ans,cur.t);
                break;
            }

            if( 0 <= cur.p*2 && cur.p*2 <= 100000 && !visited[cur.p*2]){
                visited[cur.p*2] = true;
                q.add(new Node(cur.p*2,cur.t));

            }
            if(0 <= cur.p-1 && cur.p-1 <= 100000 && !visited[cur.p-1]){
                visited[cur.p-1]=true;
                q.add(new Node(cur.p-1,cur.t+1));
            }
            if(0 <= cur.p+1 && cur.p+1 <= 100000 && !visited[cur.p+1]){
                visited[cur.p+1]=true;
                q.add(new Node(cur.p+1,cur.t+1));
            }


        }
        System.out.println(ans);
    }


}
