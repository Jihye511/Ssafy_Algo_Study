import java.io.*;
import java.util.*;

public class Main {
    static int max=0;
    static int num;
    static int[] map;
    static ArrayList<Integer> ans;
    static boolean[] v;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        map = new int[n+1];
        ans = new ArrayList<>();
        v = new boolean[n+1];
        for(int i =1; i<=n; i++){
            map[i] = Integer.parseInt(br.readLine());
        }
        for(int i =1; i<=n; i++){
            if(!v[i]){
                v[i] = true;
                num =i;
                dfs(i);
                v[i] = false;
            }
        }
        Collections.sort(ans);
        System.out.println(ans.size());
        for(int i : ans){
            System.out.println(i);
        }
    }
    public static void dfs(int idx){
        if(map[idx]==num){
            ans.add(num);
        }
        if(!v[map[idx]]){
            v[map[idx]] = true;
            dfs(map[idx]);
            v[map[idx]] = false;
        }
    }
}
