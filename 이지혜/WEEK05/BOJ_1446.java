import java.io.*;
import java.util.*;

public class Main {
    static class Road{
        int start, end, len;
        public Road(int start, int end, int len){
            this.start = start;
            this.end = end;
            this.len = len;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int[] arr = new int[D+1];
        Arrays.fill(arr, 10001);
        List<Road> roads = new ArrayList<>();
        for(int i =0;i<N; i++){
            st= new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(b>D || b-a<=c) continue;
            roads.add(new Road(a,b,c));
        }
         Collections.sort(roads, (a,b) -> {
             if(a.start == b.start) return a.end- b.end;
             return a.start - b.start;
         });

        int idx = 0;
        int location =0;
        arr[0] =0;
        while(location<D){
            if(idx<roads.size()){
                Road r = roads.get(idx);
                if(r.start == location){
                    arr[r.end]= Math.min(arr[r.end], arr[location] + r.len);
                    idx++;
                    continue;
                }
            }
            arr[location+1] = Math.min(arr[location+1], arr[location]+1);
            location++;
        }
         System.out.println(arr[D]);
    }
}
