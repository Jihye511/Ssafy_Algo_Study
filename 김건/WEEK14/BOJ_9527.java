package Baekjoon.WEEK14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_9527 {
    static Stack<Long> stack = new Stack<>();
    static long[] arr;
    static long[] sum;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long from = Long.parseLong(st.nextToken());
        long to = Long.parseLong(st.nextToken());
        long temp = to;
        int length = 0;
        while (temp>0) {
            temp/=2;
            length++;
        }

        arr = new long[length];
        sum = new long[length];

        arr[0]=1;
        sum[0]=1;
        for (int i=1; i<arr.length; i++) {
            arr[i] = arr[i-1]*2+ (long) Math.pow(2,i-1);
            sum[i] = sum[i-1]+arr[i];
        }
        long total = 0;
        if (to>1)
            total+=calculator(to);
        else
            total=1;
        if (from>2)
            total-=calculator(from-1);
        else if (from==2)
            total-=1;

        System.out.println(total);
    }

    static long calculator(long n) {
        while (n>0) {
            stack.add(n%2);
            n/=2;
        }

        int c=0;
        long total=0;
        while (!stack.isEmpty()) {
            if (stack.pop()==1) {
                if (!stack.isEmpty())
                    total+=sum[stack.size()-1];
                total+= (long) (Math.pow(2,stack.size())*c);
                c++;
            }
        }
        return total+c;
    }
}
