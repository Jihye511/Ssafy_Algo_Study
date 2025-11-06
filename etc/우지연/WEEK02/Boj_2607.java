import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main_2607 {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        List<String> array = new ArrayList<>();
        /*
        set중복 없앤다는 가정하에
         기본 단어랑 비교 단어가 같은 길이면
         2개 남았을 경우 true
         없으면 true
         한개 남으면 true

         */
        int result=0;
        for(int i =0;i<N-1;i++){

String compare_Str = br.readLine();
            for(int z=0;z<compare_Str.length();z++){
                array.add(compare_Str.charAt(z)+"");

            }
for(int j=0;j<str.length();j++){
    if(array.contains(str.charAt(j)+"")){
        array.remove(str.charAt(j)+"");
    }
    else{
        array.add(str.charAt(j)+"");
    }

}

if(array.size()==0||array.size()==1){
    result++;
}
else if(array.size()==2){
   if(compare_Str.length()==str.length()&&!array.get(0).equals(array.get(1))){
result++;
    }

}
            array.clear();
        }
        System.out.println(result);

    }
}
