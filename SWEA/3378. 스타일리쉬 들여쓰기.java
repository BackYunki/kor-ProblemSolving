import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++)
        {
            sb.append("#").append(t).append(" ");
            //////////////////////////////////////////////////////
            String[] pq = br.readLine().split(" ");
            int p = Integer.parseInt(pq[0]);
            int q = Integer.parseInt(pq[1]);
            String master[] = new String[p];
            String me[] = new String[q];
            for (int i = 0; i < p; i++)
                master[i] = br.readLine();
            for (int i = 0; i < q; i++)
                me[i] = br.readLine();

            // 1. 각 줄에 대한 띄어쓰기 수를 저장할 변수, 중복시 -1을 넣기 위해 임의값을 넣는다.
            int[] result = new int[q];
            Arrays.fill(result, -100);
            for (int R = 1; R <= 20; R++)
            {
                for (int C = 1; C <= 20; C++)
                {
                    for (int S = 1; S <= 20; S++)
                    {
                        // 2. 그 해를 넣어서 마스터의 문자열을 읽었을 때, 그 값으로 가능하다면
                        if (isOk(master, R, C, S))
                        {
                            // 3. 가능한 경우가 모두 나올텐데, 여러개 나오면 -1이 들어가야 한다.
                            calcIndent(me, R, C, S, result);
                        }
                    }
                }
            }
            //////////////////////////////////////////////////////
            for (int i = 0; i < q; i++)
            {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    // R,C,S를 가지고 나의 각줄에 대해서 띄어쓰기 해야하는 수를 구한다.
    static void calcIndent(String[] text, int R, int C, int S, int[] result)
    {
        // 1. 실제로 내 문장에 있는 괄호의 개수를 구한다.
        int rCnt = 0, cCnt = 0, sCnt = 0;
        for (int i = 0; i < text.length; i++)
        {
            int indent = R * rCnt + C * cCnt + S * sCnt;
            if (result[i] == -100)
            {
                result[i] = indent;
            }
            else
            {
                if (result[i] != indent)
                {
                    result[i] = -1;
                }
            }

            for (int j = 0; j < text[i].length(); j++)
            {
                switch (text[i].charAt(j))
                {
                    case '(':
                        rCnt++;
                        break;
                    case ')':
                        rCnt--;
                        break;
                    case '{':
                        cCnt++;
                        break;
                    case '}':
                        cCnt--;
                        break;
                    case '[':
                        sCnt++;
                        break;
                    case ']':
                        sCnt--;
                        break;
                }
            }
        }
    }

    static boolean isOk(String[] text, int R, int C, int S)
    {
        // 괄호의 개수들
        int rCnt = 0, cCnt = 0, sCnt = 0;

        // 첫 줄, 즉 i = 0일 때는 60~73 줄이 의미가 없다.
        for (int i = 0; i < text.length; i++)
        {
            // 실제로 띄어쓰기 해야하는 값이 indent
            int indent = R * rCnt + C * cCnt + S * sCnt;
            // 각 줄의 온점 개수
            int cnt = 0;
            for (int j = 0; j < text[i].length(); j++)
            {
                if (text[i].charAt(j) == '.')
                {
                    cnt++;
                }
                else
                    break;
            }
            if (cnt != indent) return false;
            for (int j = 0; j < text[i].length(); j++)
            {
                switch (text[i].charAt(j))
                {
                    case '(':
                        rCnt++;
                        break;
                    case ')':
                        rCnt--;
                        break;
                    case '{':
                        cCnt++;
                        break;
                    case '}':
                        cCnt--;
                        break;
                    case '[':
                        sCnt++;
                        break;
                    case ']':
                        sCnt--;
                        break;
                }
            }
        }
        return true;
    }
}