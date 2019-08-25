import java.io.*;

public class Solution
{
    public static class Lottery
    {
        String pattern;
        int price;

        public Lottery(String pattern, int price)
        {
            this.pattern = pattern;
            this.price = price;
        }
    }

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++)
        {
            sb.append("#").append(t).append(" ");
            //////////////////////////////////////
            String[] NM = br.readLine().split(" ");
            int N = Integer.parseInt(NM[0]);
            int M = Integer.parseInt(NM[1]);
            Lottery[] lotteries = new Lottery[N];
            for (int i = 0; i < N; i++)
            {
                String[] NP = br.readLine().split(" ");
                lotteries[i] = new Lottery(NP[0], Integer.parseInt(NP[1]));
            }

            // 당첨금 구하기
            int total = 0;
            for (int i = 0; i < M; i++)
            {
                String myNumber = br.readLine();
                for( Lottery lottery : lotteries)
                {
                    String pattern = lottery.pattern;
                    boolean isMatch = true;
                    for (int j = 0; j < 8; j++)
                    {
                        if(pattern.charAt(j) == '*') continue;
                        else
                        {
                            if(pattern.charAt(j) != myNumber.charAt(j))
                            {
                                isMatch = false;
                                break;
                            }
                        }
                    }
                    if(isMatch) total += lottery.price;
                }
            }
            //////////////////////////////////////
            sb.append(total).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}