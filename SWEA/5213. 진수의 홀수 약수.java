import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution
{
	public static long[] nums = new long[1000000+1];
	public static void makeTable()
	{
		for (int i = 1; i <= nums.length-1; i++)
		{
			if(i % 2 == 1)
			{
				for (int j = i; j <= nums.length-1; j+=i)
					nums[j] += i;
			}
			nums[i] += nums[i-1];
		}
	}
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		makeTable();
		for (int t = 1; t <= tc; t++)
		{
			sb.append("#").append(t).append(" ");
			// tc 처리
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			// LR을 읽어왔으니 이제 이 사이에 있는 수 만큼 약수의 개수를 담는 배열 생성
			
			long sum = nums[R]-nums[L-1];
			sb.append(sum);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}