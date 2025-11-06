import java.util.*;
import java.io.*;


public class Main
{
	static int ans, n, m, l, k;
	static ArrayList<int[]> list;
	
	public static void main (String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		
		for(int i = 0 ; i < k ; i++)
		{
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			list.add(new int[]{x,y});
		}
		
		for(int[] a1 : list)
		{
			for(int[] a2 : list)
			{
				shield(a1[0], a2[1]);
			}
		}
		
		System.out.println(k-ans);
	}
	public static void shield(int i, int j)
	{
		int cnt = 0;
		
		for(int[] arr : list)
		{
			//범위 내의 유성 존재 여부
			if(arr[0] >= i && arr[0] <= i+l && arr[1] >= j && arr[1] <= j+l) cnt++;
		}
		
		ans = Math.max(ans, cnt);
	}
}
