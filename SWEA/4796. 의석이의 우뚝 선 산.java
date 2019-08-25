import java.util.Scanner;

public class Solution
{
    public static void main(String[] args)
    {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        for (int t = 1; t <= tc; t++)
        {
            sb.append("#").append(t).append(" ");

            int N = sc.nextInt();
            int h[] = new int[N];
            for (int i = 0; i < N; i++)
            {
                h[i] = sc.nextInt();
            }

            // 1. 앞에서 부터 읽어나간다.
            int cnt = 0;
            int up = 0, down = 0;
            int dir = 1;
            // 다운을 하다가 업이 됐다. 그러면 다운 * 업 으로 추가하고 다시 시작.
            for (int i = 0; i < N - 1; i++)
            {
                if (h[i] < h[i + 1])
                {
                    // 감소했다가 증가한거였다면.
                    if(dir == -1)
                    {
                        cnt += up * down;
                        up = 0; down = 0;
                        dir = 1;
                    }
                    up++;
                }
                else if (h[i] >= h[i + 1])
                {
                    down++;
                    dir = -1;
                }
            }
            if(dir == -1)
            {
                cnt += up * down;
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}