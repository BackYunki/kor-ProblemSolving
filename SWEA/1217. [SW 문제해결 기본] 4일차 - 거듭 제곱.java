import java.util.Scanner;

public class Solution
{
    public static void main(String[] args)
    {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        for (int t = 1; t <= 10; t++)
        {
            sb.append("#").append(t).append(" ");

            sc.nextInt();
            int x = sc.nextInt();
            int n = sc.nextInt();

            sb.append(power(x, n)).append("\n");
        }
        System.out.println(sb);
    }

    public static int power(int x, int n)
    {
        if(x == 1 || n == 0) return 1;
        if(n == 1) return x;
        return x * power(x , n-1);
    }
}