import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int oneCount = 0;
        int zeroCount = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '0') zeroCount++;
            else oneCount++;
        }

        StringBuilder sb = new StringBuilder(input);

        int index = 0;
        oneCount /= 2;
        while (oneCount > 0) {
            if (sb.charAt(index) == '1') {
                sb.deleteCharAt(index);
                oneCount--;
            }
            else index++;
        }

        index = sb.length() -1;
        zeroCount /= 2;
        while (zeroCount > 0 && index >= 0) {
            if (sb.charAt(index) == '0') {
                sb.deleteCharAt(index);
                zeroCount--;
            }
            index--;
        }

        System.out.println(sb);
    }
}
