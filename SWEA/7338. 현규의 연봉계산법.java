import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");
			String[] YM = br.readLine().split(" ");
			long Y = Long.parseLong(YM[0]);
			long M = Long.parseLong(YM[1]);
			// 실제로 몇 달이 지난 걸까?
			long tmp = (Y-2016) * 12 + M - 12;
			// 이 수 만큼 13년도식으로 더해보자.
			long newYear = 2016 + (tmp/13);
			long newMonth = 12;
			for (int i = 0; i < tmp%13; i++) {
				newMonth++;
				if(newMonth == 14)
				{
					newMonth = 1;
					newYear++;
				}
			}
			sb.append(newYear).append(" ").append(newMonth).append("\n");
		}
		System.out.println(sb);
	}
}