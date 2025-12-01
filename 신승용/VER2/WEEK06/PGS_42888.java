import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        Map<String, String> nameMap = new HashMap<>();
        List<String[]> list = new ArrayList<>();
        
        for(String rec : record){
            String[] commands = rec.split(" ");
                        
            String command = commands[0];
            String uid = commands[1];
            if(command.equals("Enter")){
                String name = commands[2];
                nameMap.put(uid, name);
                list.add(new String[]{command, uid});
            } else if(command.equals("Change")){
                String name = commands[2];
                nameMap.put(uid, name);
            } else if(command.equals("Leave")){
                list.add(new String[]{command, uid});
            }
            
        }
        
        answer = new String[list.size()];
        int index = 0;
        
        for(String[] commands : list){
            String command = commands[0];
            String uid = commands[1];
            
            if(command.equals("Enter")){
                answer[index++] = nameMap.get(uid) + "님이 들어왔습니다.";
            } else if(command.equals("Leave")){
                answer[index++] = nameMap.get(uid) + "님이 나갔습니다.";
            }
        }
        
        return answer;
    }
}