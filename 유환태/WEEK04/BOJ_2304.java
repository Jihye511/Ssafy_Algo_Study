import java.util.*;
import java.io.*;

public class Main {
    static class Square{
        int L;
        int H;
         Square(int l,int h){
            L = l;
            H = h;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        List<Square> list = new ArrayList<Square>();
        int maxH = Integer.MIN_VALUE;
        
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            list.add(new Square(l,h));
            maxH = Math.max(maxH,h);
        }

        List<Square> max_list = new ArrayList<>();

        Collections.sort(list, (o1,o2)->o1.L - o2.L);

        for(Square s : list){
            if(s.H==maxH){
                max_list.add(s);
            }   
        }
        
        Queue<Square> lq = new ArrayDeque<>();
        Queue<Square> rq = new ArrayDeque<>();
        int leftH = 0;
        int rightH = 0;

        for(int i=0;i<N;i++){
            Square ls = list.get(i);
            if(ls.H==maxH) {
                lq.add(new Square(ls.L,ls.H));
                break;
            }
            if(leftH ==0){
                lq.add(new Square(ls.L,ls.H));
                leftH = ls.H;
            }else{
                if(ls.H > leftH){
                    lq.add(new Square(ls.L,ls.H));
                    leftH = ls.H;
                }
            }
        }

        for(int i=N-1;i>0;i--){
            Square rs = list.get(i);
            if(rs.H==maxH) {
                rq.add(new Square(rs.L,rs.H));
                break;
            }
            if(rightH ==0){
                rq.add(new Square(rs.L,rs.H));
                rightH = rs.H;
            }else{
                if(rs.H > rightH){
                    rq.add(new Square(rs.L,rs.H));
                    rightH = rs.H;
                }
            }
        }

        int leftsum = 0;
        int rightsum = 0;
        Square left = lq.poll();
        Square right = rq.poll();

        while(!lq.isEmpty()){
            Square ls = lq.poll();
            leftsum += (ls.L - left.L) * (left.H);
            left = ls;
        }

        while(!rq.isEmpty()){
            Square rs = rq.poll();
            rightsum += (right.L - rs.L) * (right.H);
            right = rs;
        }

        
        
        System.out.println(leftsum + rightsum + maxH * (max_list.get(max_list.size()-1).L - max_list.get(0).L+1));



    }
}
