import java.util.*;
import java.io.*;

public class Boj_5430_AC {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            char[] command = br.readLine().toCharArray();
            int N = Integer.parseInt(br.readLine());
            String input = br.readLine();

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            if (N == 0) {
                bw.write(run(new ArrayDeque<>(), command));
            }
            else {
                input = input.substring(1,input.length()-1);
                String[] trim = input.split(",");
                Deque<String> dq = new ArrayDeque<>(List.of(trim));
                bw.write(run(dq, command));

            }

            bw.write("\n");

            bw.flush();
        }
    }

    static String run(Deque<String> dq, char[] command) {
        boolean isReverse = false;
        for (char c : command) {
            if (c == 'R') isReverse = !isReverse;
            else if (c == 'D') {
                if (dq.isEmpty()) {
                    return "error";
                }

                if (isReverse) {
                    //뒤에 잘라야됨
                    dq.pollLast();
                }
                else {
                    dq.pollFirst();
                }
            }
        }


        //결과 가공하기
        StringBuilder result = new StringBuilder();
        result.append("[");
        if (!isReverse) {
            while (!dq.isEmpty()) {
                result.append(dq.pollFirst());
                if (!dq.isEmpty()) result.append(",");
            }
        }
        else {
            while (!dq.isEmpty()) {
                result.append(dq.pollLast());
                if (!dq.isEmpty()) result.append(",");
            }
        }
        result.append("]");

        return result.toString();
    }
}
