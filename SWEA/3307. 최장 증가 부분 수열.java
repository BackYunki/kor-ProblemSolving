import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++)
        {
            sb.append("#").append(t).append(" ");

            int N = Integer.parseInt(sc.nextLine());
            int a[] = new int[N+1];
            int LIS[] = new int[N + 1];
            String row = sc.nextLine();
            StringTokenizer st = new StringTokenizer(row, " ");
            for (int i = 1; i <= N; i++)
            {
                a[i] = Integer.parseInt(st.nextToken());
            }
            //System.out.println(Arrays.toString(a));

            for (int i = 1; i <= N; i++)
            {
                LIS[i] = 1;
                for (int j = 1; j <= i - 1; j++)
                {
                    // 내 앞의 숫자들을 보면서 나보다 작은 경우
                    if (a[j] < a[i] && 1 + LIS[j] > LIS[i])
                    {               // 나만 넣는 경우의 길이보다 그전꺼에 나를 추가했을 때의 길이가 더 길면
                        LIS[i] = 1 + LIS[j];    // 나를 넣은 길이를 내꺼에 넣어준다.
                    }
                }
            }
            Arrays.sort(LIS);
            sb.append(LIS[N]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}