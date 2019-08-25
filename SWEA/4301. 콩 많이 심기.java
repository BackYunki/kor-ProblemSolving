import java.util.Scanner;

public class Solution
{
    public static int Y,X;
    public static int[][] map;
    public static void main(String[] args)
    {
        // N : 가로길이 M: 세로길이 ( 1~1000사이 )
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int tc = sc.nextInt();
        for (int t = 1; t <= tc; t++)
        {
            sb.append("#").append(t).append(" ");
            X = sc.nextInt(); // 가로
            Y = sc.nextInt(); // 세로
            map = new int[Y][X];
            for (int y = 0; y < Y; y++)
            {
                for (int x = 0; x < X; x++)
                {
                    if(map[y][x] != -1)
                    {
                        if (inRange(y - 2, x))
                        {
                            map[y - 2][x] = -1;
                        }
                        if (inRange(y, x + 2))
                        {
                            map[y][x + 2] = -1;
                        }
                        if (inRange(y + 2, x))
                        {
                            map[y+2][x] = -1;
                        }
                        if (inRange(y, x - 2))
                        {
                            map[y][x - 2] = -1;
                        }
                        map[y][x] = 1;
                    }
                }
            }
            int cnt = 0;
            for (int y = 0; y < Y; y++)
            {
                for (int x = 0; x < X; x++)
                {
                    if (map[y][x] != -1)
                    {
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
    public static boolean inRange(int y, int x) { return (0 <= y && y < Y) && (0 <= x && x < X); }
}