import java.util.*;

class Solution {
    static class Msg {
        String id;
        String action; 
        
        public Msg(String id, String action) {
            this.id = id;
            this.action = action;
        }
    }
    public String[] solution(String[] record) {
        ArrayList<String> answer = new ArrayList<>();
        
        HashMap<String, String> nickid = new HashMap<>();

        HashMap<String, String> msg = new HashMap<>();
        msg.put("Enter", "님이 들어왔습니다.");
        msg.put("Leave", "님이 나갔습니다." );
        
        ArrayList<Msg> list = new ArrayList<>();
        for (String str : record) {
            String[] spl = str.split(" ");
            String id = spl[1];
            if (spl[0].equals("Change")) {
                String name = spl[2];
                nickid.put(id,name);
            }
            else if (spl[0].equals("Enter")) {
                String name = spl[2];
                nickid.put(id,name);
                list.add(new Msg(id, spl[0]));
            }
            else {
                list.add(new Msg(id, spl[0]));
            }
        }
        
        StringBuilder sb = new StringBuilder();        
        for (Msg node : list) {
            String id = node.id;
            String action = node.action;
            
            answer.add(nickid.get(id) + msg.get(action));
        }
        
        return answer.toArray(new String[0]);
    }
}
