import java.io.*;

/*
1. hi처럼 ?가 들어있지 않다면 이 친구가 펠린드롬인지 검사한다.
2.  ?가 들어왔다는 것은 패턴을 의미한다.
3. ?는 와일드 카드라는 것은 크나큰 이득이다. 검사하는데 둘 중에 하나라도 ?면 그건 같은 문자로 바꿔버릴 수 있으니까!
*/
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
                if(str[i] == '?' || str[str.length -1 -i] == '?') continue;
                else return false;
            }
        }
        return true;
    }
}