import java.io.*;

import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        

        int[] arr = new int[N];

        

        for (int i=0; i<N; i++) {

            arr[i] = Integer.parseInt(st.nextToken());

        }

        

        Arrays.sort(arr);

        

        int s, e, sum, c=0;

        for (int i=0; i<N; i++) {

            s = 0;

            e = N-1;

            while (s<e) {

                if (s==i) {

                    s++;

                    continue;

                }

                if (e==i) {

                    e--;

                    continue;

                }

                sum = arr[s]+arr[e];

                if (sum==arr[i]) {

                    c++;

                    break;

                }

                if (sum<arr[i]) {

                    s++;

                }

                else e--;

            }

        }

        System.out.println(c);

    }

}