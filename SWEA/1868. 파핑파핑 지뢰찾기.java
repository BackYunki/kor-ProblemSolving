import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution
{
    public static int dir[][] = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
    public static int N;
    public static int click;
    private static char[][] map;
    private static int[][] visited;
    private static Queue<int[]> q;

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= tc; t++)
        {
            sb.append("#").append(t).append(" ");
            N = Integer.parseInt(br.readLine());
            map = new char[N][];
            visited = new int[N][N];
            q = new LinkedList<>();
            click = 0;

            for (int y = 0; y < N; y++)
            {
                map[y] = br.readLine().toCharArray();
            }

            // 지점 확인 후 bfs 처리
            for (int y = 0; y < N; y++)
            {
                for (int x = 0; x < N; x++)
                {
                    if(map[y][x] == '*') continue; // 지뢰면 관심 없다.
                    if (isArroundClear(y, x) && visited[y][x] == 0)// 주변이 깨끗하고 방문하지 않았을 경우
                    {
                        visited[y][x] = 1;
                        q.add(new int[]{y, x});
                        bfs();   // 다음 주변이 깨끗한 곳을 찾아가 처리
                        click++; // 한 번 깔 때마다 클릭 수 하나 증가
                    }
                }
            }

            for (int y = 0; y < N; y++)
            {
                for (int x = 0; x < N; x++)
                {
                    if (map[y][x] == '.' && visited[y][x] == 0)
                    {
                        click++;
                    }
                }
            }

            sb.append(click);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs()
    {
        while(!q.isEmpty())
        {
            // 항상 공식대로 한 놈을 떠내서 대장으로 부르자.
            int [] head = q.poll();

            // 얘를 기준으로 또 한 번 돌아보고 얘 주변이 깨끗해야한다.
            if(isArroundClear(head[0], head[1]))
            {
                // 주변이 깨끗하면 팔방으로 간다.
                for (int i = 0; i < dir.length; i++)
                {
                    int ny = head[0] + dir[i][0];
                    int nx = head[1] + dir[i][1];
                    // 주변이 일반 땅이면서 방문한 곳이 아니면
                    if (inRange(ny, nx) && map[ny][nx] == '.' && visited[ny][nx] == 0)
                    {
                        // 여긴 뒤집을 수 있는 곳들이다.
                        visited[ny][nx] = 1;
                        // 큐에 넣어서 다음에 탐색할 수 있게 한다.
                        q.add(new int[]{ny, nx});
                    }
                }
            }
        }
    }

    // 주변에 지뢰가 있냐? : 바로 깔 수 없는가? 클리어하면 거기가 bfs 출발점이다.
    public static boolean isArroundClear(int y, int x)
    {
        for (int i = 0; i < 8; i++)
        {
            int ny = y + dir[i][0];
            int nx = x + dir[i][1];

            // 지도 안에 있으면서 지뢰였으면 지뢰가 있는 거라서 false 리턴
            if (inRange(ny, nx) && map[ny][nx] == '*') return false;
        }
        // 아니면 깨끗
        return true;
    }

    // 지도 안에 있냐?
    public static boolean inRange(int y, int x)
    {
        return (0 <= y && y < N) && (0 <= x && x < N);
    }
}