import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Info implements Comparable<Info>
{
    StringBuilder trunc_name;
    String origin_name;
    int cnt;

    public int compareTo(Info o)
    {
        int answer = 1;

        if(this.cnt < o.cnt)
        {
            answer = 1;
        }
        else if ( this.cnt > o.cnt )
        {
            answer = -1;
        }
        else // this.cnt == o.cnt
        {
            // 1. 알파벳 수가 많은 것 중에서도 작은 건 사전순으로 빠른 걸 쓴다. -1
            int A = this.origin_name.length();
            int B = o.origin_name.length();

            boolean flag = (A < B) ? true : false;

            int limit = Math.min(A, B);
            for (int i = 0; i < limit; i++)
            {
                if (this.origin_name.charAt(i) < o.origin_name.charAt(i))
                {
                    answer = -1;
                    break;
                } else if (this.origin_name.charAt(i) > o.origin_name.charAt(i))
                {
                    break;
                }

                if (i == limit - 1)
                {
                    if(flag)
                    {
                        return -1;
                    }
                    else
                    {
                        return 1;
                    }
                }
            }
        }

        return answer;
    }
}

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        for(int t = 1; t <= tc; t++)
        {
            sb.append("#").append(t).append(" ");

            int N = Integer.parseInt(br.readLine());
            Info info[] = new Info[N];
            String temp = "";
            for (int i = 0; i < N; i++)
            {
                String origin_name = br.readLine();
                StringBuilder trunc_name = new StringBuilder();

                StringTokenizer st = new StringTokenizer(origin_name);
                while (st.hasMoreTokens())
                {
                    trunc_name.append(st.nextToken());
                }

                info[i] = new Info();
                info[i].trunc_name = trunc_name;
                info[i].origin_name = origin_name;

                int cnt = 0;
                int alpha[] = new int[26];
                for (int j = 0; j < trunc_name.length(); j++)
                {
                    alpha[trunc_name.charAt(j)-'A'] = 1;
                }
                for (int j = 0; j < 26; j++)
                {
                    cnt += alpha[j];
                }
                info[i].cnt = cnt;
            }

            Arrays.sort(info);
            sb.append(info[0].origin_name).append("\n");
        }
        System.out.println(sb);
    }
}