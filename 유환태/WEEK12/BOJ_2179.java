package boj;

import java.util.*;
import java.io.*;

public class BOJ_2179 {
    static class Answer implements Comparable<Answer>{
        int front;
        int behind;
        Answer(int f, int b){
            this.front = f;
            this.behind = b;
        }

        @Override
        public int compareTo(Answer o) {
            if(this.front==o.front){
                return this.behind - o.behind;
            }else{
                return this.front - o.front;
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        Set<String> starts = new HashSet<>();

        for(int i=0; i<N; i++){
            words[i] = br.readLine();
            for(int j=0; j<words[i].length(); j++){
                starts.add(words[i].substring(0,j));
            }
        }

        PriorityQueue<Answer> pq = new PriorityQueue<>();
        int len = Integer.MIN_VALUE;
        for(String start : starts){
            if(start.equals("")){
                continue;
            }
            if(start.length()<len){
                continue;
            }
            int S = -1;
            int T = -1;
            for(int w=0; w<N; w++){
                if(words[w].startsWith(start)){
                    if(S==-1){
                        S = w;
                    }else if(T==-1){
                        T = w;
                    }
                }
            }
            if(S!=-1&&T!=-1){
                if(start.length()>len){
                    len = start.length();
                    pq = new PriorityQueue<>();
                    pq.add(new Answer(S, T));
                }else if(start.length()==len){
                    pq.add(new Answer(S, T));
                }
            }
        }
        Answer ans = pq.poll();
        System.out.println(words[ans.front]);
        System.out.println(words[ans.behind]);
    }
}
