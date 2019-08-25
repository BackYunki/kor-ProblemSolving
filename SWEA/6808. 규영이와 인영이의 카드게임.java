import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution
{
    public static void swap(ArrayList<Integer> cards, int x, int y)
    {
        int temp = cards.get(x);
        cards.set(x, cards.get(y));
        cards.set(y, temp);
    }

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++)
        {
            sb.append("#").append(t).append(" ");
            //////////////////////////////////////
            boolean[] sel = new boolean[19]; // 1~18번까지 카드 선택 여부, true면 규영이꺼
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 9; i++)
                sel[Integer.parseInt(st.nextToken())] = true;

            // 규영이가 내는 카드는 고정
            ArrayList<Integer> g_card = new ArrayList<>();
            ArrayList<Integer> i_card = new ArrayList<>();
            for (int i = 1; i <= 18; i++)
            {
                if(sel[i]) g_card.add(i);
                else i_card.add(i);
            }

            // 인영이 카드의 순열을 구해서 규영이와 대조하자.
            wincnt = 0;
            perm(g_card, i_card, 0);
            //////////////////////////////////////
            sb.append(wincnt).append(" ").append(fact9-wincnt).append("\n");
        }
        System.out.println(sb);
        
    }
    public static final int fact9 = 9*8*7*6*5*4*3*2;
    public static int wincnt = 0;
    public static void perm(ArrayList<Integer> g_card, ArrayList<Integer> i_card, int idx)
    {
        // 순열을 구한 상태
        if(idx == 9)
        {
            // 대소 비교를 통해서 규영이와 인영이의 합을 구한다.
            int g_sum = 0;
            int i_sum = 0;
            for (int i = 0; i < 9; i++)
            {
                int point = g_card.get(i) + i_card.get(i);
                if(g_card.get(i) > i_card.get(i))
                    g_sum += point;
                else
                    i_sum += point;
            }
            if(g_sum > i_sum)
                wincnt++;
            return;
        }

        // 인영이의 카드 순서를 바꿔보자
        for (int i = idx; i < 9; i++)
        {
            if(i != idx)
                swap(i_card, idx, i);
            perm(g_card, i_card, idx+1);
            swap(i_card, idx, i);
        }
    }
}