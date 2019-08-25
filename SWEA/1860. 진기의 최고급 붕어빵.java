import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        String[] state = {"Possible", "Impossible"};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] times = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++)
            {
                times[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(times);

            int endTime = times[times.length - 1];
            int[] breads = new int[endTime+1];

            for (int i = 1; i <= endTime; i++)
            {
                breads[i] = breads[i - 1];
                if(i % m == 0)
                    breads[i] += k;
            }

            boolean canEat = true;
            for (int time : times)
            {
                for (int i = time; i <= endTime; i++)
                {
                    breads[i]--;
                }
                if(breads[time] < 0)
                {
                    canEat = false;
                    break;
                }
            }

            sb.append("#").append(t).append(" ").append((canEat ? state[0] : state[1])).append("\n");
        }
        System.out.println(sb);
    }
}