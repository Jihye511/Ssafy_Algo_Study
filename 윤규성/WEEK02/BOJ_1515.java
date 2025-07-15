import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1515 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int i = 1;
        int j = 0;
        while (true) {
            String now = String.valueOf(i);

            for (int s = 0; s < now.length(); s++) {
                if (now.charAt(s) == str.charAt(j)) {
                    j++;
                }
                if (j == str.length()) {
                    System.out.println(i);
                    return;
                }
            }
            i++;
        }
    }
}
