import java.io.*;
import java.util.*;

public class Main {

    static class Node{
        int x1, x2, y, num;
        Node(int x1, int x2, int y, int num){
            this.x1 = x1;
            this.x2 = x2;
            this.y = y;
            this.num = num;
        }
    }

    static int N, Q;
    static StringBuilder sb;
    static ArrayList<Node> arr;
    static int[] matching_arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();

        matching_arr = new int[N+1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr.add(new Node(x1, x2, y, i + 1));
        }

        Collections.sort(arr, (arr1, arr2) -> {
            if(arr1.x1 == arr2.x1){
                return arr1.x2 - arr2.x2;
            }

            return arr1.x1 - arr2.x1;
        });

        int groupid = 1;
        int curRight = arr.get(0).x2;
        matching_arr[arr.get(0).num] = groupid;


        for (int i = 1; i < N; i++) {
            Node now = arr.get(i);

            if(now.x1 <= curRight){
                matching_arr[now.num] = groupid;
                if(now.x2 > curRight) curRight = now.x2;
            }
            else{
                groupid++;
                matching_arr[now.num] = groupid;
                curRight = now.x2;
            }
        }


        sb = new StringBuilder();

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(matching_arr[a] == matching_arr[b]) sb.append(1);
            else sb.append(0);
            sb.append("\n");
        }

        System.out.println(sb);

    }

}
