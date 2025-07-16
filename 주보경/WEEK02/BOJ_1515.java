import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        //1부터 N까지 순서대로 입력
        //N 최소값

        int searchIndex = 0;
        int num = 1; //검산 시작할 숫자
        while (searchIndex < input.length()) {
            //검산 시작할 숫자 자릿수만큼 탐색
            int numIndex = 0;
            while (numIndex < String.valueOf(num).length() && searchIndex < input.length()) {
                //System.out.println("비교숫자 " + input.charAt(searchIndex) + ", " + String.valueOf(num).charAt(numIndex));
                if (input.charAt(searchIndex) == String.valueOf(num).charAt(numIndex)) {
                    //숫자 같음
                    searchIndex++;
                }
                numIndex++;
            }
            num++;
        }
        System.out.println(num-1);
    }
}
