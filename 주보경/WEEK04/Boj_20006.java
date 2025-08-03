import java.util.*;
import java.io.*;

public class Main {
    static class Room {
        int order;
        List<Player> players;
        int level;

        class Player implements Comparable<Player>{
            String name;
            int level;

            public Player(String name, int level) {
                this.name = name;
                this.level = level;
            }

            public int compareTo(Player p) {
                return name.compareTo(p.name);
            }
        }
        public Room(int order, int level) {
            this.order = order;
            this.players = new ArrayList<>();
            this.level = level;
        }

        public void add(String name, int level) {
            this.players.add(new Player(name,level));
        }
    }
    public static void main(String[] args) throws Exception {
        //먼저 생성된 방
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int MAX = Integer.parseInt(st.nextToken());

        List<Room> rooms = new ArrayList<>();
        Boolean isEnter;
        for (int i = 0; i < N; i++) {
            isEnter = false;
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            if (rooms.isEmpty()) {
                Room room = new Room(i,level);
                room.add(name,level);
                rooms.add(room);
                continue;
            }

            for (Room r : rooms) {
                if (r.players.size() < MAX && Math.abs(level - r.level) <= 10) {
                    r.add(name,level);
                    isEnter = true;
                    break;
                }
            }

            if (!isEnter) {
                Room room = new Room(i,level);
                room.add(name,level);
                rooms.add(room);
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (Room r : rooms) {
            if (r.players.size() == MAX) {
                bw.write("Started!");
            }
            else {
                bw.write("Waiting!");
            }
            bw.newLine();

            Collections.sort(r.players);
            for (Room.Player p : r.players) {
                bw.write(p.level + " " + p.name);
                bw.newLine();
            }
        }
        bw.flush();
    }
}
