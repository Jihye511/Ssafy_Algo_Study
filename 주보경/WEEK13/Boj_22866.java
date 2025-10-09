import java.util.*;
import java.io.*;

public class Boj_22866_탑보기 {
    static class Building {
        int height;
        int number;

        public Building(int height, int number) {
            this.height = height;
            this.number = number;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] buildings = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }

        //스택 양쪽

        //건물 개수, 가장 가까운 건물 번호

        Stack<Building> right = new Stack<>();
        Stack<Building> left = new Stack<>();

        int[] r = new int[N]; //개수 저장
        int[] l = new int[N];
        int[] nearR = new int[N];
        int[] nearL = new int[N];

        //큰것만 볼 수 있음
        //스택에 큰 것들만 남기기
        for (int i = N-1; i >= 0; i--) {
            int curr = buildings[i];
            while (!right.isEmpty() && right.peek().height <= curr) {
                right.pop();
            }
            r[i] = right.size();
            nearR[i] = right.empty() ? -1 : right.peek().number;


            right.add(new Building(curr,i));
        }

        for (int i = 0; i < N; i++) {
            int curr = buildings[i];
            while (!left.isEmpty() && left.peek().height <= curr) {
                left.pop();
            }
            l[i] = left.size();

            nearL[i] = left.empty() ? -1: left.peek().number;
            left.add(new Building(curr,i));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(r[i] + l[i]);
            if (r[i] + l[i] != 0) {
                if (nearL[i] == -1) {
                    sb.append(" " + (nearR[i] + 1));
                }
                else if (nearR[i] == -1) {
                    sb.append(" " + (nearL[i] + 1));
                }
                else {
                    int dL = i - nearL[i], dR = nearR[i] - i;
                    if (dL > dR) sb.append(" " + (nearR[i]+1));
                    else sb.append(" " + (nearL[i]+1));
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
