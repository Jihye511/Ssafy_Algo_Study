import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_20006 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        LinkedHashMap<String, Integer> player = new LinkedHashMap<>();
        for(int i=0;i<p;i++){
st= new StringTokenizer(br.readLine());
int level = Integer.parseInt(st.nextToken());
String name = st.nextToken();
player.put(name,level);
        }
        while(player.size()!=0){
            ArrayList<String> room = new ArrayList<>();
            int cnt=0;
            String first = "";
            for(String str : player.keySet()){
                if(cnt==m){
                    break;
                }
                if(cnt==0){
                    first=str;
                    room.add(str);
                    cnt++;

                }
                else{
                    if(player.get(first)-10<=player.get(str)&&player.get(first)+10>=player.get(str)){
                        room.add(str);
                        cnt++;
                    }
                }
            }
            Collections.sort(room);
            if(room.size()<m){
                System.out.println("Waiting!");
            }
            else System.out.println("Started!");
            for(int i=0;i<room.size();i++){
                System.out.println(player.get(room.get(i))+ " "+ room.get(i));
                player.remove(room.get(i));
            }

        }
    }
}
