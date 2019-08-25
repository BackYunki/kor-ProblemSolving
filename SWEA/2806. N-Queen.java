import java.util.Scanner;

public class Solution 
{
	
	static int noc;// number of case: 경우의 수
	static int N; // N X N 체스판의 한 변의 길이
	
	public static void nqueen(int[] cols, int now)// n은 작업중인 행
	{
		if(now == N)//col.length == N X N 체스판의 한 변의 길이인 N을 의미
		{
			// 말이 마지막까지 놓였다는 의미이므로. noc++ 한다
			noc++;
		}
		else
		{
			for (int i = 0; i < N; i++)
			{
				cols[now] = i;
				if(isPromising(cols, now))
				{
					nqueen(cols, now+1);
				}
			}
		}
	}
	
	public static boolean isPromising(int[] cols, int now)
	{
		// 처음 행부터 내가 지금 놓기 전까지의 행까지 충돌 검사
		for (int i = 0; i < now; i++)
		{
			if(cols[now] == cols[i]) return false;
			if(Math.abs(cols[now]-cols[i]) == (now-i)) return false;
		}
		return true;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for (int t = 1; t <= tc; t++)
		{
			N = sc.nextInt();
			int[] cols = new int[N];
			noc = 0;

			nqueen(cols, 0);
			
			System.out.println("#"+t+" "+noc);
		}
	}
}