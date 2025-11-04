import java.io.*;
import java.util.*;

public class Main_20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      Map<String,Integer> map = new HashMap<>();
        String word;
      for(int i=0;i<N;i++){
          st = new StringTokenizer(br.readLine());
          word = st.nextToken();
          if(word.length()>=M){
              if(map.containsKey(word)){
                  map.put(word,map.get(word)+1);
              }
              else{
                  map.put(word,1);
              }
          }



      }
      List<String> keySet = new ArrayList<>(map.keySet());


        keySet.sort((o1, o2) -> {

            if (map.get(o1).equals(map.get(o2))) {
                if(o1.length()==o2.length()){
                    return o1.compareTo(o2);
                }
                return Integer.compare( o2.length(),o1.length());
            }
            return map.get(o2).compareTo(map.get(o1));
        });
BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(String words:keySet){
            bw.write(words);
            bw.newLine();
        }
        bw.flush();
    }
}
