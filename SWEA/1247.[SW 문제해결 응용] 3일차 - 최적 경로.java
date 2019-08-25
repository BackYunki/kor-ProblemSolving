import java.util.Scanner;

class Position
{
	int x;
	int y;
	boolean visited;
	Position(int x, int y, boolean check)
	{
		this.x = x;
		this.y = y;
		this.visited = check;
	}
	public String toString()
	{
		return "x: " + x + " y: " + y;
	}
}

public class Solution {
	static int ans = 2147483647;
	
	// before 가 처음에 0이라서 회사부터 시작!
	public static void recur(Position[] house, int k, int N, int len, int before)
	{
		if(k == N)
		{
			// 마지막엔 모든 고객을 방문한 것이므로 마지막 방문지에서 집까지의 거리를 더한다. 
			len += (Math.abs(house[1].x - house[before].x) + Math.abs(house[1].y - house[before].y));
			
			// 최단거리를 이걸로 한다.
			if(ans > len)
			{
				ans = len;
			}
			
			return;
		}
		
		for (int i = 2; i < house.length; i++) {
			if(!house[i].visited)// 아직 방문 안 했으면
			{
				// i를 방문하고
				house[i].visited = true;
				// 그 때의 길이를 가지고 다른 고객을 방문 한 길이를 알아본다.
				recur(house, k + 1, N, len + Math.abs(house[i].x - house[before].x) + Math.abs(house[i].y - house[before].y), i); // i가 온 이유는 여기 방문을 하고 다음 으로 가기 때문임.
				house[i].visited = false;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			Position house[] = new Position[N+2];
			for (int i = 0; i < house.length; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				house[i] = new Position(x, y, false);
				//System.out.println(house[i]);
			}
			
			ans = 2147483647;
			// 방문 좌표들, 방문한 횟수, 고객 수, 길이, 이전까지의 최대길이
			recur(house, 0, N, 0, 0); // 파고들어가면서 len 값을 최단경로로 가지게 만들어보자.
			System.out.println("#" + tc + " " + ans);
		}
	}
}