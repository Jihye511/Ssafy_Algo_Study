import java.io.*;
import java.util.*;
public class Main {
    static int N,K;
    static class Container{
        int value;
        boolean visited;
        public Container(int value,boolean visited){
            this.value=value;
            this.visited=visited;
        }
    }
    static Container[] containers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        containers = new Container[2*N+1];
        st = new StringTokenizer(br.readLine());
        //칸별 내구도 세팅
        for(int i =1; i<=N; i++ ){
            containers[i] = new Container(Integer.parseInt(st.nextToken()),false);
        }
        for(int i=N+1; i<=2*N; i++){
            containers[i] = new  Container(Integer.parseInt(st.nextToken()),false);
        }
        int level =1;
        while(true){
            movingContainer();
            moveRobot();
            putRobot();
            if(countBlock())break;
            level++;
        }
        System.out.println(level);

    }
    //1. 컨테이너 한칸씩 이동
    public static void movingContainer(){
        Container before  = containers[1];
        Container temp;
        for(int i=2; i<=2*N; i++){
            temp = containers[i];
            containers[i] = before;
            before = temp;
        }
        containers[1] = before;
        for(int i =N; i<=2*N; i++){
            containers[i].visited = false;
        }

    }

    //2. 벨트위 로봇 한칸 이동
    public static void moveRobot(){
        for(int i =N-1; i>0; i--){
            if(containers[i].visited){//현재 로봇이 있다면
                if(i == N-1){
                    if(containers[N].value >0){
                        containers[i].visited = false;
                        containers[N].value--;
                    }
                }else if(containers[i+1].value > 0 && !containers[i+1].visited){
                    containers[i].visited = false;
                    containers[i+1].visited = true;
                    containers[i+1].value -=1;
                }
            }
        }
    }

    //3. 1번 칸 내구도 0이 아니라면 로봇 올리기
    public static void putRobot(){
        if(containers[1].value > 0 && !containers[1].visited){
            containers[1].visited = true;
            containers[1].value -=1;
        }
    }
    //4. 내구도 0인 칸 개수 확인 (K개 이상이면 ture => 종료)
    public static boolean countBlock(){
        int cnt = 0;
        for(int i=1; i<=2*N; i++){
            if(containers[i].value == 0) cnt++;
        }
        return cnt>=K;
    }

}
