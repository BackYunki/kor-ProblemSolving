import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution
{
    public static int cache[];
    public static int answer = 0;
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int tc = Integer.parseInt(br.readLine().trim());
        for( int t = 1; t <= tc; t++ )
        {
            sb.append("#").append(t).append(" ");
            //testCase Start
            st = new StringTokenizer(br.readLine());
            char[] cards = st.nextToken().toCharArray();
            int limit = Integer.parseInt(st.nextToken());
            answer = 0;
            cache = new int[limit+1];

            go(0, cards, cards.length, limit);

            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
    public static void swap(char[] cards, int a, int b)
    {
        char temp = cards[a];
        cards[a] = cards[b];
        cards[b] = temp;
    }
    public static void go(int cnt, char[] cards, int len, int limit)
    {
        int curr = Integer.parseInt(new String(cards));
        if(cache[cnt] > curr) return;
        if(cnt == limit)
        {
            answer = Math.max(answer, Integer.parseInt(new String(cards)));
            return;
        }

        cache[cnt] = curr;

        for (int i = 0; i < len; i++)
        {
            for (int j = i+1; j < len; j++)
            {
                swap(cards, i, j);
                go(cnt+1, cards, len, limit);
                swap(cards, i, j);
            }
        }
    }
}