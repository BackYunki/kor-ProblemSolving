import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for( int t = 1; t <= tc; ++t )
        {
            sb.append("#").append(t).append(" ");
            ////////////////////////////////////////////////////////////////////

            int p = Integer.parseInt(br.readLine());
            long[] prime = new long[p];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < p; i++)
            {
                prime[i] = Long.parseLong(st.nextToken());
            }
            
            Arrays.sort(prime);

            long answer = 0l;
            // 약수의 개수가 짝수이면,
            if(p % 2 == 0)
            {
                answer = prime[0] * prime[p - 1];
            }
            else    // 약수의 개수가 홀수이면 가운데를 읽는다.
            {
                answer = prime[p/2] * prime[p/2];
            }

            ////////////////////////////////////////////////////////////////////
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}