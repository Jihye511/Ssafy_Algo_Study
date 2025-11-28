import java.util.*;
class Solution {
    public ArrayList<String> solution(String[] record) {
        HashMap<String, String> nickname = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String[]> result = new ArrayList<>();
        ArrayList<String> answer = new ArrayList<>();
        
        
        for(String str : record){
            String[] split = str.split(" ");
            String ord = split[0];
            String uid = split[1];
            
            
            if(ord.equals("Enter")){
                nickname.put(uid, split[2]);
                result.add(new String[] {uid, "님이 들어왔습니다."});
            }
            else if(ord.equals("Leave")){
                result.add(new String[] {uid, "님이 나갔습니다."});
            }
            else{
                nickname.put(uid, split[2]);
            }
        }
        
        for(String[] answer_list : result){
            answer.add(nickname.get(answer_list[0]) + answer_list[1]);
        }
        
        
        return answer;
    }
}
