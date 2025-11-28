package Baekjoon.VER2.WEEK6;
import java.util.*;

public class PGS_42888 {

    private static class Command {
        boolean c;
        String uid;

        Command(boolean c, String uid) {
            this.c = c;
            this.uid = uid;
        }
    }

    public static void main(String[] args) {
        StringTokenizer st;
        String[] record = {
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"};

        String command, uid, name;

        HashMap<String, String> map = new HashMap<>();
        List<Command> commands = new LinkedList<>();
        for (int i=0; i<record.length; i++) {
            st = new StringTokenizer(record[i]);

            command = st.nextToken();
            uid = st.nextToken();

            switch (command) {
                case "Enter":
                    commands.add(new Command(true, uid));
                case "Change":
                    name = st.nextToken();
                    map.put(uid,name);
                    break;
                case "Leave":
                    commands.add(new Command(false, uid));
                    break;
            }
        }


        String[] answer = new String[commands.size()];
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (Command c : commands) {
            sb.append(map.get(c.uid));

            if (c.c)
                sb.append("님이 들어왔습니다.");
            else
                sb.append("님이 나갔습니다.");

            answer[count++] = sb.toString();
            sb.setLength(0);
        }

        for (String ans : answer) {
            System.out.println(ans);
        }
    }
}