import java.util.*;
class Solution {
    static HashMap<String, Integer> map;
    
    public ArrayList<Integer> solution(String msg) {
        map = new HashMap<>();
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 0; i < 26; i++){
            map.put(Character.toString('A' + i), i+1);
        }
        
        int len = msg.length();
        
        for(int i = 0; i < len; i++){
            StringBuilder now = new StringBuilder();
            now.append(msg.charAt(i));
            int idx = i + 1;
            while(true){
                
                if (idx >= len) {
                    answer.add(map.get(now.toString()));
                    break;
                }
                
                StringBuilder next = new StringBuilder();
                next.append(now.toString()).append(msg.charAt(idx));
                
                if(map.containsKey(next.toString())){
                    now.append(msg.charAt(idx));
                    idx++;
                }
                else{
                    answer.add(map.get(now.toString()));
                    map.put(next.toString(), map.size() + 1);
                    break;
                }
            }
                
            i = idx - 1;
        }
        
        return answer;
    }
}
