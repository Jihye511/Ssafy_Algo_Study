import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static char[] goal_buttons;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        char[] buttons = br.readLine().toCharArray();
        goal_buttons = br.readLine().toCharArray();


        int first_result = change_button(true, buttons);
        int second_result = change_button(false, buttons);

        int answer = Math.min(first_result, second_result);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);

    }

    public static int change_button(boolean check, char[] object_buttons){
        char[] buttons = clone(object_buttons);
        int result = 0;
        if(check){
            result++;
            buttons[0] = (buttons[0] == '1') ? '0' : '1';
            if (N > 1) {
                buttons[1] = (buttons[1] == '1') ? '0' : '1';
            }
        }

        for (int i = 1; i < N; i++) {
            if(buttons[i-1] != goal_buttons[i-1]){
                result++;
                buttons[i - 1] = (buttons[i - 1] == '1') ? '0' : '1';
                buttons[i] = (buttons[i] == '1') ? '0' : '1';
                if(i + 1 < N){
                    buttons[i + 1] = (buttons[i + 1] == '1') ? '0' : '1';
                }

            }
        }

        if (!is_same(buttons)) return Integer.MAX_VALUE;

        return result;
    }

    public static char[] clone(char[] buttons){
        char[] temp = new char[N];
        for (int i = 0; i < N; i++) {
            temp[i] = buttons[i];
        }
        return temp;
    }

    public static boolean is_same(char[] buttons){

        for (int i = 0; i < N; i++) {
            if(buttons[i] != goal_buttons[i]) return false;
        }
        return true;
    }

}
