import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	
	static ArrayList<Vertex>[] vertexList;
	static boolean[] visited;
	static int cnt = 0;
	static long result = 0; // 이게 중요!!
	
	public static void print(ArrayList<Vertex> list[])
	{
		for (int i = 1; i < list.length; i++) {
			System.out.println(i+"->"+list[i]);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			String[] ve = br.readLine().split(" ");
			int V = Integer.parseInt(ve[0]);// 정점의 갯수
			int E = Integer.parseInt(ve[1]); // 간선의 갯수
			
			//각 정점은 하나씩의 ArrayList를 가지고, 거기에 자신과 연결된 정점과 비용정보를 저장할거임
			//정점번호가 0~V-1이 아니라 1~V 니까
			vertexList = new ArrayList[V+1];
			visited  = new boolean[V+1];
			for(int i = 1; i < V+1; i++) {
				vertexList[i] = new ArrayList<>();
			}
			//E개의 간선정보 입력받기
			for(int i = 0; i < E; i++) {
				String[] abc = br.readLine().split(" ");
				int a = Integer.parseInt(abc[0]);
				int b = Integer.parseInt(abc[1]);
				int c = Integer.parseInt(abc[2]);
				
				vertexList[a].add(new Vertex(b, c));
				vertexList[b].add(new Vertex(a, c));
			}
			//연결정보
			//print(vertexList);
			
			PriorityQueue<Vertex> pq = new PriorityQueue<>();
			
			//1번을 시작점으로 잡음
			visited[1] = true;
			for (Vertex v : vertexList[1])
				pq.add(v);
			//System.out.println(pq);
			
			cnt = 0;
			result = 0;
			while(!pq.isEmpty())
			{
				if(cnt == V) break;
				
				Vertex vertex = pq.poll();
				if(visited[vertex.v]) continue;
				
				cnt++;
				result += vertex.cost;
				visited[vertex.v] = true;
				for (Vertex v : vertexList[vertex.v])
					pq.add(v);
				//System.out.println(pq + " "+cnt);
				//System.out.println();
			}
			System.out.println("#"+tc+" "+result);
		}
	}
	
	static class Vertex implements Comparable<Vertex>{
		int v;
		long cost;
		public Vertex(int v, long cost) {
			this.v = v;
			this.cost = cost;
		}
		public int compareTo(Vertex o) {
			if(cost < o.cost)
				return -1;
			else if ( cost > o.cost )
				return 1;
			return 0;
		}
		public String toString()
		{
			return v+"("+cost+")";
		}
	}
}