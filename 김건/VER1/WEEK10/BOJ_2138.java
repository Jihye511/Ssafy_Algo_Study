import java.io.*;
import java.util.*;

public class BOJ_2138 {
    static char[] in;
    static char[] ans;
    static char[] arr;
    
    static int N;
    
    public static  void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        in = br.readLine().toCharArray();
        ans = br.readLine().toCharArray();
        int c = 0, min = Integer.MAX_VALUE;
        
        arr = new char[N];
        for (int i=0;i<N;i++) {
            arr[i]=in[i];
        }
        
        for(int i=1; i<N-1;i++) {
            if (arr[i-1]!=ans[i-1]) {
                change(i);
                c++;
            }
        }
        
        if (arr[N-2]!=ans[N-2]) {
            swap(N-2);
            swap(N-1);
            c++;
        }
        
        if (validation()) min=c;
            
        for (int i=0;i<N;i++) {
            arr[i] = in[i];
        }
        
        c = 1;
        
        swap(0);
        swap(1);
        
        for (int i=1; i<N-1; i++) {
            if (arr[i-1]!=ans[i-1]) {
                change(i);
                c++;
            }
        }
        
        if (arr[N-2]!=ans[N-2]) {
            swap(N-2);
            swap(N-1);
            c++;
        }
        
        if (validation()) min=Math.min(min, c);
        
        if (min!=Integer.MAX_VALUE)
            System.out.println(min);
        else System.out.println(-1);
    }
    
    static void change(int n) {
        for (int i=-1;i<=1;i++) {
            swap(n+i);
        }
    }
    
    static void swap(int n) {
        if (arr[n]=='0') arr[n]='1';
        else arr[n]='0';
    }
    
    static boolean validation() {
        if (arr[N-1]==ans[N-1]) return true;
        else return false;
    }
}