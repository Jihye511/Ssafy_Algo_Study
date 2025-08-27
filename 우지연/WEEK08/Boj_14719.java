import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14719 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[] arr = new int[W];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
		}

		int result = 0;

		for (int i = 1; i < W - 1; i++) {
			int leftcheck = 0;
			int rightcheck = 0;

			for (int j = 0; j < i; j++) {
				leftcheck = Math.max(leftcheck, arr[j]);
			}

			for (int j = i + 1; j < W; j++) {
				rightcheck = Math.max(rightcheck, arr[j]);

			}
			if (arr[i] < leftcheck && arr[i] < rightcheck) {
				result += (Math.min(leftcheck, rightcheck) - arr[i]);
			}

		}
		System.out.println(result);
	}

}
