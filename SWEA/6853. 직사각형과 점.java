import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution
{
//    public static String src = "1\n0 0 2 2\n4\n-1 -1\n0 0\n1 1\n2 2";

    static class Point
    {
        int x,y;
        Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
        public void setPoint(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString()
        {
            return "("+ this.x + "," + this.y+")";
        }
    }

    static int answer[] = new int[3];
    static Point top = new Point(0, 0);
    static Point bottom = new Point(0, 0);

    public static void main(String[] args) throws Exception
    {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new StringReader(src));

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++)
        {
            sb.append("#").append(t).append(" ");
            for (int i = 0; i < 3; i++)
                answer[i] = 0;
            ///////////////////////////////////////////
            StringTokenizer st = new StringTokenizer(br.readLine());
            bottom.setPoint(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            top.setPoint(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            int N = Integer.parseInt(br.readLine());
            Point p = new Point(0, 0);
            for (int i = 0; i < N; i++)
            {
                st = new StringTokenizer(br.readLine());
                p.setPoint(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
//                System.out.println("top:"+top+", bottom:"+bottom+","+"p:"+p+"\n");
                // 테두리 위에 있을 경우
                if(     (p.x == bottom.x && (bottom.y <= p.y && p.y <= top.y)) ||
                        (p.x == top.x    && (bottom.y <= p.y && p.y <= top.y)) ||
                        (p.y == top.y    && (bottom.x <= p.x && p.x <= top.x)) ||
                        (p.y == bottom.y && (bottom.x <= p.x && p.x <= top.x)))
                {
                    answer[1]++;
                }
                // 사각형 안
                else if((bottom.x < p.x && p.x < top.x )&&(bottom.y < p.y && p.y < top.y))
                {
                    answer[0]++;
                }
                // 사각형 바깥
                else
                {
                    answer[2]++;
                }
            }
            ///////////////////////////////////////////
            for (int i = 0; i < 3; i++)
            {
                sb.append(answer[i]).append(" ");
            } sb.append("\n");
        }
        System.out.println(sb);
    }
}