import java.math.BigDecimal;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args)
    {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int t = 1; t <= tc; t++)
        {
            sb.append("#").append(t).append(" ");
            BigDecimal a = new BigDecimal(sc.next());
            BigDecimal b = new BigDecimal(sc.next());

            sb.append(a.add(b)).append("\n");
        }
        System.out.println(sb);
    }
}