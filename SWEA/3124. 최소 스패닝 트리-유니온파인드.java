import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Solution
{
	static int[] parents;
	static int[] rank;

	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++)
		{
			String[] ve = br.readLine().split(" ");
			int V = Integer.parseInt(ve[0]);
			int E = Integer.parseInt(ve[1]);
			int[][] edges = new int[E][3];
			for (int i = 0; i < E; i++)
			{
				String[] abc = br.readLine().split(" ");
				int a = Integer.parseInt(abc[0]);
				int b = Integer.parseInt(abc[1]);
				int c = Integer.parseInt(abc[2]);
				edges[i][0] = a;
				edges[i][1] = b;
				edges[i][2] = c;
			}
			parents = new int[V+1];
			rank = new int[V+1];
			Arrays.sort(edges, new Comparator<int[]>()
			{
				@Override
				public int compare(int[] o1, int[] o2)
				{
					return o1[2] < o2[2] ?-1:1;
				}
			});

			for (int i = 1; i <= V; i++)
				make_set(i);

			long result = 0;
			for (int i = 0; i < E; i++)
			{
				// 간선배열정보를 탐색하면서, 시작-끝 정점이 속한 집합을 얻어와서
				int a = findSet(edges[i][0]);
				int b = findSet(edges[i][1]);
				// 서로 다른 집합(아직 연결되지 않은 정점) 이라면
				if (a != b)
				{
					// union
					union(a, b);
					// 가중치 누적
					result += edges[i][2];
				}
			}
			System.out.println("#"+tc+" "+result);
		}
	}

	static void make_set(int x)
	{
		parents[x] = x;
		rank[x] = 0;
	}

	static int findSet(int x)
	{
		if (x == parents[x])
			return x;
		else
		{
			parents[x] = findSet(parents[x]);
			return parents[x];
		}
	}

	static void union(int x, int y)
	{
		int px = findSet(x);
		int py = findSet(y);
		if (rank[px] > rank[py])
		{
			parents[py] = px;
		} else
		{
			parents[px] = py;
			if (rank[px] == rank[py])
			{
				rank[py]++;
			}
		}
	}
}