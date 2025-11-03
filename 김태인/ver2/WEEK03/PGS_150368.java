class Solution {
    static int people = 0;
    static int cost = 0;
    static int M, N;
    static int[] sales = {10, 20, 30, 40};
    public int[] solution(int[][] users, int[] emoticons) {
        N = users.length;
        M = emoticons.length;
        dfs(0, new int[M], users, emoticons);
        int[] answer = {people, cost};
        return answer;
    }
    
    public static void dfs(int idx, int[] discount, int[][] users, int[] emoticons){
        if(idx == M){
            int[] result = check(discount, users, emoticons);
            if(result[0] > people){
                people = result[0];
                cost = result[1];
            }
            else if (result[0] == people && result[1] > cost){
                cost = result[1];
            }
            return;
        }
        
        for(int i = 0; i < 4; i++){
            discount[idx] = sales[i];
            dfs(idx + 1, discount, users, emoticons);
        }
        
    }
    
    public static int[] check(int[] discount, int[][] users, int[] emoticons){
        int plus_people = 0;
        int buy_emotion = 0;
        
        for(int i = 0; i < N; i++){
            int cost = 0;
            for(int j = 0; j < M; j++){
                if(users[i][0] <= discount[j]){
                    cost = cost + (int) (emoticons[j] / 100) * (100 - discount[j]);
                }
            }
            if(cost >= users[i][1]){
                plus_people ++;
            }
            else{
                buy_emotion += cost;
            }
        }
        
        return new int[] {plus_people, buy_emotion};
        
    }
}
