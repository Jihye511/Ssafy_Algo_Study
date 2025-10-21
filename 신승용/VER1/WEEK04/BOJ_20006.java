package 신승용.WEEK04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_20006 {
    static class Player implements Comparable<Player>{
        int level;
        String nickname;

        Player(int level, String nickname){
            this.level = level;
            this.nickname = nickname;
        }

        @Override
        public int compareTo(Player o) {
            return this.nickname.compareTo(o.nickname);
        }
    }
    static class Room {
        int pivoitLevel;
        PriorityQueue<Player> pq;
        Room(int pivoitLevel){
            this.pivoitLevel = pivoitLevel;
            this.pq = new PriorityQueue<>();
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Room> list = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String nickname = st.nextToken();

            Player player = new Player(level, nickname);
            
            boolean inserted = false;
            
            for (Room room : list) {
                if (room.pq.size() < m
                        && Math.abs(room.pivoitLevel - level) <= 10) {
                    room.pq.offer(player);
                    inserted = true;
                    break;
                }
            }

            if (!inserted) {
                Room newRoom = new Room(level);
                newRoom.pq.offer(player);
                list.add(newRoom);
            }
        }

        StringBuilder sb = new StringBuilder();


        for (Room room : list) {
            if (room.pq.size() == m) {
                sb.append("Started!").append("\n");
            } else {
                sb.append("Waiting!").append("\n");
            }
            while (!room.pq.isEmpty()) {
                Player player = room.pq.poll();
                sb.append(player.level)
                  .append(" ")
                  .append(player.nickname)
                  .append("\n");
            }
        }

        System.out.print(sb);
    }
}
