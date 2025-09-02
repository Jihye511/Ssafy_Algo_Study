package 신승용.WEEK09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BOJ_2668 {
    static int[] arr;
    static List<Integer> list;
    static boolean[] visited;
    static boolean[] isFin;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        arr = new int[N];
        list = new ArrayList<>();
        visited = new boolean[N];
        isFin = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine())-1;
        }

        for (int i = 0; i < N; i++) {
            dfs(i, i, new Stack<>());
        }

        Collections.sort(list);

        System.out.println(list.size());
        for (int num : list) {
            System.out.println(num);
        }
    }

    static void dfs(int start, int idx, Stack<Integer> stack){
        visited[idx] = true;

        int next = arr[idx];
        stack.push(idx);

        if(!visited[next]){
            dfs(start, next, stack);
        } else {
            if (!isFin[next]) {
                List<Integer> cycle = new ArrayList<>();
                for (int i = stack.size() - 1; i >= 0; i--) {
                    int num = stack.get(i);
                    cycle.add(num + 1);
                    if (num == next) break;
                }
                list.addAll(cycle);
            }
        } 

        stack.pop();
        visited[idx] = false;
        isFin[idx] = true;
    }
}
