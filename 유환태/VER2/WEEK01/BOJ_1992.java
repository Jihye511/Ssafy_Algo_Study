package boj;

import java.util.*;
import java.io.*;

public class BOJ_1992 {

    static int[][] data;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        data = new int[N][N];

        for(int r = 0; r < N; r++){
            String line = br.readLine();
            for(int c = 0; c < N; c++){
                data[r][c] = line.charAt(c) - '0';
            }
        }

        System.out.println( quadtree(data));
    }

    private static String quadtree(int[][] data) {
        if (isAllSame(data)) {
            return String.valueOf(data[0][0]);
        }

        int[][] data1 = new int[data.length/2][data.length/2];
        int[][] data2 = new int[data.length/2][data.length/2];
        int[][] data3 = new int[data.length/2][data.length/2];
        int[][] data4 = new int[data.length/2][data.length/2];

        for(int r = 0; r < data.length/2; r++){
            for(int c = 0; c < data.length/2; c++){
                data1[r][c] = data[r][c];
                data2[r][c] = data[r][c+data.length/2];
                data3[r][c] = data[r+data.length/2][c];
                data4[r][c] = data[r+data.length/2][c+data.length/2];
            }
        }


        return "("+ quadtree(data1) + quadtree(data2) + quadtree(data3) + quadtree(data4) +")";


    }

    private static boolean isAllSame(int[][] data) {
        int first = data[0][0];
        for (int[] row : data) {
            for (int val : row) {
                if (val != first) return false;
            }
        }
        return true;
    }
}
