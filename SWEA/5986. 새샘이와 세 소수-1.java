import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Solution
{
	public static int N;
	public static boolean hapsung[];

	public static void main(String[] args) throws Exception
	{
		getHapsung();
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++)
		{
			sb.append("#").append(t).append(" ");
			//단위 테스트케이스 처리
			N = Integer.parseInt(br.readLine());
			//
			int cnt = getPrimeSumCnt(N);
			sb.append(cnt);
			sb.append("\n");
		}
		System.out.println(sb);
	}

	// 중간에 값을 더할 때 target을 넘어가지 않는지 확인!!
	private static int getPrimeSumCnt(int target)
	{
		int cnt = 0;
		for (int i = 2; i < hapsung.length; i++)
		{
			if(i < target && !hapsung[i])	// 합성수가 아니라면 다음 수에 관심이 있음.
			{
				for (int j = i; j < hapsung.length; j++)
				{
					if((i+j < target) &&!hapsung[j])
					{
						for (int k = j; k < hapsung.length; k++)
						{
							if(!hapsung[k])
							{
								if(i+j+k == target)
								{
									cnt++;
								}
							}
						}
					}
				}
			}
		}
		return cnt;
	}
	
	private static void getHapsung()
	{
		hapsung = new boolean[1000]; // N 은 7부터999까지
		for (int i = 2; i < hapsung.length; i++)
		{
			if(hapsung[i]) continue;
			for (int j = i*i; j < hapsung.length; j+=i) // i = 2이면 4, 6, 8, 10 확인하겠다는 뜻
			{											// i = 3이면 9, 12, 15, 18 ...
				hapsung[j] = true;
			}
		}
	}
}