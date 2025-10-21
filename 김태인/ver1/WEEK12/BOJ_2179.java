import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static String[] arr;
    static HashMap<String, Integer> map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
            map.put(arr[i], i);
        }

        Arrays.sort(arr);

        String S = "";
        String T = "";
        int result = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (arr[i].charAt(0) != arr[j].charAt(0)) break;

                int len = Math.min(arr[i].length(), arr[j].length());
                int cnt = 0;

                for (int k = 0; k < len; k++) {
                    if (arr[i].charAt(k) == arr[j].charAt(k)) cnt++;
                    else break;
                }

                if (cnt > result) {
                    result = cnt;
                    if (map.get(arr[i]) < map.get(arr[j])) {
                        S = arr[i];
                        T = arr[j];
                    } else {
                        S = arr[j];
                        T = arr[i];
                    }
                } else if (cnt == result && cnt > 0) {
                    int a1 = Math.min(map.get(arr[i]), map.get(arr[j]));
                    int a2 = Math.max(map.get(arr[i]), map.get(arr[j]));
                    int b1 = Math.min(map.get(S), map.get(T));
                    int b2 = Math.max(map.get(S), map.get(T));

                    if (a1 < b1 || (a1 == b1 && a2 < b2)) {
                        if (map.get(arr[i]) < map.get(arr[j])) {
                            S = arr[i];
                            T = arr[j];
                        } else {
                            S = arr[j];
                            T = arr[i];
                        }
                    }
                }
            }
        }

        System.out.println(S);
        System.out.println(T);
    }
}
