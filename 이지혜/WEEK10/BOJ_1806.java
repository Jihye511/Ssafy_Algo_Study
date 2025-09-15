import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int [] num = new int[N];
        for(int i =0; i<N; i++){
            num[i] = Integer.parseInt(st.nextToken());
            if(num[i]>=S) {
                System.out.println(1);
                return;
            }
        }
        ArrayList<Integer>list = new ArrayList<>();
        int start =0;
        int end =0;
        int hap = num[start];
        while(start<=end && end<N){
            if(hap<S){
                if(end !=N-1){
                    end++;
                    hap+=num[end];
                }else end++;
            }
            else if(hap >=S){
                list.add(end-start+1);
                if(start != N-1){
                    start++;
                    hap -=num[start-1];
                }
            }
        }
        Collections.sort(list);
        if(list.size()==0){
            System.out.println(0);
        }else{
            System.out.println(list.get(0));
        }

    }
}
