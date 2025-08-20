import java.io.*;

public class Main {
    static String S, T;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();

        makeS(T);

        System.out.println(ans);
    }

    private static void makeS(String t) {
        if (t.length() == S.length()) {
            if (t.equals(S)) {
                ans = 1;
            }
            return;
        }

        int len = t.length();
        
        if (t.endsWith("A")) {
            makeS(t.substring(0, len - 1));
        }
        
        if (t.startsWith("B")) {
            String next = new StringBuilder(t.substring(1)).reverse().toString();
            makeS(next);
        }
    }
}
