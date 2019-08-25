import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution
{
    public static int Y,X;
    public static int[] dy = {-1, 1, 0, 0};
    public static int[] dx = {0, 0, -1, 1};
    public static boolean ans;

    public static class Job
    {
        int y,x,dir,mem;

        public Job(int y, int x, int dir, int mem)
        {
            this.y = y;
            this.x = x;
            this.dir= dir;
            this.mem = mem;
        }
    }
    public static void main(String[] args) throws Exception
    {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++)
        {
            sb.append("#").append(t).append(" ");
            //////////////////////////////////////
            StringTokenizer st = new StringTokenizer(br.readLine());
            Y = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            char[][] map = new char[Y][X];
            boolean canFinish = false; // 골뱅이가 존재하지 않는 경우가 있을 수 있다. 미리 걸러줄 수 있음.
            for (int y = 0; y < Y; y++)
            {
                String row = br.readLine();
                for (int x = 0; x < X; x++)
                {
                    map[y][x] = row.charAt(x);
                    if (map[y][x] == '@') canFinish = true;
                }
            }
            // 위치와 상태에 대한 모든 정보를 포함한다. 4는 방향, 16은 0~15까지의 수
            boolean[][][][] visited = new boolean[Y][X][4][16];
            ans = false;
            if (canFinish)
            {
                Queue<Job> q = new LinkedList<>();
                q.add(new Job(0, 0, 3, 0));
                loop:
                while (!q.isEmpty())
                {
                    Job head = q.poll();
                    if (visited[head.y][head.x][head.dir][head.mem]) continue;  // 루프면 다른 길로 간다.
                    visited[head.y][head.x][head.dir][head.mem] = true;

                    switch (map[head.y][head.x])
                    {
                        case '@':
                            // 종료처리
                            ans = true;
                            break loop; // 종료를 만나면 while 루프를 나간다.
                        case '^':
                            head.dir = 0;
                            break;
                        case 'v':
                            head.dir = 1;
                            break;
                        case '<':
                            head.dir = 2;
                            break;
                        case '>':
                            head.dir = 3;
                            break;
                        case '_':
                            head.dir = (head.mem == 0 ? 3 : 2);
                            break;
                        case '|':
                            head.dir = (head.mem == 0 ? 1 : 0);
                            break;
                        case '?':
                            // 사방처리
                            for (int i = 0; i < 4; i++)
                            {
                                int ny = head.y + dy[i];
                                int nx = head.x + dx[i];
                                ny = (ny == map.length ? 0 : ny);
                                ny = (ny == -1 ? map.length - 1 : ny);
                                nx = (nx == map[ny].length ? 0 : nx);
                                nx = (nx == -1 ? map[ny].length - 1 : nx);
                                q.add(new Job(ny, nx, i, head.mem));
                            }
                            continue;
                        case '.':
                            break; // 아무것도 안 함
                        case '+':
                            head.mem = (head.mem == 15 ? 0 : head.mem + 1);
                            break;
                        case '-':
                            head.mem = (head.mem == 0 ? 15 : head.mem - 1);
                            break;
                        default:
                            // 0 ~ 9 까지의 숫자가 들어오는데 그걸 메모리에 저장함.
                            head.mem = map[head.y][head.x] - '0';
                            break;
                    }
                    // 새로운 상태의 Job 객체 생성해서 큐에 추가
                    int ny = head.y + dy[head.dir];
                    int nx = head.x + dx[head.dir];
                    ny = (ny == map.length ? 0 : ny);
                    ny = (ny == -1 ? map.length - 1 : ny);
                    nx = (nx == map[ny].length ? 0 : nx);
                    nx = (nx == -1 ? map[ny].length - 1 : nx);
                    q.add(new Job(ny, nx, head.dir, head.mem));
                }
            }
            sb.append((ans == true) ? "YES" : "NO");
            //////////////////////////////////////
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}