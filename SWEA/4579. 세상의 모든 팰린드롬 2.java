import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++)
        {
            sb.append("#").append(t).append(" ");
            ////////////////////////인풋 받기/////////////////////////
            String str = br.readLine();
            char[] s2a = str.toCharArray();
            sb.append(isPalindrome(s2a) == true ? "Exist" : "Not exist");
            /////////////////////////////////////////////////////////
            sb.append("\n");
        }
        ////////////////////////////출력 하기//////////////////////////
        bw.write(sb.toString());
        bw.flush();
    }
    public static boolean isPalindrome(char[] str)
    {
        for (int i = 0; i < str.length/2; i++)
        {
            if (str[i] != str[str.length - 1 - i])
            {
                if(str[i] == '*' || str[str.length -1 -i] == '*') return true;
                else return false;
            }
        }
        return true;
    }
}