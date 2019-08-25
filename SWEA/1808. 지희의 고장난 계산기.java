import java.util.Arrays;
import java.util.Scanner;

public class Solution
{
    public static int [] btn;
    public static int IMPOSSIBLE = Integer.MAX_VALUE;
    public static int dp[];
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int tc = sc.nextInt();
        for (int t = 1; t <= tc; t++)
        {
            sb.append("#").append(t).append(" ");

            // 사용가능한 숫자판
            btn = new int[10];
            for (int i = 0; i < 10; i++)
                btn[i] = sc.nextInt();

            int N = sc.nextInt();
            // N값이 1~9까지인 경우가 있어서 0도 포함해서 그냥 10개 더 만들어 줬음. 얘들은 그냥 모두 1번만 계산하면 됨.
            dp = new int[N + 10];
            for (int i = 0; i < 10; i++)
            {
                if(btn[i] == 1) dp[i] = 1;
            }

            // 여기서부터 계산 시작
            solve(N);
            sb.append(dp[N] == IMPOSSIBLE ? -1 : dp[N] + 1);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static int solve(int N)
    {
        if(dp[N] != 0) return dp[N];// 이미 계산 된 값은 리턴
        // 사용가능한 버튼만 우선 다 눌러보게 계산시킨다. 그게 최적해기 때문이다.
        dp[N] = count(N); // 안 되면 임포시블을 반환한다. 엄청 큰 값이기 때문에 아래에서 갱신 될 거고 안 되면 계속 임포시블이지!

        // 인수분해를 해보고 분해 된 왼쪽 약수, 오른쪽 약수에 대해서 또 solve를 호출해본다. sqrt(N)번만 호출하면 된다는 사실!
        for (int i = 1; i <= (int)Math.sqrt(N); i++)
        {
            if(N % i == 0)
            {
                int left = solve(i);        //왼쪽 약수 ex 60의 경우 왼쪽은1      , 2 ...
                int right = solve(N / i);//오른쪽 약수           오른쪽은60   , 30 ...
                // 위에서 맨처음 구해본것부터 해서 뭐가 더 빠른지 계산해보자.
                dp[N] = Math.min(dp[N], left == IMPOSSIBLE || right == IMPOSSIBLE ? IMPOSSIBLE : left + right + 1);
            }
        }
        return dp[N];
    }

    public static int count(int N)
    {
        int cnt = 0;
        while (N > 0)
        {
            // 뒷자리부터 읽고
            int digit = N % 10;
            if(btn[digit] == 0) return IMPOSSIBLE; // 버튼이 없으면 불가능 리턴

            N /= 10;
            cnt++; // 가능하다면 계속 버튼 수를 늘려가면 최적해는 버튼 수만큼에 마지막 계싼 = 을 누른것임.
        }
        return cnt;
    }
}