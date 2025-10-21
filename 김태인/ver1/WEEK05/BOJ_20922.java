        import java.util.*;
        import java.io.*;

        public class Main {

            static int N, K, result;
            static HashMap<Integer, Integer> map;
            public static void main(String[] args) throws Exception{
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                StringTokenizer st = new StringTokenizer(br.readLine());
                N = Integer.parseInt(st.nextToken());
                K = Integer.parseInt(st.nextToken());

                st = new StringTokenizer(br.readLine());
                int[] arr = new int[N];
                for (int i = 0; i < N; i++) {
                    arr[i] = Integer.parseInt(st.nextToken());
                }
                
                result = 0;
                int temp = 1;
                map = new HashMap<>();
                int left = 0;
                int result = 0;

                for (int right = 0; right < N; right++) {
                    map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

                    while (map.get(arr[right]) > K) {
                        map.put(arr[left], map.get(arr[left]) - 1);
                        left++;
                    }

                    result = Math.max(result, right - left + 1);
                }

                System.out.println(result);

            }
        }
