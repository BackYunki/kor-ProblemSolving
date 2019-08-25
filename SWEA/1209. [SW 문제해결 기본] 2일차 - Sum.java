import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        for (int t = 1; t <= 10; t++)
        {
            sb.append("#").append(t).append(" ");
            //////////////////////////////////////
            int row_sum = Integer.MIN_VALUE;
            int col_sum = Integer.MIN_VALUE;
            int ld_sum = 0;
            int rd_sum = 0;

            br.readLine(); // 번호 스킵

            int row_temp = 0;
            int[][] table = new int[100][100];
            for (int i = 0; i < 100; i++)
            {
                st = new StringTokenizer(br.readLine());
                row_temp = 0;
                for (int j = 0; j < 100; j++)
                {
                    int elem = Integer.parseInt(st.nextToken());
                    row_temp += elem;

                    table[i][j] = elem;
                }
                row_sum = Math.max(row_sum, row_temp);
            }

            // 열의 최댓값과 오른쪽 대각선, 왼쪽 대각선의 최댓값을 구한다.
            int col_temp;
            for (int i = 0; i < 100; i++)
            {
                col_temp = 0;
                for (int j = 0; j < 100; j++)
                {
                    col_temp += table[j][i];

                    // 왼쪽 대각선
                    if (i == j) ld_sum += table[i][j];
                    // 오른쪽 대각선
                    if ((100 - i - 1) == j) rd_sum += table[i][j];
                }
                col_sum = Math.max(col_sum, col_temp);
            }
            //////////////////////////////////////
            sb.append(Math.max(Math.max(row_sum, col_sum), Math.max(rd_sum, ld_sum))).append("\n");
        }
        System.out.println(sb);
    }
}