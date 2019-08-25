import java.util.Scanner;

public class Solution
{
    public static int square[] = { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024 };
    public static int fact[] = { 1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800 };

    public static int mass[];
    public static int N, result, sum;
    public static void main(String[] args)
    {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        for (int t = 1; t <= tc; t++)
        {
            sb.append("#").append(t).append(" ");
            N = sc.nextInt();
            mass = new int[N];
            sum = 0;
            result = 0;
            for (int i = 0; i < N; i++)
            {
                mass[i] = sc.nextInt();
                sum += mass[i];
            }
            //easysolution(0, new boolean[N], 0, 0);
            combi(new boolean[N], 0, 0, 0);
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    public static void easysolution(int idx, boolean[] visited, int left, int right)
    {
        if (idx == N)
        {
            result++;
            return;
        }
        for (int i = 0; i < visited.length; i++)
        {
            if (!visited[i])
            {
                visited[i] = true;
                if (left >= right + mass[i])
                {
                    easysolution(idx + 1, visited, left, right + mass[i]);
                }
                easysolution(idx + 1, visited, left + mass[i], right);
                visited[i] = false;
            }
        }
    }

    public static void combi(boolean[] visited, int idx, int left, int right)
    {
        // 모두 선택한 경우
        if (idx == N)
        {
            result++;
            return;
        }
        // 이미 충분히 커져버린 경우는 수학적으로 계산한다.
        if (left >= sum - left)
        {
            int remainCnt = N-idx;
            result += fact[remainCnt] * square[remainCnt];
            return;
        }

        for (int i = 0; i < N; i++)
        {
            if (!visited[i])
            {
                // 왼쪽에 추를 올린다.
                visited[i] = true;
                combi(visited, idx + 1, left + mass[i], right);
                // 오른쪽에 추를 올리는데. 이미 left보다 커져버리면 갈 필요가 없다.
                if (left >= right + mass[i])
                {
                    combi(visited, idx + 1, left, right + mass[i]);
                }
                visited[i] = false;
            }
        }
    }
}