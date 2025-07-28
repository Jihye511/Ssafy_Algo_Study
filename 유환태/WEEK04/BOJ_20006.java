import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static class Player implements Comparable<Player> {
        int level;
        String id;
        Player(int level, String id){
            this.level = level;
            this.id = id;
        }

        @Override
        public int compareTo(Player o) {
            return this.id.compareTo(o.id);
        }
        
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        List<List<Player>> rooms = new ArrayList<>();
        List<Player> first = new ArrayList<>();
        
        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < p; i++){
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String id = st.nextToken();
            if(rooms.isEmpty()){
                rooms.add(new ArrayList<>());
                rooms.get(0).add(new Player(level, id));
                first.add(new Player(level, id));
            }else{
                boolean join = false;
                for(int j = 0; j < first.size(); j++){
                    Player standard = first.get(j);
                    if(Math.abs(standard.level - level)<= 10 && rooms.get(j).size()<m){
                        rooms.get(j).add(new Player(level, id));
                        join = true;
                        break;
                    }
                }
                if(!join){
                    rooms.add(new ArrayList<>());
                    rooms.get(first.size()).add(new Player(level, id));
                    first.add(new Player(level, id));
                }
            }
        }
        for(List<Player> room: rooms){
            if(room.size()==m){
                System.out.println("Started!");
                PriorityQueue<Player> pq = new PriorityQueue<>();
                
                for(Player cur : room){
                    pq.add(cur);
                }
                while(!pq.isEmpty()){
                    Player cur2 = pq.poll();
                    System.out.println(cur2.level + " " + cur2.id);
                }
            }else{
                System.out.println("Waiting!");
                PriorityQueue<Player> pq = new PriorityQueue<>();
                
                for(Player cur : room){
                    pq.add(cur);
                }
                while(!pq.isEmpty()){
                    Player cur2 = pq.poll();
                    System.out.println(cur2.level + " " + cur2.id);
                }
            }
        }
        
    }
}