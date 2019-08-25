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
            ///////////////////////////////////
            int N = sc.nextInt();
            // A~Z까지의 문자 등장 여부
            boolean cnt[] = new boolean[26];
            for (int i = 0; i < N; i++)
            {
                String str = sc.next();
                cnt[str.charAt(0)-'A'] = true;
            }
            int count = 1;
            if(!cnt[0])
                sb.append(0);
            else
            {
                for (int i = 1; i < 26; i++)
                {
                    if(!cnt[i])
                        break;
                    else count++;
                }
                sb.append(count);
            }
            ///////////////////////////////////
            sb.append("\n");
        }
        System.out.println(sb);
    }
}