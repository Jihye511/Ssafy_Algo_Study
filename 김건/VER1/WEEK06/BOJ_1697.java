package Baekjoon.WEEK6;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697{
    static int[] arr;
    static boolean[] v;
    static int[] dr = {1,-1,2};
    static int N;
    static int K;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer((br.readLine()));
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[100001];
        v = new boolean[100001];

        v[N] = true;
        if(N==K)
        {
            System.out.println(0);
        }else{
            bfs(N);
            System.out.println(arr[K]);
        }
    }
    public static void bfs(int s)
    {
        Queue<Integer> que = new ArrayDeque<>();
        que.offer(s);
        while(!que.isEmpty())
        {
            int cur = que.poll();
            if(cur==K)
            {
                break;
            }
            for(int i  =0;i<3;++i)
            {
                int idx = 0;
                if(i<2)
                {
                    idx = cur+dr[i];
                }else{
                    idx = cur * dr[i];
                }

                if(idx < 0 || idx > 100000)
                {
                    continue;
                }
                else if(v[idx])
                {
                    continue;
                }else{
                    v[idx] = true;
                    que.offer(idx);
                    arr[idx] = arr[cur]+1;
                }

            }
        }

    }
}