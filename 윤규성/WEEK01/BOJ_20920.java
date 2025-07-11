import java.awt.color.ICC_Profile;
import java.io.*;
import java.util.*;

public class BOJ_20920 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map;
        map = new HashMap<>();

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            if(str.length() < M) continue;
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        String[] arr = new String[map.size()];
        int cnt = 0;
        for(String s : map.keySet()){
            arr[cnt] = s;
            cnt++;
        }

        Arrays.sort(arr, ((o1, o2) -> {
           if(map.get(o1) != map.get(o2)) return Integer.compare(map.get(o2), map.get(o1));
           else if(o1.length() != o2.length()) return Integer.compare(o2.length(), o1.length());
           else return o1.compareTo(o2);
        }));

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<map.size(); i++){
            sb.append(arr[i]+ '\n');
        }

        System.out.print(sb);

    }
}
