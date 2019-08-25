import java.util.*;
public class Solution
{
    public static class Country implements Comparable<Country>
    {
        LinkedList<Country> link = null;
        int color, num;
        boolean canPaint[] = new boolean[5];

        Country(int num, int color)
        {
            this.num = num;
            this.color = color;
            link = new LinkedList<>();
            for (int i = 1; i <= 4; i++)
            {
                canPaint[i] = true;
            }
        }
        @Override
        public int compareTo(Country o)
        {
            return this.link.size() - o.link.size() < 0 ? 1 : -1;
        }
    }
    
    public static int cnt = 0;
    public static void main(String[] args)
    {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int t = 1; t <= tc; t++)
        {
            sb.append("#").append(t).append(" ");
            Queue<Country> q = new LinkedList<>();
            int N = sc.nextInt();
            Country[] countries = new Country[N];
            for (int i = 0; i < N; i++)
            {
                countries[i] = new Country(i, sc.nextInt());
            }

            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < N; j++)
                {
                    int isLinked = sc.nextInt();
                    if(isLinked == 1)
                    {
                        countries[i].link.add(countries[j]);
                    }
                }
            }
            Arrays.sort(countries);
            for (int i = 0; i < N; i++)
            {
                q.add(countries[i]);
            }
            
            cnt = 0;
            while (!q.isEmpty())
            {
                Country head = q.poll();
                int hcolor = head.color;
                colorUpdate(head);
                
                outter:for (Country link : head.link)
                {
                    int lcolor = link.color;
                    if(hcolor != lcolor)
                    {
                        continue;
                    }
                    else    // 내 색이랑 자식의 색이 같으면
                    {
                        for (int i = 1; i <= 4; i++)
                        {
                            if(head.canPaint[i])
                            {
                                head.color = i;
                                cnt++;
                                break outter;
                            }
                        }
                    }
                }
            }
            sb.append(cnt);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void colorUpdate(Country country)
    {
        country.canPaint[country.color] = false;                     // 자신도 못 칠한다.
        for (Country link : country.link)
        {
            int lcolor = link.color;
            country.canPaint[lcolor] = false;
        }
    }
}