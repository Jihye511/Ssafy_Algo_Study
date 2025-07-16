import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int num=1;
        while(!str.isEmpty()){
            String numStr = Integer.toString(num);
            int idx =0; //str의 현재 위치
            for(int i =0; i<numStr.length(); i++){
                if(idx < str.length() && numStr.charAt(i) == str.charAt(idx)){
                    idx++;
                }
            }
            str = str.substring(idx); //앞부분 자르기
            num++;
        }
        System.out.println(num-1);
    }
}
