import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= tc; t++)
        {
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine().trim(), " ");

            char[] min = st.nextToken().toCharArray();
            char[] max = st.nextToken().toCharArray();

            for (int i = 0; i < min.length; i++)
            {
                if (min[i] == '-') continue;
                if (min[i] - '0' >= 4) min[i]--;
            }
            for (int i = 0; i < max.length; i++)
            {
                if (max[i] == '-') continue;
                if (max[i] - '0' >= 4) max[i]--;
            }

            long a = Long.parseLong(String.valueOf(min), 9);
            long b = Long.parseLong(String.valueOf(max), 9);

            if (a < 0 && b < 0)
            {
                sb.append(b-a);
            } else if (a < 0 && b > 0)
            {
                sb.append( b-a-1);
            } else if (a > 0 && b > 0)
            {
                sb.append(b - a);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}