import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution
{
    public static ArrayList<Integer> difference; // 차이가 들어가는데, 우선순위큐여서 가장 큰게 앞에 오니 마지막 원소를 읽자.
    public static void go(int[] height, boolean[] selected, int idx, int n, int b)
    {
        if( idx == n )
        {
            int sum = 0;
            for (int i = 0; i < n; i++)
            {
                if(selected[i])
                    sum += height[i];
            }

            if(sum < b) return;
            else difference.add(sum-b);

            return;
        }

        selected[idx] = true;
        go(height, selected, idx + 1, n, b);
        selected[idx] = false;
        go(height, selected, idx + 1, n, b);
    }

    public static void main(String[] args) throws Exception
    {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; ++t) {
            sb.append("#").append(t).append(" ");
            /////////////////////////////////////////////////////////////////////

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 점원 수
            int b = Integer.parseInt(st.nextToken()); // 선반 높이
            int[] w_height = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++)
            {
                w_height[i] = Integer.parseInt(st.nextToken());
            }

            difference = new ArrayList<>();
            go(w_height, new boolean[n], 0, n, b);
            Collections.sort(difference);

            /////////////////////////////////////////////////////////////////////
            sb.append(difference.get(0)).append("\n");
        }
        System.out.println(sb);
    }
}