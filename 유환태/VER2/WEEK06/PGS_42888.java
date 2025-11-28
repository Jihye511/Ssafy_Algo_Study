import java.util.*;
import java.io.*;

class Solution {
    public List<String> solution(String[] record) {
        List<String> answer = new ArrayList<>();
        Map<String, String> users = new HashMap<>();
        for(String r : record){
            String[] str = r.split(" ");
            String op = str[0];
            String id = str[1];
            
            if(op.equals("Enter")){
                String name = str[2];
                users.put(id, name);
            }else if(op.equals("Change")){
                String name = str[2];
                users.replace(id, name);
            }
        }
        for(String r : record){
            String[] str = r.split(" ");
            String op = str[0];
            String id = str[1];
            
            if(op.equals("Enter")){
                String name = users.get(id);
                answer.add(name +"님이 들어왔습니다.");
            }else if(op.equals("Leave")){
                String name = users.get(id);
                answer.add(name +"님이 나갔습니다.");
            }
        }
        return answer;
    }
}