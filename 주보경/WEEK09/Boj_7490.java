import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<char[]> cases;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb;
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            cases = new ArrayList<>();

            perm(0, new char[] {' ', '+', '-'}, new char[N-1], N);

            Deque<Integer> dq;
            for (char[] c : cases) {
                //각 경우의 수 테스트
                dq = new ArrayDeque<>();

                //공백은 미리 처리하기
                int i = 0;
                while (true) {
                    if (i >= N-1) {
                        dq.add(i+1);
                        break;
                    };
                    if (c[i] == ' ') {
                        int num = i+1;
                        while (true) {
                            if (i >= N-1 || c[i] != ' ') {
                                dq.add(num);
                                i++;
                                break;
                            }
                            //숫자 합치기
                            i++;
                            num *= 10;
                            num += i+1;
                        }

                    }
                    else {
                        dq.add(i+1);
                        i++;
                    }
                }


                int num = dq.pollFirst();
                i = 0;
                for (char op : c) {
                    if (op == '+') {
                        int second = dq.pollFirst();
                        num += second;
                    }

                    if (op == '-') {
                        int second = dq.pollFirst();
                        num -= second;
                    }
                }

                if (num == 0) {
                    //출력하기
                    sb = new StringBuilder();
                    for (i = 0; i < N-1; i++) {
                       sb.append(i+1).append(c[i]);
                    }
                    sb.append(N);
                    System.out.println(sb);
                }
            }
            System.out.println();
        }
    }


    //증복순열
    static void perm(int depth, char[] arr, char[] selected, int N) {
        if (depth == N-1) {
            cases.add(selected.clone());
            return;
        }

        for (int i = 0; i < 3; i++) {
            selected[depth] = arr[i];
            perm(depth+1, arr, selected, N);
        }
    }
}
