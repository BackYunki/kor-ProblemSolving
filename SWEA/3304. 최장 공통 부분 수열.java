import java.util.Scanner;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int tc = Integer.parseInt(sc.nextLine());

        for (int t = 1; t <= tc; t++)
        {
            String[] AB = sc.nextLine().split(" ");
            String a = AB[0];
            String b = AB[1];

            int[][] dp = new int[a.length() + 1][b.length() + 1];
            for (int i = 1; i <= a.length(); i++)
            {
                for (int j = 1; j <= b.length(); j++)
                {
                    //현재 서로 문자가 같다면, 해당 문자들을 양쪽 다 뺏을때의 LCS + 1
                    if (a.charAt(i - 1) == b.charAt(j - 1))
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                        //다를 때는 a쪽 현재글자를 뺏을때와 b쪽 현재글자를 뺏을때 중 LCS의 최대값
                    else
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
            System.out.println("#"+t+" "+dp[a.length()][b.length()]);
        }
    }
}