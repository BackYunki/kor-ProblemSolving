import java.io.*;

public class Solution
{
    public static int max;
    public static void main(String[] args) throws Exception
    {
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        for( int t = 1; t <= tc; t++ )
        {
            sb.append("#").append(t).append(" ");
            max = 0;
            ////////////////////////인풋 받기/////////////////////////
            String str = br.readLine();
            for (int i = 0; i < str.length(); i++)
            {
                String s1 = str.substring(i);
                for (int j = s1.length(); j > 0; j--)
                {
                    String s2 = s1.substring(0, j);
                    if (isPalindrome(s2.toCharArray()))
                    {
                        max = Math.max(max, s2.length());
                    }
                }
            }
            /////////////////////////////////////////////////////////
            sb.append(max).append("\n");
        }
        ////////////////////////////출력 하기//////////////////////////
        bw.write(sb.toString());
        bw.flush();
    }
    public static boolean isPalindrome(char[] str)
    {
        for (int i = 0; i < str.length/2; i++)
        {
            if(str[i] != str[str.length-1-i]) return false;
        }
        return true;
    }
}