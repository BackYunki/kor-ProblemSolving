import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution
{
    public static int max;
    public static void main(String[] args) throws Exception
    {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++)
        {
            sb.append("#").append(t).append(" ");
            ///////////////////////////////////////////////////////////////////////
            String str = br.readLine();
            max = countPalindrome(str);
            ///////////////////////////////////////////////////////////////////////
            sb.append(max).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    public static String toMaxString(String str)
    {
        char[] char_arr = str.toCharArray();
        Arrays.sort(char_arr);
        return new String(char_arr);
    }

    public static int countPalindrome(String str)
    {
        str = toMaxString(str);
        ArrayList<String> list = new ArrayList<>();
        int cnt = 0;
        for (int i = 1; i <= str.length(); i++)
        {
            for (int j = 0; j < str.length()-(i-1); j++)
            {
                list.add(str.substring(j, j + i));
            }
        }
        for (String text : list)
        {
            if (isPalindrome(text))
            {
                cnt++;
            }
        }
        return cnt;
    }

    public static boolean isPalindrome(String text)
    {
        for (int i = 0; i < (text.length()+1)/2; i++)
        {
            if(text.charAt(i) != text.charAt(text.length()-1-i))
                return false;
        }
        return true;
    }
}