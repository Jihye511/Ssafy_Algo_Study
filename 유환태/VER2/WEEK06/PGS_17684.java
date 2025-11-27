import java.util.*;
import java.io.*;

class Solution {
    public List<Integer> solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        int len = msg.length();
        List<String> words = new ArrayList<>();
        for(int i = 0; i < 26; i++){
            words.add(String.valueOf((char)('A' + i)));
        }
        
        int idx = 0;
        String word = "";
        while(idx < len){
            word += msg.charAt(idx);
            if(!words.contains(word)){
                String find = word.substring(0, word.length()-1);
                answer.add(words.indexOf(find)+1);
                words.add(word);
                word = "";
                idx--;
            }
            idx++;
        }
        if(words.contains(word)){
            answer.add(words.indexOf(word)+1);
        }
        
        return answer;
    }
}