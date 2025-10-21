import java.io.*;
import java.util.*;

public class Main {

    static class Person implements Comparable<Person>{
        int level;
        String name;
        Person(int level, String name){
            this.level = level;
            this.name = name;
        }

        @Override
        public int compareTo(Person o) {
            return this.name.compareTo(o.name);
        }
    }

    static class Room{
        int level;
        int size = 0;
        ArrayList<Person> person_list;

        Room(int level){
            this.level = level;
            person_list = new ArrayList<>();
        }
    }

    static int P, M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        P = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int level;
        String name;
        boolean flag = false;
        ArrayList<Room> room_list = new ArrayList<>();
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            level = Integer.parseInt(st.nextToken());
            name = st.nextToken();
            flag = false;
            if (room_list.isEmpty()){
                room_list.add(new Room(level));
                room_list.get(0).person_list.add(new Person(level, name));
                room_list.get(0).size++;
            }
            else{
                for(Room room : room_list){
                    if (room.level + 10 >= level && room.level - 10 <= level && room.size < M){
                        room.person_list.add(new Person(level, name));
                        room.size++;
                        flag = true;
                        break;
                    }
                }

                if(!flag){
                    room_list.add(new Room(level));
                    room_list.get(room_list.size() - 1).person_list.add(new Person(level, name));
                    room_list.get(room_list.size() - 1).size++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Room room : room_list) {
            if(room.size == M){
                sb.append("Started!\n");
            }
            else{
                sb.append("Waiting!\n");
            }

            Collections.sort(room.person_list);

            for (Person person : room.person_list){
                sb.append(person.level).append(" ").append(person.name).append("\n");
            }
        }

        System.out.println(sb);

    }


}
