import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        int level;
        String name;
        Node(int level, String name){
            this.level = level;
            this.name = name;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<ArrayList<Node>> rooms = new ArrayList<>();

        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for(int i =0; i<p; i++){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            String n = st.nextToken();
            boolean assigned = false;
            for(ArrayList<Node> room: rooms){
                Node first = room.get(0);
                    if(room.size() < m && l >= first.level -10 && l <=first.level +10){
                        room.add(new Node(l,n));
                        assigned = true;
                        break;
                    }
                }
                if(!assigned) {
                    ArrayList<Node> newRoom = new ArrayList<>();
                    newRoom.add(new Node(l, n));
                    rooms.add(newRoom);
                }
            }
            StringBuilder sb = new StringBuilder();
            for(ArrayList<Node> room : rooms){
                if(room.size() == m) {
                    sb.append("Started!\n");
                }else {
                    sb.append("Waiting!\n");
                }
                room.sort(Comparator.comparing(n ->n.name));
                for(Node node : room) {
                    sb.append(node.level).append(" ").append(node.name).append("\n");
                }
            }
        System.out.println(sb);
        }
    }
