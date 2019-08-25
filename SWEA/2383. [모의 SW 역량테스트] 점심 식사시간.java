import java.io.*;
import java.util.*;
public class Solution
{
    public static int min;
    public static class Person
    {
        int num;
        int y,x;
        int height, dist1, dist2;
        boolean is1st;
        boolean isExit;

        Person(int num, int y, int x)
        {
            this.num = num;
            this.y = y;
            this.x = x;
            height = 0;
            isExit = false; is1st = false;
        }
        public String toString()
        {
            return num+"번("+height+")";
        }
    }
    public static class Stair
    {
        int y,x,height;
        ArrayList<Person> service;
        Queue<Person> waiting;

        Stair(int y, int x, int height)
        {
            this.y = y;
            this.x = x;
            this.height = height;
            service = new ArrayList<>();
            waiting = new LinkedList<>();
        }
        public boolean canService()
        {
            return service.size() < 3;
        }
    }
    public static void main(String[] args) throws Exception
    {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++)
        {
            sb.append("#").append(t).append(" ");
            //////////////////////////////////////
            min = Integer.MAX_VALUE;
            int N = Integer.parseInt(br.readLine());
            int map[][] = new int[N][N];
            ArrayList<Stair> stair = new ArrayList<>();
            ArrayList<Person> people = new ArrayList<>();
            for (int i = 0; i < N; i++)
            {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++)
                {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] == 1)
                    {
                        people.add(new Person(people.size()+1, i, j));
                    } else if(map[i][j] > 1)
                    {
                        stair.add(new Stair(i, j, map[i][j]));
                    }
                }
            }
            Stair first = stair.get(0);
            Stair second = stair.get(1);
            for (Person p : people)
            {
                p.dist1 = Math.abs(p.y - first.y) + Math.abs(p.x - first.x) + 1;
                p.dist2 = Math.abs(p.y - second.y) + Math.abs(p.x - second.x) + 1;
            }
            powerSet(0, people.size(), stair, people);
            sb.append(min);
            //////////////////////////////////////
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
    public static int go(ArrayList<Stair> stairs, ArrayList<Person> people)
    {
        int time = 0;
        Stair first = stairs.get(0);
        Stair second = stairs.get(1);
        int people_cnt = people.size();
        while(people_cnt > 0)
        {
            for(Person p : people)
            {
                if(p.isExit) continue; // 점심 먹으러 간 사람은 건너 뛴다.
                if(p.is1st)
                {
                    if(p.dist1 != time) continue; // 도착한 사람만 처리한다.
                    if(!first.canService()) // 못 들어가는 상황이면 대기시킨다.
                        first.waiting.add(p);
                    else
                        first.service.add(p);
                }
                else
                {
                    if(p.dist2 != time) continue;
                    if(!second.canService()) // 못 들어가는 상황이면 대기시킨다.
                        second.waiting.add(p);
                    else
                        second.service.add(p);
                }
            }

            for(int i = 0; i < first.service.size(); i++)
                first.service.get(i).height++;
            for(int i = 0; i < second.service.size(); i++)
                second.service.get(i).height++;

            for (int i = 0; i < first.service.size(); i++)
            {
                Person sp = first.service.get(i);
                if(sp.height == first.height)
                {
                    sp.isExit = true;
                    first.service.remove(sp);
                    people_cnt--;
                    i--;
                }
            }
            for (int i = 0; i < second.service.size(); i++)
            {
                Person sp = second.service.get(i);
                if(sp.height == second.height)
                {
                    sp.isExit = true;
                    second.service.remove(sp);
                    people_cnt--;
                    i--;
                }
            }
            while(first.canService() && first.waiting.size() > 0)
            {
                Person waitP = first.waiting.poll();
                first.service.add(waitP);
            }
            while(second.canService() && second.waiting.size() > 0)
            {
                Person waitP = second.waiting.poll();
                second.service.add(waitP);
            }
            time++;
        }
        return time;
    }
    public static void powerSet(int idx, int peopleCnt, ArrayList<Stair> stair, ArrayList<Person> people)
    {
        if(idx == peopleCnt)
        {
            min = Math.min(min, go(stair, people));
            for(Person p : people)
            {
                p.isExit = false;
                p.height = 0;
            }
            return;
        }
        people.get(idx).is1st = true;
        powerSet(idx+1, peopleCnt, stair, people);
        people.get(idx).is1st = false;
        powerSet(idx+1, peopleCnt, stair, people);
    }
}