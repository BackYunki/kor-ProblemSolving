import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine().trim());
        for( int t = 1; t <= tc; t++ )
        {
            sb.append("#").append(t).append(" ");

            char[][] rows = new char[5][];
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < 5; i++)
            {
                rows[i] = br.readLine().toCharArray();
                max = Math.max(max, rows[i].length);
            }
            for (int i = 0; i < max; i++)
            {
                for (int j = 0; j < 5; j++)
                {
                    if(i < rows[j].length)
                        sb.append(rows[j][i]);
                }
            }

            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}