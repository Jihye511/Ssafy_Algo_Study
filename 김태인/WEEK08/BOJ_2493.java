import java.util.*;
import java.io.*;

public class Main {

    static class Tower{
        int height, index;
        Tower(int height, int index){
            this.height = height;
            this.index = index;
        }
    }

    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] result = new int[N];
        Stack<Tower> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(st.nextToken());

            while(!stack.isEmpty() && stack.peek().height <= height){
                stack.pop();
            }

            if (!stack.isEmpty()){
                result[i] = stack.peek().index;
            }
            else{
                result[i] = 0;
            }

            stack.push(new Tower(height, i + 1));
        }

        StringBuilder sb = new StringBuilder();
        for (int r : result) {
            sb.append(r).append(" ");
        }
        System.out.println(sb);
    }
}
