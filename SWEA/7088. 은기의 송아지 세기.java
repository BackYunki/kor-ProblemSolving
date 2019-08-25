import java.util.Arrays;
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
            sb.append("#").append(t).append("\n");
            // test
            int N = sc.nextInt();
            int Q = sc.nextInt();

            int[][] cows = new int[N+1][3];
            for (int i = 1; i <= N; i++)
            {
                int temp = sc.nextInt();
                for (int j = 0; j < 3; j++)
                {
                    cows[i][j] = cows[i-1][j];
                }
                cows[i][temp-1]++;
            }
            //for (int i = 1; i <= N; i++) System.out.println(Arrays.toString(cows[i]));

            for (int i = 0; i < Q; i++)
            {
                int l = sc.nextInt();
                int r = sc.nextInt();

                int ans[] = new int[3];

                for (int j = 0; j < 3; j++)
                {
                    ans[j] = cows[r][j] - cows[l-1][j];
                }
                sb.append(new String(String.format("%d %d %d", ans[0], ans[1], ans[2]))).append("\n");
            }
        }
        System.out.println(sb);
    }
}