import java.util.*;

class PGS150368 {
    public int N, M;
    public int[] sale_ratio, emoticons, saled_emoticons, maxes;
    public int[][] users;
    
    public int[] solution(int[][] users, int[] emoticons) {
        maxes = new int[2];
        saled_emoticons = new int[emoticons.length];
        
        N = users.length;
        M = emoticons.length;
        
        this.users = users;
        this.emoticons = emoticons;
        
        sale_ratio = new int[M];
        dfs(0);
        
        return maxes;
    }
    
    public void dfs(int depth) {
        if(depth == M) {
            compute();
            return;
        }
        
        for(int i = 1; i < 5; i++){
            sale_ratio[depth] = i * 10;
            
            dfs(depth + 1);
            
            sale_ratio[depth] = 0;
        }
    }
    
    public void compute(){        
        for(int i = 0; i < M; i++ ){
            saled_emoticons[i] = (int) (emoticons[i] - (emoticons[i] * ( (double)(sale_ratio[i]) / 100)));
        }
                
        // 플러스 신청자 : use_plus[]
        // 각 매출액 : fees[]
        
        boolean[] use_plus = new boolean[N];
        int[] fees = new int[N];
        
        for(int i = 0; i < N; i++){     // 이용자들에 대해
            
            for(int j = 0; j < M; j++){     // 이모티콘에 대해
                
                if(sale_ratio[j] >= users[i][0]) {     // 어머 이건 사야해
                    fees[i] += saled_emoticons[j]; 
                }
                
            }
            
            if(fees[i] >= users[i][1]) {    // 이 돈이면
                fees[i] = 0;
                use_plus[i] = true;
            }
        }

        int cnt = 0;
        int sum = Arrays.stream(fees).sum();
        for(int i = 0; i < N; i++){
            if(use_plus[i]) cnt++;    
        }
        
        if(maxes[0] == cnt && maxes[1] < sum) {
            maxes[1] = sum;
        }else if(maxes[0] < cnt) {
            maxes[0] = cnt;
            maxes[1] = sum;
        }
        
    }
}