import java.util.Scanner;

public class Solution
{
	static int M[];
	static int n,k;
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		// 테스트케이스, 답
		int tc = sc.nextInt();

		// 인풋 받기: n강의 수, k들을 강좌수, d강의난이도
		for(int t = 0; t < tc; ++t)
		{
			n = sc.nextInt(); 
			k = sc.nextInt();
			M = new int[n]; // d = difficulty
			
			// 난이도 넣기
			for(int diff = 0; diff < M.length; diff++)  
				M[diff] = sc.nextInt();
		
			// 정렬
			for(int i = 0; i < M.length - 1; i++)
			{
				int min_idx = i;
				for(int j = i+1; j < M.length; j++)
				{
					if(M[j] < M[min_idx])
					{
						min_idx = j;
					}
				}
				int temp = M[min_idx];
				M[min_idx] = M[i];
				M[i] = temp;
			}
			// 답 구하기
			double A = 0.0;

			for(int i = M.length-k; i < M.length; ++i)
			{
				A = (A + M[i])/2.0;
			}
			
			System.out.println(String.format("#%d %f", t+1, A));
		}
	}
}