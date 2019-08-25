import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	static int N;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			N = sc.nextInt();
			map = new int[N][N];
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					map[y][x] = sc.nextInt();
				}
			}
			
			int maxChunk = 0;
			
			for (int day = 0; day <= 100; day++) {
				ArrayList<int[]> cheeze = new ArrayList<>();
				for (int y = 0; y < N; y++) {
					for (int x = 0; x < N; x++) {
						// 갉아 먹고
						if(map[y][x] == day) {
							map[y][x] = 0;
						} 
						// 치즈 위치 기억
						else if(map[y][x] != 0 && map[y][x] != day) {
							cheeze.add(new int[] {y,x});
						}
					}
				}
				
				// 치즈 위치를 돌면서 
				int chunks = 0;
				boolean[][] visited = new boolean[N][N];
				for(int[] pos : cheeze) {
					int y = pos[0];
					int x = pos[1];
					
					if(visited[y][x]) continue;
					visited[y][x] = true;
					dfs(visited, y, x);
					
					chunks++;
				}
                
				if(chunks == 0) break;
				maxChunk = Math.max(maxChunk, chunks);
			}
			
			System.out.println("#"+t+" "+maxChunk);
		}
	}
	
	static int[][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};
	static boolean inRange(int y, int x) {
		return (0 <= y && y < N) && (0 <= x && x < N);
	}
	static void dfs(boolean[][] visited, int y, int x) {
		for (int i = 0; i < 4; i++) {
			int ny = y + dir[i][0];
			int nx = x + dir[i][1];
			
			if(inRange(ny, nx) && !visited[ny][nx] && map[ny][nx] != 0) {
				visited[ny][nx] = true;
				dfs(visited, ny, nx);
			}
		}
	}
}