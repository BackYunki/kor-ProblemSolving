import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
	static long min = Long.MAX_VALUE;
	
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++)
		{
			int N = Integer.parseInt(br.readLine());
			int[][] pos = new int[N][2];
			for (int i = 0; i < N; i++)
			{
				// x,y 좌표 얻어오기
				String[] xy = br.readLine().split(" ");
				pos[i][0] = Integer.parseInt(xy[0]);
				pos[i][1] = Integer.parseInt(xy[1]);
			}
			// 모든 부분집합을 구하돼, true가 N의 절반만큼일 때의 백터합을 더해서 
			// 최솟값을 찾는다.
			min = Long.MAX_VALUE;
			powerSet(pos, new boolean[N], 0, N, 0);
			System.out.println("#"+t+" "+min);
		}
	}

	public static void powerSet(int[][] pos, boolean[] selected, int idx, int N, int tCnt)
	{
		if(idx == N)
		{
			if(tCnt == N/2)
			{
				//System.out.println(Arrays.toString(selected));	
				//이동하는 지렁이는 +
				//가만히 있는 지렁이는 -
				int totalX = 0;
				int totalY = 0;
				for (int i = 0; i < N; i++)
				{
					// true는 이동하는 지렁이
					if(selected[i])
					{
						totalX += pos[i][0];
						totalY += pos[i][1];
					}
					else
					{
						totalX -= pos[i][0];
						totalY -= pos[i][1];
					}
				}
				//System.out.println(Arrays.toString(selected) + " "+ totalX + " " + totalY);
				long tmp = totalX * (long)totalX + totalY * (long)totalY;
				if(min > tmp) min = tmp;
			}
			return;
		}
		selected[idx] = true;
		powerSet(pos, selected, idx+1, N, tCnt+1);
		selected[idx] = false;
		powerSet(pos, selected, idx+1, N, tCnt);
	}
}