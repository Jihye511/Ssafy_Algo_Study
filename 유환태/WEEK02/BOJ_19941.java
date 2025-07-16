package boj;

import java.util.*;
import java.io.*;

public class BOJ_19941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String line = br.readLine();

        List<Integer> hamburg = new ArrayList<>();
        List<Integer> person = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            char pnt =  line.charAt(i);

            if(pnt == 'H'){
                hamburg.add(i);
            }else{
                person.add(i);
            }
        }

        boolean[] check = new boolean[hamburg.size()];

        int ans = 0;

        for(int i = 0; i < person.size(); i++){
            for(int j = 0; j < hamburg.size(); j++){
                if(!check[j]&&Math.abs(hamburg.get(j)-person.get(i))<=K){
                    check[j] = true;
                    break;
                }
            }
        }

        for(int i = 0; i < check.length; i++){
            if(check[i]==true){
                ans++;
            }
        }
        System.out.println(ans);
    }
}
