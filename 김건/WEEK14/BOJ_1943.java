package Baekjoon.WEEK14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1943 {
    static int N, total, ans;
    static List<Coin> list;
    static boolean[][] arr;
    static class Coin {
        int c, n;

        Coin(int c, int n) {
            this.c = c;
            this.n = n;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        int coin, amount;
        boolean f;

        for (int step=0; step<3; step++) {
            N = Integer.parseInt(br.readLine());
            f = false;

            total = 0;
            list = new ArrayList<>();
            for (int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());

                coin = Integer.parseInt(st.nextToken());
                amount = Integer.parseInt(st.nextToken());

                total += coin*amount;

                list.add(new Coin(coin, amount));
            }

            if (total%2==1) System.out.println(0);
            else {
                ans = total / 2;
                arr = new boolean[ans + 1][2];
                arr[0][0] = true;
                for (Coin c : list) {
                    for (int i = 0; i <= ans; i++) {
                        if (arr[i][0]) {
                            for (int j=1; j<=c.n; j++) {
                                if (i + c.c*j<=ans)
                                    arr[i + c.c*j][1] = true;
                            }
                        }
                        arr[i][0] = arr[i][1];
                    }

                    if (arr[ans][0]) {
                        f = true;
                        break;
                    }
                }

                if (f) System.out.println(1);
                else System.out.println(0);
            }
        }
    }
}
