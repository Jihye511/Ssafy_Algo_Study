package Baekjoon.WEEK4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_20006 {
    static class Room {
        int lv;
        List<User> users = new LinkedList<>();

        Room(int lv) {
            this.lv = lv;
        }

        public void Clear() {
            this.lv = 0;
        }
    }

    static class User implements Comparable<User> {
        int lv;
        String name;

        User(int lv, String name) {
            this.lv = lv;
            this.name = name;
        }

        public int compareTo(User o) {
            return this.name.compareTo(o.name);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Room> rooms = new ArrayList<>();

        L:for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int lv = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            if (rooms.isEmpty()) {
                Room room = new Room(lv);
                room.users.add(new User(lv, name));

                rooms.add(room);
            }
            else {
                for (Room room : rooms) {
                    if (room.users.size()<M&&Math.abs(room.lv - lv) <= 10) {
                        room.users.add(new User(lv, name));

                        continue L;
                    }
                }

                Room room = new Room(lv);
                room.users.add(new User(lv, name));

                rooms.add(room);
            }
        }

        for (Room room : rooms) {
            if (room.users.size()==M) sb.append("Started!\n");
            else sb.append("Waiting!\n");

            Collections.sort(room.users);

            for (User user : room.users) {
                sb.append(user.lv).append(' ').append(user.name).append('\n');
            }
        }

        System.out.println(sb.toString());
    }
}
