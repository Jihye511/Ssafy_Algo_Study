import java.util.*;
import java.io.*;

public class Main {

    static class Node{
        int x, y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }

    }

    static int N, L, M, K, result;
    static ArrayList<Node> map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x =  Integer.parseInt(st.nextToken());
            int y =  Integer.parseInt(st.nextToken());
            map.add(new Node(x, y));

        }
        Collections.sort(map, (map1, map2) -> {
            if(map1.x != map2.x) return map1.x - map2.x;
            return map1.y - map2.y;
        });
        result = 0;

        check();

    }

    public static void check(){
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < K; j++) {
                int start_x = map.get(i).x;
                int start_y = map.get(j).y;
                int end_x = start_x + L;
                int end_y = start_y + L;
                int cnt = 0;
                for (Node now : map){
                    if(now.x >= start_x && now.x <= end_x && now.y >= start_y && now.y <= end_y) cnt++;
                }

                result = Math.max(result, cnt);

            }
        }

        System.out.println(K - result);

    }

}
