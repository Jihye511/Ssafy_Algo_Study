import java.util.*;
import java.io.*;

public class Main {

    static HashMap<Integer, Integer>[] num_map;
    static int N, K, P, X;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        num_map = new HashMap[10];
        for (int i = 0; i < 10; i++) {
            num_map[i] = new HashMap<>();
        }
        put(0,1,4);
        put(0,2,3);
        put(0,3,3);
        put(0,4,4);
        put(0,5,3);
        put(0,6,2);
        put(0,7,3);
        put(0,8,1);
        put(0,9,2);
        put(1,2,5);
        put(1,3,3);
        put(1,4,2);
        put(1,5,5);
        put(1,6,6);
        put(1,7,1);
        put(1,8,5);
        put(1,9,4);
        put(2,3,2);
        put(2,4,5);
        put(2,5,4);
        put(2,6,3);
        put(2,7,4);
        put(2,8,2);
        put(2,9,3);
        put(3,4,3);
        put(3,5,2);
        put(3,6,3);
        put(3,7,2);
        put(3,8,2);
        put(3,9,1);
        put(4,5,3);
        put(4,6,4);
        put(4,7,3);
        put(4,8,3);
        put(4,9,2);
        put(5,6,1);
        put(5,7,4);
        put(5,8,2);
        put(5,9,1);
        put(6,7,5);
        put(6,8,1);
        put(6,9,2);
        put(7,8,4);
        put(7,9,3);
        put(8,9,1);

        int result = 0;

        for (int i = 1; i <= N; i++) {
            if(i == X) continue;

            int diff = getDiff(X, i, K);
            if (diff > 0 && diff <= P) result++;

        }

        System.out.println(result);



    }
    public static void put(int a, int b, int c){
        num_map[a].put(b, c);
        num_map[b].put(a, c);
    }

    public static int getDiff(int x, int y, int k) {
        int diff = 0;
        for (int i = 0; i < k; i++) {
            int dx = x % 10;
            int dy = y % 10;

            if (dx != dy) {
                diff += num_map[dx].get(dy);
            }

            x /= 10;
            y /= 10;
        }
        return diff;
    }
}

/*
0 <-> 1 : 4
0 <-> 2 : 3
0 <-> 3 : 3
0 <-> 4 : 4
0 <-> 5 : 3
0 <-> 6 : 2
0 <-> 7 : 3
0 <-> 8 : 1
0 <-> 9 : 2


1 <-> 2 : 5
1 <-> 3 : 3
1 <-> 4 : 2
1 <-> 5 : 5
1 <-> 6 : 6
1 <-> 7 : 1
1 <-> 8 : 5
1 <-> 9 : 4

2 <-> 3 : 2
2 <-> 4 : 5
2 <-> 5 : 4
2 <-> 6 : 3
2 <-> 7 : 4
2 <-> 8 : 2
2 <-> 9 : 3

3 <-> 4 : 3
3 <-> 5 : 2
3 <-> 6 : 3
3 <-> 7 : 2
3 <-> 8 : 2
3 <-> 9 : 1

4 <-> 5 : 3
4 <-> 6 : 4
4 <-> 7 : 3
4 <-> 8 : 3
4 <-> 9 : 2

5 <-> 6 : 1
5 <-> 7 : 4
5 <-> 8 : 2
5 <-> 9 : 1

6 <-> 7 : 5
6 <-> 8 : 1
6 <-> 9 : 2

7 <-> 8 : 4
7 <-> 9 : 3

8 <-> 9 : 1

 */
