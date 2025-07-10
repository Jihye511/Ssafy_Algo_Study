import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //비용 = 현재 노드 * 거리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        BigInteger[] dist = new BigInteger[N];
        BigInteger[] price = new BigInteger[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N-1; i++) {
            int d = Integer.parseInt(st.nextToken());
            dist[i] = BigInteger.valueOf(d);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            price[i] = BigInteger.valueOf(Integer.parseInt(st.nextToken()));
        }

        //그리디
        BigInteger totalPrice = price[0].multiply(dist[0]); //초기 비용
        BigInteger minPrice = price[0];
        for (int i = 1; i < N - 1; i++) {
            if (price[i].compareTo(minPrice) < 0) {
                //더 작으면 이 값으로 주유
                totalPrice = totalPrice.add(price[i].multiply(dist[i]));
                minPrice = price[i];
            }
            else {
                totalPrice = totalPrice.add(minPrice.multiply(dist[i]));
            }
        }

        System.out.println(totalPrice);
    }
}
