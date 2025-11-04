class Solution {
    public int solution(int[] players, int m, int k) {
        int N = players.length, c=0, answer=0, div;
        
        int[] arr = new int[N];
        
        for (int i=0; i<N; i++) {
            c-=arr[i];
            div = players[i]/m;
            
            if (div > c) {
                if (i+k<N) arr[i+k] = div-c;
                answer += div-c;
                c = div;
            }
        }
        return answer;
    }
}