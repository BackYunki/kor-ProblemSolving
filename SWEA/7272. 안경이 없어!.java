import java.util.HashMap;
import java.util.Scanner;

public class Solution
{
    public static HashMap<Character, Integer> map = new HashMap<>();
    static
    {
        char start = 'A';
        int hole = 0;
        for (int i = 0; i < 26; i++)
        {
            char temp = (char) (start + i);
            if (temp == 'B') hole = 2;
            else if (temp == 'A' || temp == 'D' || temp == 'O' || temp == 'P' || temp == 'Q' || temp == 'R')
            {
                hole = '1';
            }
            else hole = 0;
            map.put(temp, hole);
        }
    }

    public static void main(String[] args)
    {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // testCase 수
        for (int t = 1; t <= N; t++)
        {
            sb.append("#").append(t).append(" ");
            String L = sc.next();
            String R = sc.next();
            // 1.
            if(L.length() != R.length())
                sb.append("DIFF");
            else
            {
                boolean isSame = true;
                for (int j = 0; j < L.length(); j++)
                {
                    int L_Hole = map.get(L.charAt(j));
                    int R_Hole = map.get(R.charAt(j));
                    if(L_Hole != R_Hole)
                    {
                        isSame = false;
                        break;
                    }
                }
                sb.append(isSame == true ? "SAME" : "DIFF");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}