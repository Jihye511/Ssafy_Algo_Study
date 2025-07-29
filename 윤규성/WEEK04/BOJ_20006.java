import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q20006 {
	
	public static class Player{
		int level;
		String id;
		
		public Player(int level, String id) {
			this.level = level;
			this.id = id;
		}
	}
	
	public static int M;
	public static ArrayList<Player[]> room;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());		// 방 정원
		room = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int level = Integer.parseInt(st.nextToken());
			String id = st.nextToken();
			
			findMyRoom(new Player(level, id));
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<room.size(); i++) {
			
			int cnt = heads(room.get(i));
			
			if(cnt == -1) {
				
				Arrays.sort(room.get(i), (o1, o2) -> {
					return o1.id.compareTo(o2.id);
				});
				sb.append("Started!").append('\n');
				
				for(int j = 0; j < M; j++) {
					sb.append(room.get(i)[j].level).append(" ").append(room.get(i)[j].id).append('\n');
				}
				
			}else {
				Player[] new_arr = new Player[cnt];
				for(int j = 0; j<cnt; j++) {
					new_arr[j] = room.get(i)[j];
				}
				Arrays.sort(new_arr, (o1, o2) -> {
					return o1.id.compareTo(o2.id);
				});
				
				sb.append("Waiting!").append('\n');
				for(int j = 0; j < cnt; j++) {
					sb.append(new_arr[j].level).append(" ").append(new_arr[j].id).append('\n');
				}
			}
		}
		
		System.out.print(sb);
		
	}

	private static void findMyRoom(Player player) {
		
		boolean found_room = false;
		
		for(int i = 0; i < room.size(); i++) {
			if(player.level <= room.get(i)[0].level + 10 && player.level >= room.get(i)[0].level - 10) {
				// 입장
				int cnt = heads(room.get(i));
				
				if(cnt != -1) {
					room.get(i)[cnt] = player;
					found_room = true;
					break;
				}
			}
		}
		
		if(!found_room) {
			Player[] create_room = new Player[M];
			create_room[0] = player;
			room.add(create_room);
		}
		
	}
	
	public static int heads(Player[] room) {		// -1 이면 꽉참
		int insert = -1;
		
		for(int j = 0; j < M; j++) {
			if(room[j] == null) {
				insert = j;
				break;
			}
		}
		
		return insert;
	}

}