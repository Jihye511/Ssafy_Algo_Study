package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_19941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int table = Integer.parseInt(st.nextToken());
        int dist = Integer.parseInt(st.nextToken());

        char[] tables = br.readLine().toCharArray();
        int count = 0;
        for (int i=0; i<table; i++) {
            if (tables[i]=='P') {
                for (int d=-dist; d<=dist; d++) {
                    int pos = i + d;
                    if (pos >= 0 && pos < table) {
                        if (i == pos) continue;
                        if (tables[pos] == 'H') {
                            tables[pos] -= 1;
                            count++;
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }
}
