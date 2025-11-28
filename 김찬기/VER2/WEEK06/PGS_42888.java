package VER2.WEEK06;

import java.io.*;
import java.util.*;

class Solution {

    static class Record {
        int type; // 1.입장 2.퇴장 3.변경
        String id;

        public Record(int type, String id) {
            this.type = type;
            this.id = id;
        }
    }

    public String[] solution(String[] record) {
        List<Record> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        for (int i=0; i<record.length; ++i) {
            String[] input = record[i].split(" ");
            if (input[0].equals("Enter")) {
                list.add(new Record(1, input[1]));
                map.put(input[1], input[2]);
            }
            else if (input[0].equals("Leave")) {
                list.add(new Record(2, input[1]));
            }
            else {
                map.put(input[1], input[2]);
            }
        }

        String[] answer = new String[list.size()];
        for (int i=0; i<list.size(); ++i) {
            Record curr = list.get(i);
            if (curr.type == 1) {
                answer[i] = map.get(curr.id) + "님이 들어왔습니다.";
            }
            else {
                answer[i] = map.get(curr.id) + "님이 나갔습니다.";
            }
        }

        return answer;
    }
}