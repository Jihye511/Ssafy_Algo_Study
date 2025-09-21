import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[] city;
    static ArrayList<Integer>[] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        map = new ArrayList[N];
        for(int i =0; i<N; i++){
            map[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for(int i =0; i<N; i++){
            st= new StringTokenizer(br.readLine());
            for(int j =0; j<N; j++){
                int a = Integer.parseInt(st.nextToken());
                if(a ==1){
                    map[i].add(j);
                }
            }
        }
        st= new StringTokenizer(br.readLine());
        city = new int[M];
        for(int i =0; i<M; i++){
            city[i] = Integer.parseInt(st.nextToken())-1;
        }
        int cnt=0;
        for(int i =0; i<M-1; i++){
            if(possibleNext(city[i], city[i+1]))cnt++;
        }
        if(cnt == M-1) System.out.println("YES");
        else System.out.println("NO");
    }

    //다음으로 갈 수 있는지 체크
    public static boolean possibleNext(int start, int end){
        boolean[] v = new boolean[N];
        Queue<Integer> q  = new LinkedList<>();
        q.offer(start);
        v[start] = true;
        while(!q.isEmpty()){
            int cur = q.poll();
            if(cur == end) return true;
            for(int i =0; i<map[cur].size(); i++){
                if(!v[map[cur].get(i)]){
                    v[map[cur].get(i)] = true;
                    q.offer(map[cur].get(i));
                }
            }
        }
        return false;
    }
}
