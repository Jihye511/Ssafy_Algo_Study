import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        char[] arr = str.toCharArray();
        int check=0;
        int result=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]=='P'){
                check=0;
                for(int j=i-K;j<=i;j++){
                    if(j>=0 && j< N){
                        if(arr[j]=='H'){
                            check=1;
                            result++;
                            arr[j]='X';
                            break;
                        }
                    }
                }
                if(check!=1){
                    for(int j=i;j<=i+K;j++){
                        if(j>=0 && j<N){
                            if(arr[j]=='H'){
                                result++;
                                arr[j]='X';

                                break;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(result);
            }
}
