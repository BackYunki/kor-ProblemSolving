import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        for( int t = 1; t <= tc; ++t )
        {
            sb.append("#").append(t).append(" ");
            ////////////////////////////////////////////////////
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] land = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++)
            {
                land[i] = Integer.parseInt(st.nextToken());
            }

            int cnt = 0; 
            for (int i = 0; i < n; i++)
            {
                int sum = 0;
                for (int j = i; j < n; j++)
                {
                    sum += land[j];
                    if(sum > m) break;
                    else if(sum == m)
                    {
                        cnt++;
                        break;
                    }
                }
            }

            ////////////////////////////////////////////////////
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}