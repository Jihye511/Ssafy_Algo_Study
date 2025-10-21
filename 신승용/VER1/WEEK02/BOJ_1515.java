import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1515 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String token = br.readLine();
        int index = 0;
        int count = 1;
        for (;;) {
            if(index >= token.length()) break;
            String cur = Integer.toString(count);
            if(cur.contains(token.charAt(index)+"")){
                int same = 0;
                for (int i = 0; i < cur.length(); i++) {
                    if(index < token.length()) {
                        if(cur.charAt(i)==token.charAt(index)){
                            same++;
                            index++;
                        }
                    }
                }
            } 
            count++;
        }

        System.out.println(count-1);
    }
}