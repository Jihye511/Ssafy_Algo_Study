import java.io.*;
import java.util.*;
public class Main {
    static int N, K, P, X, result;
    static int[][] num;
    //n층까지, K자리수 디스플레이, 최대 p개 반전, 실제로 멈춰있는 층=X
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        num = new int[10][10];
        num[0] = new int[] {0,4,3,3,4,3,2,3,1,2};
        num[1] = new int[] {4,0,5,3,2,5,6,1,5,4};
        num[2] = new int[] {3,5,0,2,5,4,3,4,2,3};
        num[3] = new int[] {3,3,2,0,3,2,3,2,2,1};
        num[4] = new int[] {4,2,5,3,0,3,4,3,3,2};
        num[5] = new int[] {3,5,4,2,3,0,1,4,2,1};
        num[6] = new int[] {2,6,3,3,4,1,0,5,1,2};
        num[7] = new int[] {3,1,4,2,3,4,5,0,4,3};
        num[8] = new int[] {1,5,2,2,3,2,1,4,0,1};
        num[9] = new int[] {2,4,3,1,2,1,2,3,1,0};

        go(0,1,0,0);

        System.out.println(result-1);
    }
    //where = 지금 자리수, idx = 몇번째인지, now = 지금 숫자, cnt = 변경 개수
    private static void go(int where, int idx, int now, int cnt) {
        if(now > N || cnt > P) { //지금 숫자가 최대 층수보다 크거나 변경 개수 초과
            return;
        }

        if(where == K) {
            if(now!=0) result++;
            return;
        }

        for(int i=0;i<10;i++) {
            go(where+1, idx*10, i*idx+now, cnt+num[X/idx%10][i]);
        }
    }
}
