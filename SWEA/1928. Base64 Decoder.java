import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class Solution {
	
	static HashMap<Character, Integer> table = new HashMap<Character, Integer>();
	
	public static void makeTable()
	{
		// 대문자 넣기
		for (int i = 0; i < 26; i++) {
			table.put((char)('A'+i), i);
		}
		// 소문자 넣기
		for (int i = 0; i < 26; i++) {
			table.put((char)('a'+i), 26+i);
		}
		// 숫자 넣기
		for (int i = 0; i < 10; i++) {
			table.put((char)('0'+i), 52+i);
		}
		table.put('+', 62);
		table.put('/', 63);
	}
	
	// 읽은 문자를 테이블에서 찾고 숫자로 바꾼 다음에 바이트로 변환해서 넘겨준다.
	public static byte charToByte(char c)
	{
		//System.out.println((byte)(table.get(c) & 0xFF));
		return (byte)(table.get(c) & 0xFF);
	}
	public static int[] byteToBits(byte b)
	{
		//System.out.println(b);
		int bit_arr[] = new int[6];
		for (int k = 5; k > -1; k--) {
			if((b & (1 << k)) != 0)
			{
				bit_arr[5-k] = 1;
			}
			else bit_arr[5-k] = 0;
		}
		return bit_arr;
	}
	
	// 8개의 문자
	public static char bitsToChar(int bits[])
	{
		int sum = 0;
		//System.out.println(Arrays.toString(bits));
		for (int i = 0; i < 8; i++) {
			if(bits[i] == 1)
			{
				sum += Math.pow(2, 7-i); 
			}
		}
		//System.out.println(sum);
		return (char)sum;
	}
	
	public static void main(String[] args) {
		// 테이블 만들어 두기: key: 디코딩 문자, value: 그 문자의 숫자값
		makeTable();
		
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			String e_str = sc.next();
			char e_char[] = e_str.toCharArray();
			StringBuilder d_str = new StringBuilder();
			int cnt = 0;
			
			for (int i = 0; i < e_str.length()/4; i++) {
				ArrayList<Integer> de_bits = new ArrayList<Integer>();
				byte byte_temp[] = new byte[4];
				// 4개씩 끊어 읽기
				for (int j = 0; j < 4; j++) {
					byte_temp[j] = charToByte(e_char[cnt++]);
					
					// 예로 19가 읽혔으면 거기서 6비트만 필요하다. 
					int bits[] = byteToBits(byte_temp[j]);
					for (int k = 0; k < bits.length; k++) {
						de_bits.add(bits[k]);
					}
				}
				
				// de_bits리스트에 등록된 문자열을 8개씩 끊어 읽어서 문자열로 바꿔  sb에 추가한다.
				int cnt2 = 0;
				for (int j = 0; j < 3; j++) {
					int bit8 [] = new int[8];
					for (int k = 0; k < 8; k++) {
						bit8[k] = de_bits.get(cnt2++); 
					}
					char temp = bitsToChar(bit8);
					d_str.append(""+temp);
				}
			}
			System.out.println("#" + t + " " + d_str.toString());
		}
	}	
}