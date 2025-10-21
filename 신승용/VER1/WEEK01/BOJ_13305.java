package 신승용.WEEK01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13305 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long answer = 0;

        long[] road = new long[N-1];
        long[] gas = new long[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < road.length; i++) {
            road[i] = Long.parseLong(st.nextToken());
            gas[i] = Long.parseLong(st2.nextToken());
        }

        gas[gas.length-1] = Long.parseLong(st2.nextToken());

        for (int i = 0; i < road.length; i++) {
            answer += gas[i] * road[i];
            int current = i;
            long sum = 0;
            for (int j = i+1; j < road.length; j++) {
                if(gas[i] < gas[j]){
                    sum += road[j];
                    current = j;
                } else {
                    break;
                }
            }
            answer += gas[i] * sum;
            i = current;
        }

        System.out.println(answer);
    }
}

/**
 * [5, 2, 4]
 * 
 * 현재 위치의 주유소에서 다음 주유소가 자기 보다 낮은 가격일 때 까지의
 * 거리를 전부 구매
 */