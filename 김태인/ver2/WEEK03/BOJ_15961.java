import java.io.*;
import java.util.*;
public class Main {

    static int N, d, k, c, result, cnt;
    static int[] sushi;
    static int[] count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        cnt = 0;
        result = 0;

        sushi = new int[N];
        count = new int[d + 1];
        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < k; i++) {
            if(count[sushi[i]] == 0) cnt++;
            count[sushi[i]]++;
        }

        result = cnt;
        if(count[c] == 0) result++;

        for (int left = 1; left < N; left++) {
                count[sushi[left - 1]]--;
                if(count[sushi[left - 1]] == 0) cnt--;

                if(count[sushi[(left + k - 1) % N]] == 0) cnt++;
                count[sushi[(left + k - 1) % N]]++;
                if(count[c] == 0) result = Math.max(result, cnt + 1);
                else result = Math.max(result, cnt);


        }
        System.out.println(result);
    }

}
