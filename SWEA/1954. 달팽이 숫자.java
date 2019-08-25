import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++)
        {
            int n = Integer.parseInt(br.readLine());
            int arr[][] = new int[n][n];

            int dir = 1;
            int len = n;
            int num = 1;
            int i = 0;
            int j = -1;

            while(true)
            {
                // 1. 가로로 len만큼 이동
                for (int p = 0; p < len; p++) // p는 len만큼 나아간다.
                {
                    j += dir;
                    arr[i][j] = num++;
                }
                // 횟수 줄이고 더이상 진행할 수 없으면 탈출
                if(--len == 0) break;
                // 2. 세로로 이동
                for (int p = 0; p < len; p++)
                {
                    i += dir;
                    arr[i][j] = num++;
                }
                // dir 부호 바꾸기
                dir *= -1;
            }
            sb.append("#").append(t).append("\n");
            for (int k = 0; k < n; k++)
            {
                for (int l = 0; l < n; l++)
                {
                    sb.append(arr[k][l]).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}