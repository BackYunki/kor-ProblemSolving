import java.util.Scanner;

public class Solution {

	static int P = 1234567891;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		long fact[] = new long[1000000 + 1]; // 0팩도 있어서 
		fact[0] = 1;	// 여기 팩토리얼은 모듈러 연산을 한 상태임.
		for (int i = 1; i < fact.length; i++) {
			fact[i] = fact[i-1] *i % P;
		}
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int R = sc.nextInt();
			// 100000! mod p 를 구하시오
			
			// 들어갈 때부터 넘침을 방지하기 위해 모듈러 한 번 해져서 들어가고 ----1
			long result = fact[N] * divisionPow(fact[N-R] * fact[R] % P, P-2) % P;
			System.out.println("#" + tc + " " + result);
		}
	}
	
	// a^n 을 리턴하게 만들어보자.
	static long divisionPow(long a, int n)
	{
		if(n <= 1) return a; 
		
		long result = divisionPow(a, n/2) % P;
		
		// ------ 2 들어와서도 a 가 엄청 클 수 있으니 또 모듈러를 해줘야함.
		if(n % 2 == 0)
		{
			return result * result % P;	
		}
		else
		{
			return result * result % P * a % P;
		}
	}
}