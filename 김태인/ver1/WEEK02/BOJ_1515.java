    import java.util.*;
    import java.io.*;

    public class Main {

        public static void main(String[] args) throws Exception{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine();

            int point = 0;
            int base = 1;

            String temp;
            while(true){
                temp = String.valueOf(base);
                for (int i = 0; i < temp.length(); i++) {
                    if(temp.charAt(i) == str.charAt(point)){
                        point++;
                    }
                    if(point == str.length()){
                        System.out.println(base);
                        return;
                    }
                }
                base++;
            }
        }
    }
