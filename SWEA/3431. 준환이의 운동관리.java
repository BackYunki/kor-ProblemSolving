import java.io.*;
import java.util.StringTokenizer;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++)
        {
            sb.append("#").append(t).append(" ");
            //////////////////////////////////////
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());

            if( X < L ) sb.append(L-X);
            else if( X > R ) sb.append(-1);
            else sb.append(0);
            //////////////////////////////////////
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}