import java.io.*;
import java.util.Arrays;

public class Solution
{
    public static long N,M;
    public static long time;

    public static void main(String[] args) throws Exception
    {
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++)
        {
            sb.append("#").append(t).append(" ");
            ///////////////////////////////////////////////////
            time = 0;

            //1. 입력과 동시에 처리 구간을 구한다.
            String[] NM = br.readLine().split(" ");
            N = Long.parseLong(NM[0]);
            M = Long.parseLong(NM[1]);
            long[] officers = new long[(int)N];
            long left = Long.MAX_VALUE;
            long right = Long.MIN_VALUE;
            long mid = 0L;
            for (int n = 0; n < N; n++)
            {
                officers[n] = Long.parseLong(br.readLine());
                left = Math.min(left, officers[n]);
                right = Math.max(right, officers[n]);
            }
            right = right * M;  // 최악의 경우를 right로 설정
            time = right * M;
            while (left <= right)
            {
                mid = (left + right) / 2;   // mid 시간 동안 처리할 수 있는 사람의 수가 M과 같아질 때까지 구해본다.
                long processCnt = 0; // 처리할 수 있는 사람의 수
                for (int i = 0; i < N; i++)
                {
                    processCnt += mid/officers[i];
                }

//                if(processCnt == M)
//                {
//                    time = mid;
//                    break;
//                }
                if(processCnt < M)
                {
                    left = mid+1;
                }
                else// processCnt > M
                {
                    right = mid-1;
                }
            }
            ///////////////////////////////////////////////////
            sb.append(left).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}