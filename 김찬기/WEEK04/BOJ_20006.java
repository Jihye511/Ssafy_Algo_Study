package WEEK04;

import java.io.*;
import java.util.*;

public class BOJ_20006 {

    static int P, M;
    static List<Room> rooms;

    static class Player {
        int lv;
        String name;

        public Player() {}
        public Player(int lv, String name) {
            this.lv = lv;
            this.name = name;
        }
    }

    static class Room {
        int roomLv;
        boolean isStarted;
        List<Player> players;

        public Room() {}
        public Room(Player player) {
            this.roomLv = player.lv;
            this.players = new ArrayList<>();
            input(player);
        }

        public void input(Player player) {
            this.players.add(player);
            if (this.players.size() == M) {
                isStarted = true;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        P = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        rooms = new ArrayList<>();

        for (int p=0; p<P; ++p) {
            st = new StringTokenizer(br.readLine());
            int lv = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            Player player = new Player(lv, name);

            find(player);
        }

        StringBuilder sb = new StringBuilder();
        for (Room room : rooms) {
            if (room.isStarted) {
                sb.append("Started!\n");
            }
            else {
                sb.append("Waiting!\n");
            }

            Collections.sort(room.players, (o1, o2) -> o1.name.compareTo(o2.name));
            for (Player player : room.players) {
                sb.append(player.lv).append(" ").append(player.name).append("\n");
            }

        }
        System.out.println(sb);

    }

    public static void find(Player player) {

        boolean isPossible = false;

        for (Room room : rooms) {
            if (chk(player.lv, room.roomLv) && !room.isStarted) {
                isPossible = true;
                room.input(player);
                break;
            }
        }

        if (!isPossible) {
            rooms.add(new Room(player));
        }
    }

    public static boolean chk(int pLv, int rLv) {
        return rLv-10 <= pLv && pLv <= rLv+10;
    }
}
