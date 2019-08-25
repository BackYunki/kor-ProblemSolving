import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= tc; t++)
        {
            sb.append("#").append(t).append(" ");
            /////////////////////////////////////
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 각 점을 좌표로
            int[] coordA = getCoord(a);
            int[] coordB = getCoord(b);
            // 두 좌표의 합
            int[] coordC = {coordA[0] + coordB[0], coordA[1] + coordB[1]};
            int result = getValue(coordC);
            sb.append(result);
            /////////////////////////////////////
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static int[] getCoord(int target)
    {
        int value = 1;
        int row = 1;
        while (true)
        {
            for (int i = row; i > 0; i--)
            {
                int y = i;
                int x = (row - y) + 1;
                if (value == target)
                {
                    return new int[]{y, x};
                }
                value++;
            }
            row++;
        }
    }

    // 좌표가 주어졌을 때 값 리턴
    public static int getValue(int[] coord)
    {
        int value = 1;
        int row = 1;
        while (true)
        {
            for (int i = row; i > 0; i--)
            {
                int y = i;
                int x = (row - y) + 1;
                if (y == coord[0] && x == coord[1])
                {
                    return value;
                }
                value++;
            }
            row++;
        }
    }
}