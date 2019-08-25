import java.io.*;

public class Solution
{
    public static int N;

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= 10; t++)
        {
            sb.append("#").append(t).append(" ");
            N = Integer.parseInt(br.readLine());
            char[][] map = new char[8][8];
            for (int i = 0; i < 8; i++)
                map[i] = br.readLine().toCharArray();
            cnt = 0;
            /////////////////////////////////////////////////
            //1.가로로 했을 때 개수 세기
            for (int i = 0; i < 8; i++)
            {
                for (int j = 0; j <= 8-N; j++)
                {
                    char[] str = new char[N];
                    for (int k = 0; k < N; k++)
                        str[k] = map[i][j+k];
                    checkPalindrom(str);
                }
            }
            //2.세로로 했을 때 개수 세기
            for (int i = 0; i <= 8-N; i++)
            {
                for (int j = 0; j < 8; j++)
                {
                    char[] str = new char[N];
                    for (int k = 0; k < N; k++)
                        str[k] = map[i+k][j];
                    checkPalindrom(str);
                }
            }
            /////////////////////////////////////////////////
            sb.append(cnt).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
    public static int cnt;
    public static void checkPalindrom(char[] str)
    {
        for (int i = 0; i < N / 2; i++){
            if (str[i] != str[N - 1 - i]) return;
        }
        cnt++;
    }
}