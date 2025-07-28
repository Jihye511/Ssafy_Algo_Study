import java.io.*;
import java.util.*;

public class Main {
    static class Player {
        int lv;
        String nickName;
        Player(int lv, String nickName) {
            this.lv = lv;
            this.nickName = nickName;
        }
    }

    static class Room {
        int baseLv;
        List<Player> list = new ArrayList<>();
        Room(int baseLv) { this.baseLv = baseLv; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int p = Integer.parseInt(st.nextToken()); 
        int m = Integer.parseInt(st.nextToken());

        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int lv = Integer.parseInt(st.nextToken());
            String nickName = st.nextToken();
            Player cur = new Player(lv, nickName);

            boolean flag = false;

            for (Room r : rooms) {
                if (r.list.size() < m 
                    && Math.abs(r.baseLv - lv) <= 10) {
                    r.list.add(cur);
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                Room nr = new Room(lv);
                nr.list.add(cur);
                rooms.add(nr);
            }
        }


        StringBuilder sb = new StringBuilder();
        for (Room r : rooms) {

            if (r.list.size() == m) sb.append("Started!\n");
            else sb.append("Waiting!\n");
 
            Collections.sort(r.list, (a, b) -> a.nickName.compareTo(b.nickName));

            for (Player pp : r.list) {
                sb.append(pp.lv).append(" ").append(pp.nickName).append("\n");
            }
        }
        System.out.print(sb);
    }
}
