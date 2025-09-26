package Baekjoon.WEEK12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BOJ_2179_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];

        Map<String, Integer> map = new HashMap<>();

        for (int i=0; i<N; i++) {
            arr[i] = br.readLine();
            map.put(arr[i], i);
        }

        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));
        int max = 0, s=0, e=0, minIdx = N, maxIdx=N;
        String first = new String();
        String second = new String();
        boolean f = false;
        for (int i=0; i<N-1; i++) {
//            System.out.println(arr[i]+" "+arr[i+1]);
            int l = Math.min(arr[i].length(), arr[i+1].length());
            int c = 0;
            for (int j=0; j<l; j++) {
                if (arr[i].charAt(j)==arr[i+1].charAt(j)) c++;
                else break;
            }

            if (max < c) {
                s=i;
                e=i+1;
                max = c;
                f = true;
                minIdx = N;
            }
            else if (max == c) {
                if (s==0&&e==0) s=i;
                e=i+1;
                f = true;
            }
            else {
                if (s!=0||e!=0) {
                    boolean ff = false;
                    for (int j = s; j <= e; j++) {
                        if (minIdx > map.get(arr[j])) {
                            minIdx = map.get(arr[j]);
                            first = arr[j];
                            maxIdx = N;
                            ff = true;
                        }
                    }

                    if (ff) {
                        for (int j = s; j <= e; j++) {
                            if (maxIdx > map.get(arr[j]) && minIdx != map.get(arr[j])) {
                                maxIdx = map.get(arr[j]);
                                second = arr[j];
                            }
                        }
                    }

                    s = 0;
                    e = 0;
                }
            }
//            System.out.println(s+" "+e+" "+minIdx+" "+maxIdx);
        }

        if (s!=0||e!=0) {
            boolean ff = false;
            for (int i=s; i<=e; i++) {
                if (minIdx>map.get(arr[i])) {
                    minIdx = map.get(arr[i]);
                    first = arr[i];
                    maxIdx = N;
                    ff = true;
                }
            }

            if (ff) {
                for (int i = s; i <= e; i++) {
                    if (maxIdx > map.get(arr[i]) && minIdx != map.get(arr[i])) {
                        maxIdx = map.get(arr[i]);
                        second = arr[i];
                    }
                }
            }
        }
//        System.out.println(s+" "+e+" "+minIdx+" "+maxIdx);

        System.out.println(first);
        System.out.println(second);
    }
}
