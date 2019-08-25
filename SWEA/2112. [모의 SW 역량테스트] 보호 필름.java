import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static int D, W, K;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			D = sc.nextInt(); // 두께
			W = sc.nextInt(); // 가로길이
			K = sc.nextInt(); // 합격기준

			int film[][] = new int[D][W];
			for (int y = 0; y < D; y++) {
				for (int x = 0; x < W; x++) {
					film[y][x] = sc.nextInt();
				}
			}
			ans = Integer.MAX_VALUE;
			solve(film, D, W, K, 0, 0);
			System.out.println("#"+t+" "+ans);
		}
	}

	public static int ans; // 여기애들은 주어진 값 // A혹은 B로 바꿀 때마다 하나씩 증가.

	public static void solve(int film[][], int D, int W, int K, int cnt, int row) { // 몇 번째 행을 안바꿈, A,B로 할 지 검사하는 idx
		if (isOk(film, D, W, K)) {
			if (ans > cnt)
				ans = cnt;
			return;
		}
		if (ans < cnt) // 백트래킹
			return;
		if (row == D)
			return; // 다 검사한 경우니 return

		// row 행에 대해 안 바꾸고 다음 행 검사하러 가는 경우
		solve(film, D, W, K, cnt, row + 1);

		int temp[] = new int[W];
		for (int i = 0; i < W; i++) {
			temp[i] = film[row][i];
		}
		// row 행에 대해서 A로 바꾸고 다음 행으로 넘어가는 경우 0:A 1:B
		// row행의 모든 셀을 A로 변경한다.
		for (int i = 0; i < W; i++) {
			film[row][i] = 0;
		}
		solve(film, D, W, K, cnt + 1, row + 1);
		// 위에서 A로 변경했던 셀을 원래의 값으로 되돌려 놓기 ( 백트랙킹 )

		// B로 바꾸기
		for (int i = 0; i < W; i++) {
			film[row][i] = 1;
		}
		solve(film, D, W, K, cnt + 1, row + 1);
		for (int i = 0; i < W; i++) {
			film[row][i] = temp[i];
		}
	}

	public static boolean isOk(int[][] film, int D, int W, int K) {
		for (int j = 0; j < W; j++) {
			boolean isok = false;
			int cnt = 1;
			for (int i = 1; i < D; i++) {
				if (film[i][j] == film[i - 1][j]) {
					cnt++;
				} else {
					cnt = 1;
				}

				if (cnt >= K) {
					isok = true;
					break;
				}
			}
			if (!isok)
				return false;
		}
		return true;
	}
}