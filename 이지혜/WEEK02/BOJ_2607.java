import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static String[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N =Integer.parseInt(br.readLine());
        arr = new String[N];
        for(int i =0; i<N; i++){
            arr[i]=br.readLine();
        }


        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i =0; i<arr[0].length(); i++){
            map.put(arr[0].charAt(i), map.getOrDefault(arr[0].charAt(i),0)+1);
        }

        int ans=0;
        String target = arr[0];
        for(int i =1; i<N; i++){
        
            char[] cur = arr[i].toCharArray();
            HashMap<Character, Integer> originmap = new HashMap<>(map); //위에서 저장한거 복제
            int cnt =0; //알파벳 개수 세기
            for(int j=0; j<cur.length; j++){
                 if(originmap.containsKey(cur[j]) && originmap.get(cur[j])>0){
                     originmap.put(cur[j], originmap.get(cur[j])-1); // 같은 거 있음 -1
                     cnt++;
                 }
            }
            if(cur.length == target.length() -1){
                if(cnt ==  cur.length) ans++;
            }else if(cur.length == target.length()+1){
                if(cnt == target.length()) ans++;
            }else if(cur.length == target.length()){
                if(cnt == cur.length || cnt == cur.length-1) ans++;
            }
        }
        System.out.println(ans);
    }
}
