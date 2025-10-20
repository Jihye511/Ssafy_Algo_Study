package 신승용.WEEK04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2304 {
    static class Pillar implements Comparable<Pillar>{
        int L, H;
        Pillar(int L, int H){
            this.L = L;
            this.H = H;
        }

        @Override
        public int compareTo(Pillar o) {
            return Integer.compare(this.L, o.L);
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Pillar> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            list.add(new Pillar(L, H));
        }

        Collections.sort(list);

        int maxIdx = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).H > list.get(maxIdx).H) {
                maxIdx = i;
            }
        }

        int answer = 0;
    
        // 왼쪽부터 최대값까지
        int currentHeight = 0;
        for (int i = 0; i <= maxIdx; i++) {
            if (list.get(i).H > currentHeight) {
                currentHeight = list.get(i).H;
            }
            
            if (i < maxIdx) {
                answer += currentHeight * (list.get(i + 1).L - list.get(i).L);
            }
        }

        // 오른쪽부터 최대값까지
        currentHeight = 0;
        for (int i = list.size() - 1; i >= maxIdx; i--) {
            if (list.get(i).H > currentHeight) {
                currentHeight = list.get(i).H;
            }
            
            if (i > maxIdx) {
                answer += currentHeight * (list.get(i).L - list.get(i - 1).L);
            }
        }

        answer += list.get(maxIdx).H;

        System.out.println(answer);
    }
}