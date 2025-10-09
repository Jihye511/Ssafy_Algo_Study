import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int maxHeight=Math.max(a, b);
        Deque<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < a; i++) {
            q.add(i);
        }
        q.add(maxHeight);
        for (int i = b - 1; i > 0; i--) {
            q.add(i);
        }

        if(q.size()>n) {
            System.out.println(-1);
            return;
        }

        int first = q.pollFirst();
        int qSize = q.size();
        for(int i=1;i<=n-qSize-1;i++) {
            q.addFirst(1);
        }
        q.addFirst(first);
        for (int i = 1; i <= n; i++) {
            System.out.print(q.pollFirst() + " ");
        }

    }

}
