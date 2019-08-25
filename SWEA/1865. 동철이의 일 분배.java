import java.io.*;
import java.util.StringTokenizer;

public class Solution
{
    public static int N;
    public static double ans = 0.0;

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++)
        {
            N = Integer.parseInt(br.readLine());
            double [][] table = new double[N][N];
            for (int i = 0; i < N; i++)
            {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++)
                    table[i][j] = Integer.parseInt(st.nextToken()) / 100.0;
            }
            ans = 0.0;
            powerSet(table, new boolean[N], 100, 0, 0);
            System.out.printf("#%d %.6f\n", t, ans);
        }
    }

    public static void powerSet(double[][] table, boolean chk[], double sum, int i, int cnt)
    {
        if (cnt == N)   // 모두 선택한 경우
        {
            ans = Math.max(ans, sum);
            return;
        }

        for (int j = 0; j < N; j++)
        {
            if (chk[j] || table[i][j] == 0) continue;
            if (sum * table[i][j] < ans) continue;

            chk[j] = true;
            powerSet(table, chk, (sum * table[i][j]), i + 1, cnt + 1);
            chk[j] = false; // 다음 사원이 이걸 선택할 수 있게 false로 바꿔줘야 함.
        }
    }
}