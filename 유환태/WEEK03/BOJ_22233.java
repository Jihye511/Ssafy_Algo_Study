import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        Set<String> list = new HashSet<>();
        Set<String> use = new HashSet<>();
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int ans = N;

        for(int i = 0; i < N; i++){
            list.add(br.readLine());
        }

        for(int i = 0; i < M; i++){
            String str = br.readLine();
            String[] keyword = str.split(",");
            for(int j = 0; j < keyword.length; j++){
                if(list.contains(keyword[j])){
                    if(!use.contains(keyword[j])){
                        use.add(keyword[j]);
                        ans--;
                    }
                }
            }
            System.out.println(ans);
        }

        
    }
}