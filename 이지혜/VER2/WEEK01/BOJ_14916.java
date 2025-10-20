import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] money = new int[n+1];
        Arrays.fill(money, -1);

        for(int i =1; i<=n; i++){
            if(i ==1 || i==3) continue;
            else if(i ==2 || i==5){
                money[i] = 1;
            }else{
                if(i-2>1 && money[i-2] != -1){
                    money[i]  = money[i-2]+1;
                }
                if(i-5>1 && money[i-5] != -1){
                    money[i]  = money[i-5]+1;
                }
            }
        }
        System.out.println(money[n]);
    }
}
