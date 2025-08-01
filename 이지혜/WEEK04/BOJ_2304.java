import java.io.*;
import java.util.*;

public class Main {
    static class Point{
        int x,y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Point> points = new ArrayList<>();
        int maxH = 0;
        int maxX = 0;
        for(int i =0; i<N; i++){
            StringTokenizer st= new StringTokenizer(br.readLine());

            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            points.add(new Point(L,H));
            if(H>maxH){
                maxH = H;
                maxX = L;
            }
        }
        Collections.sort(points,(a,b)->a.x-b.x);
        //왼쪽에서 출발
        int area = 0;
        int curY= points.get(0).y;
        int curX= points.get(0).x;
        for(Point p : points){
            if(p.x >maxX) break;
            if(p.y >= curY){
                area += (p.x - curX)*curY;
                curX = p.x;
                curY = p.y;
            }
        }

        //오른쪽부터 출발
        curX = points.get(points.size()-1).x;
        curY = points.get(points.size()-1).y;
        for(int i =points.size()-1; i>=0; i--){
            Point p = points.get(i);
            if(p.x<maxX) break;;
            if(p.y>=curY){
                area += (curX - p.x)*curY;
                curX = p.x;
                curY = p.y;
            }
        }

        area += maxH;
        System.out.println(area);
    }
}
