import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

public class Solution
{
	static class Stop
	{
		int num;
		int cnt = 0;
		Stop(int num)
		{
			this.num = num;
		}
		@Override
		public String toString()
		{
			return "stop:["+num+", "+cnt+"]";
		}
	}
	static class Line
	{
		int s,e;
		Line(){}
		Line(int s, int e)
		{
			this.s = s;
			this.e = e;
		}
		public String toString()
		{
			return "[s:"+s+", "+"e:"+e+"]";
		}
	}
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= tc; t++)
		{
			sb.append("#").append(t).append(" ");
			
			
			// tc 시작
			int N = Integer.parseInt(br.readLine().trim());
			Line[] lines = new Line[N];
			for (int n = 0; n < N; n++)
			{
				String[] AB = br.readLine().split(" ");
				int s = Integer.parseInt(AB[0]);
				int e = Integer.parseInt(AB[1]);
				lines[n] = new Line(s, e);
			}
			//System.out.println(Arrays.toString(lines));
			//노선 테케 받았고
			// P로 정류장 정보를 저장한다. C는 각 버정을 의미
			int P = Integer.parseInt(br.readLine().trim());
			Stop[] stops = new Stop[P];
			// i번째 노선에 대해서 각각을 C에 더해간다.
			for (int i = 0; i < P; i++)
			{
				int num = Integer.parseInt(br.readLine().trim());
				stops[i] = new Stop(num);
			}
			//System.out.println(Arrays.toString(stops));
			//각 노선배열을 읽으면서 더해나간다.
			for (int i = 0; i < N; i++)
			{
				int s = lines[i].s;
				int e = lines[i].e;
				for (int c = 0; c < P; c++)
				{
					int num = stops[c].num;
					for (int j = s; j <= e; j++)
					{
						if(j == num)
						{
							stops[c].cnt++;
						}
					}	
				}
			}
			for (int c = 0; c < stops.length; c++)
			{
				sb.append(stops[c].cnt+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}