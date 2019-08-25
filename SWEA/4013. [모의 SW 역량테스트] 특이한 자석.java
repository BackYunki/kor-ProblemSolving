import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution
{
    public static class Magnet
    {
        // 날의 자성 정보
        LinkedList<Integer> info = new LinkedList<>();
        Magnet()
        {

        }
    }
    public static void main(String[] args) throws Exception
    {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++)
        {
            sb.append("#").append(t).append(" ");
            /////////////////////////////////////
            int N = Integer.parseInt(br.readLine()); // 회전 횟수
            // 1. 자성정보를 입력한다.
            Magnet[] magnets = new Magnet[5];
            for (int i = 1; i <= 4; i++)
            {
                StringTokenizer st = new StringTokenizer(br.readLine());
                magnets[i] = new Magnet();
                for (int j = 0; j < 8; j++)
                {
                    magnets[i].info.add(Integer.parseInt(st.nextToken()));
                }
            }
            // 2. 회전 시킨다.
            for (int i = 0; i < N; i++)
            {
                String[] ND = br.readLine().split(" ");
                int num = Integer.parseInt(ND[0]);
                int dir = Integer.parseInt(ND[1]);
                // 3. 돌리려는 자석을 우선 돌린 후. 맞닿는 것도 돌려줘야한다.
                rotate(magnets, num, dir);
            }
            // 3. 꼭대기 값을 더하여 출력한다.
            int sum = 0;
            for (int i = 1; i <= 4; i++)
            {
                // 꼭대기가 S극이면
                if (magnets[i].info.get(0) == 1)
                {
                    sum += (int)Math.pow(2, i-1);
                }
            }
            /////////////////////////////////////
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }

    // 자석의 범위는 1~4까지
    public static boolean inRange(int idx) { return 1 <= idx && idx <= 4; }

    // 회전시켜보장: 돌리려는 자석의 번호, 방향을 주고 연쇄적으로 돌린다.
    public static void rotate(Magnet[] magnets, int num, int dir)
    {
        int check[] = new int[5];
        check[num] = dir;
        for (int i = num; i <= 3; i++)
        {
            if(magnets[i].info.get(2) != magnets[i+1].info.get(6))
                check[i+1] = (-1)*check[i];
            else break;
        }
        for (int i = num; i >= 2; i--)
        {
            if(magnets[i].info.get(6) != magnets[i-1].info.get(2))
                check[i-1] = (-1)*check[i];
            else break;
        }

        for (int i = 1; i <= 4; i++)
        {
            if(check[i] != 0)
            {
                rotateThis(magnets[i], check[i]);
            }
        }
    }

    // 단순 회전
    public static void rotateThis(Magnet magnet, int dir)
    {
        LinkedList info = magnet.info;
        // 시계: 1, 반 시계: -1
        switch(dir)
        {
            case 1:
                info.add(0, info.peekLast());
                info.pollLast();
                break;
            case -1:
                info.add(info.get(0));
                info.removeFirst();
                break;
        }
    }
}