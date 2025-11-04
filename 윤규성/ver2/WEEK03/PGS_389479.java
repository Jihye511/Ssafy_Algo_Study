class PGS_389479 {
  public int solution(int[] players, int m, int k) {
    int answer = 0;

    int[] servers = new int[24];
    int scale_up_cnt = 0;

    for(int i = 0; i < 24; i++) {

      int now_available = m * (servers[i] + 1);

      if( now_available <= players[i] ) {  // 이용자 수가 현재 서버보다 크면
        // 증설

        int how_many_scale_up = (players[i] - now_available) / m + 1;

        scale_up_cnt += how_many_scale_up;
        for(int j = i; j < i + k; j++){
          if(j >= 24) continue;
          servers[j] += how_many_scale_up;
        }

      }

    }

    return scale_up_cnt;
  }
}