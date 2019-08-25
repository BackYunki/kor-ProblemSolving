import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= 10; t++)
        {
            sb.append("#").append(t).append(" ");
            br.readLine();//한줄 버림
            char[][] map = new char[100][100];
            for (int i = 0; i < 100; i++)
                map[i] = br.readLine().toCharArray();
            int max = 0;
            /////////////////////////////////////////////////

            //1.가로로 했을 때 개수 세기
            for (int N = 100; N > 0; N--)
            {
                outter1:for (int i = 0; i < 100; i++)
                {
                    for (int j = 0; j <= 100 - N; j++)
                    {
                        char[] str = new char[N];
                        for (int k = 0; k < N; k++)
                            str[k] = map[i][j + k];
                        if(isPalindrome(str))
                        {
                            max = Math.max(max, str.length);
                            break outter1;
                        }
                    }
                }
                //2.세로로 했을 때 개수 세기
                outter2:for (int i = 0; i <= 100 - N; i++)
                {
                    for (int j = 0; j < 100; j++)
                    {
                        char[] str = new char[N];
                        for (int k = 0; k < N; k++)
                            str[k] = map[i + k][j];
                        if(isPalindrome(str))
                        {
                            max = Math.max(max, str.length);
                            break outter2;
                        }
                    }
                }
            }
            /////////////////////////////////////////////////
            sb.append(max).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
    public static boolean isPalindrome(char[] str)
    {
        int len = str.length;
        for (int i = 0; i < len / 2; i++){
            if (str[i] != str[len - 1 - i]) return false;
        }
        return true;
    }
}