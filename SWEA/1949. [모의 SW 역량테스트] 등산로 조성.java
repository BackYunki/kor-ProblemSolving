import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution
{
    public static int N, K;
    public static int max;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++)
        {
            max = Integer.MIN_VALUE;
            sb.append("#").append(t).append(" ");
            ////////////////////////////////////////
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            
            int[][] map = new int[N][N];
            int peek = Integer.MIN_VALUE;
            
            ArrayList<int[]> peek_list = new ArrayList<>();
            ArrayList<int[]> height_list = new ArrayList<>();
            for (int i = 0; i < N; i++)
            {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++)
                {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    peek = Math.max(peek, map[i][j]);
                    height_list.add(new int[]{i, j, map[i][j]});
                }
            }
            // 최대 높이를 갖는 봉우리의 좌표를 저장한다.
            for (int[] height : height_list)
            {
                if (height[2] == peek) peek_list.add(new int[]{height[0], height[1]});
            }
            ////////////////////////////////////////
            for (int[] peek_elem : peek_list)
            {
                int y = peek_elem[0];
                int x = peek_elem[1];
                dfs(map, new boolean[N][N], y, x, 1, true);
            }
            ////////////////////////////////////////
            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }

    public static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void dfs(int[][] map, boolean[][] visited, int y, int x, int cnt, boolean canCut)
    {
        max = Math.max(max, cnt);
        visited[y][x] = true;
        for (int i = 0; i < 4; i++)
        {
            int ny = y + dir[i][0];
            int nx = x + dir[i][1];

            if (inRange(ny, nx) && !visited[ny][nx])
            {
                // 아니면 나보다 작은가
                if (map[ny][nx] < map[y][x])
                {
                    dfs(map, visited, ny, nx, cnt + 1, canCut);
                }
                // 내가 읽는 놈이 나보다 크거나 같은가?
                else if ((map[ny][nx] >= map[y][x]) && canCut)
                {
                    for (int j = 1; j <= K; j++)
                    {
                        // 뺄 수 있는 만큼 빼면서 나보다 작은가?
                        if (map[ny][nx] - j < map[y][x])
                        {
                            map[ny][nx] -= j;
                            dfs(map, visited, ny, nx, cnt + 1, false);
                            map[ny][nx] += j;
                            //canCut = true;
                        }
                    }
                }
            }
        }
        visited[y][x] = false;
    }
    public static boolean inRange(int y, int x) { return (0 <= y && y < N) && (0 <= x && x < N);}
}