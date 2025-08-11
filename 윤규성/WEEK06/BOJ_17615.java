import java.util.*;
import java.io.*;

public class BOJ_17615 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N  = Integer.parseInt(st.nextToken());
    String str = br.readLine();
    char[] chs = str.toCharArray();

    ArrayList<Integer> blue = new ArrayList<>();
    ArrayList<Integer> red = new ArrayList<>();
    for(int i = 0; i < N; i++){
      if(chs[i] == 'R') red.add(i);
      else blue.add(i);
    }

    int r_size = red.size();
    int b_size = blue.size();

    int red_first = 0;
    int blue_first = 0;
    int red_last = 0;
    int blue_last = 0;

    // red를 맨 앞으로
    int idx = 0;
    while(idx < r_size){
      if(red.get(idx) != idx) break;
      idx++;
    }
    red_first = r_size - idx;

    // blue를 맨 앞으로
    idx = 0;
    while(idx < b_size){
      if(blue.get(idx) != idx) break;
      idx++;
    }
    blue_first = b_size - idx;

    // red를 맨 뒤로
    idx = 0;
    while(idx < r_size){
      if(red.get(r_size - idx - 1) != N - idx - 1) break;
      idx++;
    }
    red_last = red.size() - idx;

    // red를 맨 앞으로
    idx = 0;
    while(idx < b_size){
      if(blue.get(b_size - idx - 1) != N - idx - 1) break;
      idx++;
    }
    blue_last = blue.size() - idx;

    int ans = Math.min(Math.min(red_first, red_last), Math.min(blue_first, blue_last));
    System.out.println(ans);
  }
}
