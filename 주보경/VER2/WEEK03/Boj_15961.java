import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int totalDish = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int coupon = Integer.parseInt(st.nextToken());

        int[] sushi = new int[totalDish];
        for (int i = 0; i < totalDish; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        //슬라이딩 윈도우
        int type = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        int start = 0;
        int end = 0;

        int max = 0;
        int temp = 0;
        for (int i = 0; i < K; i++) {
            map.put(sushi[i], map.getOrDefault(sushi[i],0) +1);
        }


        if (map.size() == K) {
            if (!map.containsKey(coupon)) {
                System.out.println(K+1);
                return;
            }
        }
        temp = map.size();
        if (!map.containsKey(coupon)) temp++;

        max = temp;

        end = K;
        while (true) {
            //System.out.println(map);
            map.put(sushi[start%totalDish], map.get(sushi[start%totalDish]) -1);
            if (map.get(sushi[start%totalDish]) == 0)
                map.remove(sushi[start%totalDish]);
            map.put(sushi[end%totalDish], map.getOrDefault(sushi[end%totalDish],0) +1);
            temp = map.size();
            if (!map.containsKey(coupon)) temp++;

            if (temp == K+1) {
                System.out.println(temp);
                return;
            }
            max = Math.max(temp, max);
            start++;
            end++;

            if (end%totalDish == K) break;
        }
        System.out.println(max);
    }
}
