import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1027 {
	
	public static int N;
	public static int[] arr;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
        int ans = 0;
		
		for (int i = 0; i < N; i++) {
            int visible = 0;

            // 오른쪽: 기울기 최대값 갱신
            double maxSlope = -1e300; // -INF 대용
            for (int j = i + 1; j < N; j++) {
                double slope = (double)(arr[j] - arr[i]) / (j - i);
                if (slope > maxSlope) {
                    maxSlope = slope;
                    visible++;
                }
            }

            // 왼쪽: 기울기 최소값 갱신
            double minSlope = 1e300; // +INF 대용
            for (int j = i - 1; j >= 0; j--) {
                double slope = (double)(arr[j] - arr[i]) / (j - i); // (j-i) < 0
                if (slope < minSlope) {
                    minSlope = slope;
                    visible++;
                }
            }

            ans = Math.max(ans, visible);
        }
		
		System.out.println(ans);
	}


}
