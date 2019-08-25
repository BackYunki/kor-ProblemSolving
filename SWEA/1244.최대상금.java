import java.util.Scanner;

public class Solution {

	public static void swap(int num[], int x, int y)
	{
		int temp = num[x];
		num[x] = num[y];
		num[y] = temp;
	}

	// 문제를 해결할 친구: 입력받은 숫자배열을 넘겨줘야 한다.
	// num 배열을 한칸씩 탐색하도록 재귀... idx를 하나씩 늘리면서 재귀호출한다.
	// cnt는 회전한 카운트며  N까지 증가할 수 있다.
	
	static int ans = 0;
	
	public static void solve(int num[], int idx, int cnt, int N)
	{
		// 기본 부분 구현. 
		if(cnt == N)
		{
			// num 배열의 숫자를 계산해 보시오.
			int score = 0;
			for (int i = 0; i < num.length; i++)
				score = (10 * score) + num[i];
			
			// 그 점수가 현재 최고스코어보다 높다면
			if(score > ans)
			{
				ans = score;
			}

			//System.out.println(ans);
			return;
		}
		
		if(idx == num.length-2)// 배열의 끝까지 왔을 때: 숫자의 크기가 교환횟수보다 컸을 때 이렇게 하면 안 된다.
		{
			if(cnt % 2 == 0)
			{
				solve(num, idx, N, N);	// 짝수면  cnt 를 만땅으로 채워서 보내고
			}
			else 
			{
				swap(num, idx, idx+1);	// 홀수면 num 의 맨 뒷자리 두개를 바꿔서 대응
				solve(num, idx, N, N);
				swap(num, idx, idx+1);
			}
			return;
		}
		
		// 제일 큰 걸 찾아서 idx랑 바꾸자: idx 뒤에 중에서 제일 큰걸 찾는다.
		int bigNum = -1;
		for (int i = idx + 1; i < num.length; i++) 
		{
			if(num[i] >= bigNum) // 크거나 같아야 마지막이 기억이 
				bigNum = num[i];
		}
		
		for (int i = idx+1; i < num.length; i++) {
			if(num[i] == bigNum) // 얘도 젤 큰놈이랑 숫자가 같니?
			{
				// 바꿔주고
				swap(num, i , idx);
				solve(num, idx+1, cnt+1, N);
				swap(num, i, idx);
			
				// 다시 돌려서 안 바꾸는 경우도 봐준다.
				solve(num, idx+1, cnt, N);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) 
		{
			String input = sc.next();			//숫자 읽기
			int num[] = new int[input.length()];//숫자 하나하나를 저장할 배열
			
			for (int i = 0; i < input.length(); i++) 
				num[i] = input.charAt(i) - '0';	// 숫자로 바꿔서 삽입
		
			int N = sc.nextInt();
			ans = 0;
			solve(num, 0, 0, N);
			
			System.out.println(String.format("#%d %d", tc, ans));
		}
	}
}