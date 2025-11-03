package VER2.WEEK03;

import java.io.*;
import java.util.*;

class PGS_150368 {

    static class Emoticon {
        int price;
        int dc;

        public Emoticon(int price, int dc) {
            this.price = price;
            this.dc = dc;
        }
    }

    int[] discount = {10, 20, 30, 40};
    List<Emoticon> list;
    int[] result;

    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};

        result = new int[2];

        list = new ArrayList<>();
        for (int i=0; i<emoticons.length; ++i) {
            list.add(new Emoticon(emoticons[i], 0));
        }

        for (int i=0; i<4; ++i) {
            recursive(users, 0, i);
        }

        return result;
    }

    public void recursive(int[][] users, int idx, int d) {
        if (idx == list.size()) {
            // check
            int n = 0; // 가입자 수
            int total = 0; // 구매 금액
            for (int i=0; i<users.length; ++i) {
                int sum = 0;
                for (int j=0; j<list.size(); ++j) {
                    // System.out.println(list.get(j).dc);
                    if (users[i][0] <= list.get(j).dc) {
                        sum += list.get(j).price / 100 * (100 - list.get(j).dc);
                    }
                }
                // System.out.println(i + ", " + sum);
                if (sum >= users[i][1]) {
                    ++n;
                }
                else {
                    total += sum;
                }
            }


            if (n > result[0]) {
                result[0] = n;
                result[1] = total;
            }
            else if (n == result[0]) {
                if (total > result[1]) {
                    result[1] = total;
                }
            }

            return;
        }

        list.get(idx).dc = discount[d];

        for (int i=0; i<4; ++i) {
            recursive(users, idx+1, i);
        }
    }
}