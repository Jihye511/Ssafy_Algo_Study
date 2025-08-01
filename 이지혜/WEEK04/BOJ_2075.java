import java.io.*;
import java.text.CollationElementIterator;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Long> num = new ArrayList();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                num.add(Long.parseLong(st.nextToken()));
            }
        }
        Collections.sort(num,Collections.reverseOrder());
        System.out.println(num.get(N-1));
    }
}
