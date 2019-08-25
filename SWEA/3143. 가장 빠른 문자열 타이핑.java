import java.io.*;
import java.util.StringTokenizer;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++)
        {
            sb.append("#").append(t).append(" ");
            /////////////////////////////////////////
            StringTokenizer st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            String B = st.nextToken();
            int i = 0;
            int cnt = 0;
            for (i = 0;  i < A.length()-B.length()+1; i++)
            {
                int idx = 0;
                boolean canGo = true;
                for (int j = i; j < i + B.length(); j++)
                {
                    if(A.charAt(j) != B.charAt(idx++))
                    {
                        canGo = false;
                        break;
                    }
                }
                if(canGo) i += B.length()-1;
                cnt++;
            }
            cnt += A.length() - i;
            sb.append(cnt);
            /////////////////////////////////////////
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}