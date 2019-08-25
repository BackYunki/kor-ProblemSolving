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
            sb.append("#").append(t).append(" ");
            //////////////////////////////////////
            String[] XN = br.readLine().split(" ");
            long X = Long.parseLong(XN[0]);
            String N = XN[1];

            int sum = 0;
            long n = 0L;
            for (int i = 0; i < N.length(); i++)
            {           //(자리수          * // 승수      )%(X-1) 를 다 더한 값
                sum += (N.charAt(i)-'0');
            }

            //////////////////////////////////////
            sb.append(sum%(X-1)).append("\n"); // (a%(x-1)+b%(x-1)+ ... ) %(x-1) 이기 때문에 한 번 더 연산
        }
        System.out.println(sb);
    }
}