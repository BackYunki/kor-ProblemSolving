import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution
{
    static class Charger implements Comparable<Charger>
    {
        int r, c, coverage, power;

        public Charger(int x, int y, int coverage, int power)
        {
            r = y;
            c = x;
            this.coverage = coverage;
            this.power = power;
        }

        @Override
        public int compareTo(Charger o)
        {
            return o.power - this.power;
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++)
        {
            int M = sc.nextInt(); //(20 ≤ M ≤ 100) 시간
            int A = sc.nextInt(); // (1 ≤ A ≤ 8) 충전기의 개수.
            int[][] move = new int[2][M];
            for (int i = 0; i < 2; i++)
            {
                for (int j = 0; j < M; j++)
                    move[i][j] = sc.nextInt();
            }
            Charger[] charger = new Charger[A];
            for (int i = 0; i < A; i++)
                charger[i] = new Charger(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());

            //한번 충전값 더하고
            //이동시나리오대로 이동하고
            int h1r = 1;
            int h1c = 1;
            int h2r = 10;
            int h2c = 10;

            int sum = 0;
            for (int i = 0; i <= M; i++)
            {
                //충전
                //각 사람별로 현재 내 위치에서 닿는 충전기를 모두 가져오자.
                List<Charger> person1 = getCharger(h1r, h1c, charger);
                List<Charger> person2 = getCharger(h2r, h2c, charger);
                if (person1.size() != 0 && person2.size() == 0)
                    sum += person1.get(0).power;
                if (person1.size() == 0 && person2.size() != 0)
                    sum += person2.get(0).power;
                if (person1.size() != 0 && person2.size() != 0)
                {
                    int max = 0;
                    for (int a = 0; a < person1.size(); a++)
                    {
                        for (int b = 0; b < person2.size(); b++)
                        {
                            int tmp = person1.get(a).power + person2.get(b).power;
                            if (person1.get(a) == person2.get(b))
                                tmp /= 2;
                            max = Math.max(max, tmp);
                        }
                    }
                    sum += max;
                }
                if (i == M)
                    break;
                //이동
                h1r += dr[move[0][i]];
                h1c += dc[move[0][i]];
                h2r += dr[move[1][i]];
                h2c += dc[move[1][i]];
            }
            System.out.println("#" + tc + " " + sum);
        }
    }

    static List<Charger> getCharger(int r, int c, Charger[] charger)
    {
        List<Charger> list = new ArrayList<>();
        for (int i = 0; i < charger.length; i++)
        {
            if (Math.abs(r - charger[i].r) + Math.abs(c - charger[i].c) <= charger[i].coverage)
                list.add(charger[i]);
        }
        Collections.sort(list);
        return list;
    }

    static int[] dr = {0, -1, 0, 1, 0};
    static int[] dc = {0, 0, 1, 0, -1};
}