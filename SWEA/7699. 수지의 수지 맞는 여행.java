import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution {
   public static int Y,X;
   
   public static char[][] map;
   
   public static void main(String[] args) throws Exception {
      StringBuilder sb = new StringBuilder();
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      StringTokenizer st = null;
      int tc = Integer.parseInt(br.readLine());
      
      for (int t = 1; t <= tc; ++t) {
         max = Integer.MIN_VALUE;
         ////////////////////////////////
         String[] YX = br.readLine().split(" ");
         Y = Integer.parseInt(YX[0]);
         X = Integer.parseInt(YX[1]);
         map = new char[Y][X];
         
         for (int y = 0; y < Y; y++) {
            map[y] = br.readLine().toCharArray();
         }
         
         boolean[] visited = new boolean[26];
         visited[map[0][0]-'A'] = true;
         dfs(visited, 0, 0, 1);
         
         ////////////////////////////////
         sb.append("#").append(t).append(" ").append(max).append("\n");
      }
      System.out.println(sb);
   }
   
   public static int max;
   public static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
   public static boolean inRange(int y, int x) {
      return (0 <= y && y < Y) && (0 <= x && x < X);
   }
   public static void dfs(boolean[] visited, int y, int x, int k) {
      max = Math.max(max, k);
      
      for (int i = 0; i < 4; i++) {
         int ny = y + dir[i][0];
         int nx = x + dir[i][1];
         if(inRange(ny, nx)) {
            int temple = map[ny][nx]-'A';
            if(visited[temple]) continue;
            visited[temple] = true;
            dfs(visited, ny, nx, k+1);
            visited[temple] = false;
         }
      }
   }
}