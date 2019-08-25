import java.util.Arrays;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int t = 1; t <= tc ; t++)
        {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++)
            {
                arr[i] = sc.nextInt();
            }
            int[] c = new int[N];

            // 첫 한 칸은 그냥 들어감
            int len = 1;
            c[0] = arr[0];

            for (int i = 1; i < N; i++)
            {
                int idx = Arrays.binarySearch(c, 0, len, arr[i]);
                // 없으면 절댓값이 하나 큰 음수가 나옴
                idx = idx < 0 ? -idx-1 : idx;
                c[idx] = arr[i];
                if (len <= idx)
                {
                    len++;
                }
            }
            System.out.println("#"+t+" "+len);
        }
    }
}