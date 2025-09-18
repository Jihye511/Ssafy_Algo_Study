import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_9935 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();
        char[] boom = br.readLine().toCharArray();
        char[] ans = new char[arr.length];
        int p = 0;
        int t;
        L:for (char c: arr) {
            ans[p++]=c;
            if (p>=boom.length) {
                t = p-boom.length;
                for (int j=0;j<boom.length;j++) {
                    if (ans[t+j]!=boom[j]) continue L;
                }
                p-=boom.length;
            }
        }

        if (p==0) System.out.println("FRULA");
        else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < p; i++) {
                sb.append(ans[i]);
            }

            System.out.println(sb.toString());
        }
    }
}

//test