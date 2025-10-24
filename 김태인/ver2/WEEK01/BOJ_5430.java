import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String order = br.readLine();
            int N = Integer.parseInt(br.readLine());
            String arr_string = br.readLine();
            String inner = arr_string.substring(1, arr_string.length() - 1);
            String[] arr = inner.isEmpty() ? new String[0] : inner.split(",");


            // true : 정방향, false : 역방향
            boolean flag = true;
            boolean error = false;
            int left = 0;
            int right = arr.length - 1;
            for (char ord : order.toCharArray()){
                if(ord == 'R') {
                    flag = !flag;
                }
                else{
                    if (left > right) {
                        error = true;
                        break;
                    }

                    if(flag) left++;
                    else right--;


                }
            }

            if (error){
                sb.append("error").append("\n");
                continue;
            }

            sb.append("[");
            if(left <= right){

                if(flag){
                    for (int i = left; i < right; i++) {
                        sb.append(arr[i]).append(",");
                    }
                    sb.append(arr[right]);
                }
                else{
                    for (int i = right; i > left; i--) {
                        sb.append(arr[i]).append(",");
                    }
                    sb.append(arr[left]);
                }

            }
            sb.append("]\n");

        }

        System.out.println(sb);



    }
}
