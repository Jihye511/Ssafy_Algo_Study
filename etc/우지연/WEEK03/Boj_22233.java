import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_22233 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
int N = Integer.parseInt(st.nextToken());
int M = Integer.parseInt(st.nextToken());
        HashSet<String> word = new HashSet<>();
        String str="";
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            str = st.nextToken();
            word.add(str);
        }
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            str=st.nextToken();
            String[] array = str.split(",");
            for (int j=0; j < array.length; j++) {
              word.remove(array[j]);

            }
          System.out.println(word.size());
            }


        }


    }

