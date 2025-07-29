    import java.util.*;
    import java.io.*;

    public class Main {

        static int T;
        public static void main(String[] args) throws Exception{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            T = Integer.parseInt(br.readLine());

            int N;
            for (int t = 0; t < T; t++) {
                N = Integer.parseInt(br.readLine());
                StringTokenizer st = new StringTokenizer(br.readLine());

                int[] arr = new int[N];
                int max;
                long result = 0;

                for (int i = 0; i < N; i++) {
                    arr[i] = Integer.parseInt(st.nextToken());
                }

                max = arr[N-1];

                for (int i = N-2; i >= 0; i--) {
                    if(max > arr[i]){
                        result += max - arr[i];
                    }
                    else{
                        max = arr[i];
                    }
                }

                System.out.println(result);
            }

            
        }
    }
