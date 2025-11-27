package VER2.WEEK06;

import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put(String.valueOf((char) ('A' + i)), i + 1);
        }

        List<Integer> result = new ArrayList<>();
        int idx = 0;

        while (idx + 1 < msg.length()){
            String curr = "";
            String prev = String.valueOf(msg.charAt(idx));

            for (int i = 1; idx + i <= msg.length() ; i++) {
                curr = msg.substring(idx, idx + i);
                if(!map.containsKey(curr)){
                    map.put(curr, map.size() + 1);
                    break;
                }
                prev = curr;
            }

            result.add(map.get(prev));
            idx = idx + prev.length();
        }

        if(idx == msg.length() - 1){
            result.add(map.get(String.valueOf(msg.charAt(idx))));
        }

        int[] answer = new int[result.size()];
        for (int i=0; i<result.size(); ++i) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}