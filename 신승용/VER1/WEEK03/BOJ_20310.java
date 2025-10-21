import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_20310 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String token = br.readLine();

        int cnt0 = 0;
        int cnt1 = 0;

        for (int i = 0; i < token.length(); i++) {
            if(token.charAt(i)=='0') cnt0++;
            else cnt1++;
        }

        int remove0 = cnt0 / 2;
        int remove1 = cnt1 / 2;
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < token.length(); i++) {
            list.add(token.charAt(i));
        }
        for (int i = 0; i < list.size(); i++) {
            char cur = list.get(i);
            if(cur=='1' && remove1 > 0){
                remove1--;
                list.remove(i);
                i--;
            } 
        }

        for (int i = list.size()-1; i >= 0; i--) {
            char cur = list.get(i);
            if(cur=='0' && remove0 > 0){
                remove0--;
                list.remove(i);
            } 
        }

        StringBuilder sb = new StringBuilder();

        for (Character c : list) {
            sb.append(c);
        }

        System.out.println(sb.toString());
    }
}