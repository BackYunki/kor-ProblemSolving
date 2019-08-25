import java.util.Scanner;
import java.io.*;
public class Solution
{

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++)
		{
			sb.append("#").append(t).append(" ");
			//////////////////////////////////////////////
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = a ^ b ^ c;
			sb.append(d).append("\n");
			//////////////////////////////////////////////
		}
		bw.write(sb.toString());
		bw.flush();
	}
}