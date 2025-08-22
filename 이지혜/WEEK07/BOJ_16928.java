import java.io.*;
import java.util.*;
public class Main {
    static int N,M;
    static class Node{
        int pos,cnt;
        public Node(int pos,int cnt){
            this.pos=pos;
            this.cnt=cnt;
        }
    }
    static HashMap<Integer,Integer> ladder =new HashMap<>();
    static HashMap<Integer,Integer> snake =new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            ladder.put(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            snake.put(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }


        System.out.println(countDice());

    }
    static boolean[] visited=new boolean[101];
    public static int countDice(){
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.cnt-b.cnt);
        pq.offer(new Node(1,0));
        visited[1]=true;

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(cur.pos >=100) {
                return cur.cnt;
            }
            //+6이내에 뱀 있으면 무시
            //+6이내에 사다리있으면 그 이후 값 넣고
            //+6이내에 나머지 값 넣기
            for(int i =1; i<=6; i++){
                int next = cur.pos + i;
                if(visited[next])continue;

                if(next >=100) return cur.cnt+1;
                else if(snake.containsKey(next) && !visited[snake.get(next)]) { //뱀타고 내려가.. 도착지점 방문 안했으면
                    if(snake.get(next) >=100) return cur.cnt+1;
                    visited[next]=true;
                    visited[snake.get(next)]=true;
                    pq.offer(new Node(snake.get(next),cur.cnt+1));
                }
                else if(ladder.containsKey(next) && !visited[ladder.get(next)]){
                    if(ladder.get(next) >=100) return cur.cnt+1;
                    visited[next]=true;
                    visited[ladder.get(next)]=true;
                    pq.offer(new Node(ladder.get(next),cur.cnt+1));
                }else if(!snake.containsKey(next) && !ladder.containsKey(next)){
                    visited[next]=true;
                    pq.offer(new Node(next,cur.cnt+1));
                }
            }

        }
        return 0;
    }

}
