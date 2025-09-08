import java.io.*;
import java.util.*;
import java.util.jar.JarOutputStream;

public class Main {
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String a =br.readLine();
        String b  =br.readLine();

        char[] start = a.toCharArray();
        char[] end =  b.toCharArray();
        int cnt1 = process(start,end,true); // 1번 누름
        int cnt2 = process(start,end,false); // 안누름
        
        int ans = -1;
        if (cnt1 >= 0 && cnt2 >= 0) ans = Math.min(cnt1, cnt2);
        else if (cnt1 >= 0) ans = cnt1;
        else if (cnt2 >= 0) ans = cnt2;
        System.out.println(ans);

    }
    public static int process(char[] start, char[] end, boolean pressOne ){
        char[] temp = Arrays.copyOf(start,N);
        int cnt=0;
        if(pressOne){
            press(temp,0);
            cnt++;
        }
        for(int i =1; i<N; i++){
            if(temp[i-1] != end[i-1]) {
                press(temp, i);
                cnt++;
            }
        }
        if(Arrays.equals(temp, end))return cnt;
        return -1;
    }
    public static void press(char[]cur, int idx){
        toggle(cur,idx);
        if(idx-1>=0) toggle(cur,idx-1);
        if(idx+1<N) toggle(cur, idx+1);
    }
    public static void toggle(char[] arr,int i){
        arr[i] = (arr[i] =='0')?'1':'0';
    }
}
