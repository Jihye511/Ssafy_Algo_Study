import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2304 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] array = new int[1001];
		int start = Integer.MAX_VALUE;
		int end = Integer.MIN_VALUE;
		int max_height = Integer.MIN_VALUE;
		int max_idx = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			array[L] = H;
			if (max_height < H) {
				max_height = H;
				max_idx = L;
			}
			if (L <= start) {
				start = L;
			}
			if (L >= end) {
				end = L;
			}
		}
		int result = 0;
		int num = array[start];
		for (int i = start; i < max_idx; i++) {
			if (array[i] > num) {
				num = array[i];
			}
			result += num;
		}

		num = array[end];
		for (int i = end; i > max_idx; i--) {
			if (array[i] > num) {
				num = array[i];
			}
			result += num;
		}

		result += max_height;
		System.out.println(result);

	}

}
