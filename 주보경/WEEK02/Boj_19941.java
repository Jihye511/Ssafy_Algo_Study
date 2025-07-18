import java.util.*;
import java.io.*;

public class Boj_19941_햄버거분배 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String input = br.readLine();
        char[] array = input.toCharArray();

        //왼쪽에 먹을 게 있으면 먹음
        //최대한 왼쪽꺼 먹기
        //없으면 오른쪽

        int result = 0;

        //사람이면 햄버거 찾기
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 'P') {
                boolean flag = false;
                //왼쪽부터 먼 -> 가깝
                int index = Math.max(i - K,0);
                while (index < i) {
                    if (array[index] == 'H') {
                        result++;
                        array[index] = 'X'; //먹은건 X
                        flag = true;
                        break;
                    }
                    index++;
                }
                if (!flag) {
                    //오른쪽 탐색
                    index = i + K >= N ? N-1 : i + K;
                    for (int j = i + 1; j <= index; j++) {
                        if (array[j] == 'H') {
                            result++;
                            array[j] = 'X'; //먹은건 X
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(result);

    }
}
