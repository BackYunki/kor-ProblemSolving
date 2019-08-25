import java.util.*;
import java.io.*;
public class Solution
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++)
		{
			int N = Integer.parseInt(br.readLine());
			int arr[] = new int[N];
			int cnt[] = new int[51];	// 5~50까지의 수가 올 수 있는데. 각 숫자가 몇개 들었는지 cnt에 기록
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int idx = 0;
			while(st.hasMoreTokens())
			{
				arr[idx] = Integer.parseInt(st.nextToken());
				cnt[arr[idx++]]++; 
			}
			
			// result
			System.out.print("#"+(i+1)+" ");
			for (int j = 0; j < cnt.length; j++)
			{
				for (int j2 = 0; j2 < cnt[j]; j2++)
				{
					System.out.print( j +" ");
				}
			}
			System.out.println();
		}
		br.close();
	}
}