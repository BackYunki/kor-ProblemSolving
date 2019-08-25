import java.util.Scanner;

public class Solution
{
    public static long[] getTable()
    {
        long[] p = new long[101];
        p[1] = p[2] = p[3] = 1;
        for (int n = 4; n <= 100; n++)
        {
            p[n] = p[n-2] + p[n-3];
        }
        return p;
    }


    public static void main(String[] args)
    {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        long[] p = getTable();

        int tc = sc.nextInt();
        for (int t = 1; t <= tc; t++)
        {
            sb.append("#").append(t).append(" ");
            int n = sc.nextInt();
            sb.append(p[n]).append("\n");
        }
        System.out.println(sb);
    }
}