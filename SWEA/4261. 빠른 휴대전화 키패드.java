import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Solution
{
    public static HashMap<Character, Character> keyMap = new HashMap<>();
    static
    {
        char start = 'a';
        for (int i = 2; i <= 9; i++)
        {
            if(i == 7 || i == 9)
            {
                for (int j = 0; j < 4; j++)
                {
                    keyMap.put(start++, (char)('0'+i));
                }
            }
            else {
                for (int j = 0; j < 3; j++)
                {
                    keyMap.put(start++, (char)('0'+i));
                }
            }
        }
    }

    public static void main(String[] args)
    {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        for (int t = 1; t <= tc; t++)
        {
            sb.append("#").append(t).append(" ");

            String btn = sc.next();
            int n = sc.nextInt();
            String[] text = new String[n];

            int cnt = 0;
            for (int i = 0; i < n; i++)
            {
                StringBuilder test = new StringBuilder();
                text[i] = sc.next();
                for (int j = 0; j < text[i].length(); j++)
                {
                    test.append(keyMap.get(text[i].charAt(j)));
                }
                if ((test.toString()).equals(btn))
                {
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}