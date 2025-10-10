import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[] h;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        h=new int[N];
        for(int i = 0; i < N; i++) {
            h[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();

        int [] leftarr = left();
        int [] rightarr = right();
        int[] pge = prevGreaterIndex();  // 바로 왼쪽 큰 건물 인덱스
        int[] nge = nextGreaterIndex();
        for (int i = 0; i < N; i++) {
            int total = leftarr[i] + rightarr[i];
            if (total == 0) {
                sb.append("0\n");
            } else {
                int ansIdx = pickNearest(i, pge[i], nge[i]);
                sb.append(total).append(' ').append(ansIdx + 1).append('\n');
            }
        }
        System.out.println(sb);
    }

    public static int[] left() {
        int[] pge = new int[N];
        Arrays.fill(pge, -1);
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            // 현재 h[i]보다 작거나 같은 건 PGE 후보가 아님
            while (!stack.isEmpty() && h[stack.peek()] <= h[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) pge[i] = stack.peek();
            stack.push(i);
        }
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = (pge[i] == -1) ? 0 : (1 + dp[pge[i]]);
        }
        return dp;
    }

    public static int[] right() {
        int[] nge = new int[N];
        Arrays.fill(nge, -1);
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && h[stack.peek()] < h[i]) {
                nge[stack.pop()] = i;
            }
            stack.push(i);
        }

        int[] dp = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            if (nge[i] != -1) dp[i] = 1 + dp[nge[i]];
            else dp[i] = 0;
        }
        return dp;
    }
    static int[] prevGreaterIndex() {
        int[] pge = new int[N];
        Arrays.fill(pge, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && h[stack.peek()] <= h[i]) stack.pop();
            if (!stack.isEmpty()) pge[i] = stack.peek();
            stack.push(i);
        }
        return pge;
    }

    static int[] nextGreaterIndex() {
        int[] nge = new int[N];
        Arrays.fill(nge, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && h[stack.peek()] < h[i]) {
                nge[stack.pop()] = i;
            }
            stack.push(i);
        }
        return nge;
    }

    static int pickNearest(int i, int L, int R) {
        int ans = -1, best = Integer.MAX_VALUE;
        if (L != -1) { best = i - L; ans = L; }
        if (R != -1) {
            int d = R - i;
            if (d < best || (d == best && (ans == -1 || R < ans))) ans = R;
        }
        return ans;
    }
}
