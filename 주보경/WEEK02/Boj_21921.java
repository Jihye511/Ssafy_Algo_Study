import java.util.*;
import java.io.*;

public class Boj_21921_블로그 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<Integer> visitors = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            visitors.add(Integer.parseInt(st.nextToken()));
        }

        //슬라이딩 윈도우
        int temp = 0;
        int maxCount = 1;
        for (int i = 0; i < X; i++) {
            temp += visitors.get(i);
        }
        int max = temp;
        int start = 0;
        int end = X-1;
        while (end < N-1) {
            temp = temp - visitors.get(start++) + visitors.get(++end);
            if (temp > max) {
                max = temp;
                maxCount = 1;
            }
            else if (temp == max) {
                maxCount++;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
        }

        else {
            System.out.println(max);
            System.out.println(maxCount);
        }

    }
}
