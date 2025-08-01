import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] height = new int[1001];
        int left = 1000;
        int right = 0;
        int maxPos = 0;
        int maxH = 0;
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int pos = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            height[pos] = h;
            
            if (pos < left)  left = pos;
            if (pos > right) right = pos;
            if (h > maxH) {
                maxH = h;
                maxPos = pos;
            }
        }
        
        int ans = 0;
        int cMax = 0;
        for (int i = left; i <= maxPos; i++) {
            if (height[i] > cMax) {
                cMax = height[i];
            }
            ans += cMax;
        }
        cMax = 0;
        for (int i = right; i > maxPos; i--) {
            if (height[i] > cMax) {
                cMax = height[i];
            }
            ans += cMax;
        }
        
        System.out.println(ans);
    }
}
