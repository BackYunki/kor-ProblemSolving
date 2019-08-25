import java.util.Scanner;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int tc = sc.nextInt();

        for (int t = 1; t <= tc; t++)
        {
            sb.append("#").append(t).append(" ");

            int N = sc.nextInt();
            int L = sc.nextInt();
            int[][] map = new int[N][N];

            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < N; j++)
                {
                    map[i][j] = sc.nextInt();
                }
            }
            int ans = 0;

            // 1. 가로 길 탐색
            for (int y = 0; y < N; y++)
            {
                boolean canGo = true;
                boolean builded[] = new boolean[N];
                outter:for (int x = 0; x < N-1; x++)
                {
                    int curr = map[y][x];
                    int next = map[y][x+1];
                    if(next == curr) continue;

                    // 1). 오르막길
                    else if(curr < next)
                    {
                        if(next - curr == 1)
                        {
                            // 한칸 위인 경우는 고려를 해 봐야함
                            // 왼쪽으로 L칸 가서 나랑 같은 높이인지 검증하고 안 되면 canGo = false 하고 break;
                            // 갈 수 있으면 continue;
                            for (int i = x; i > x-L; i--)
                            {
                                // 범위를 벗어나거나 이미 경사이거나 같은 높이가 아니라면 못 가는 길임.
                                if(i < 0 || builded[i] || map[y][i] != curr)
                                {
                                    canGo = false;
                                    break outter;
                                }
                                else builded[i] = true;
                            }
                        }
                        else    // 나보다 2칸이상 높으면 갈 수가 없음.
                        {
                            canGo = false;
                            break outter;
                        }
                    }
                    // 2). 내리막길
                    else // curr > next
                    {
                        if(curr - next == 1)
                        {
                            // 앞으로 L칸을 이동하면서 나랑 같은 게 아닌게 나타나면 못 감.
                            for (int i = x+1; i < x+1+L; i++)
                            {
                                // 범위를 벗어나거나 같은 높이가 아니라면 못 가는 길임.
                                if(i > N-1 || builded[i] || map[y][i] != next)
                                {
                                    canGo = false;
                                    break outter;
                                }
                                else builded[i] = true;
                            }
                        }
                        else    // 나보다 2칸이상 낮으면 갈 수가 없음.
                        {
                            canGo = false;
                            break outter;
                        }
                    }
                }

                // 3). 갈 수 있는 길의 개수 갱신
                if(canGo) ans++;
            }

            // 2. 세로 길 탐색
            for (int x = 0; x < N; x++)
            {
                boolean canGo = true;
                boolean[] builded = new boolean[N];
                outter:for (int y = 0; y < N-1; y++)
                {
                    int curr = map[y][x];
                    int next = map[y+1][x];
                    if(next == curr) continue;

                    // 1). 오르막
                    else if(next > curr)
                    {
                        if(next - curr == 1)
                        {
                            for (int i = y; i > y-L; i--)
                            {
                                if(i < 0 || builded[i] || map[i][x] != curr)
                                {
                                    canGo = false;
                                    break outter;
                                }
                                else builded[i] = true;
                            }
                        }
                        else    // 나보다 2칸이상 높으면 갈 수가 없음.
                        {
                            canGo = false;
                            break outter;
                        }
                    }
                    // 2). 내리막
                    else // curr > next
                    {
                        if(curr - next == 1)
                        {
                            // 앞으로 L칸을 이동하면서 나랑 같은 게 아닌게 나타나면 못 감.
                            for (int i = y+1; i < y+1+L; i++)
                            {
                                // 범위를 벗어나거나 같은 높이가 아니라면 못 가는 길임.
                                if(i > N-1 || builded[i] || map[i][x] != next)
                                {
                                    canGo = false;
                                    break outter;
                                }
                                else builded[i] = true;
                            }
                        }
                        else    // 나보다 2칸이상 낮으면 갈 수가 없음.
                        {
                            canGo = false;
                            break outter;
                        }
                    }
                }
                // 3). 갱신
                if(canGo) ans++;
            }
            // 3. 정답 갱신
            sb.append(ans).append("\n");
        }
        //4. 정답 출력
        System.out.println(sb);
    }
}