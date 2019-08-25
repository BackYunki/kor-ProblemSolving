import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= tc; t++) {
			int N = sc.nextInt(); // 8 <= N <= 28
			int K = sc.nextInt(); // k번째 숫자를 뽑즈아
			
			// 0단계: 입력 확인
			String str = sc.next();
			// 1단계: str을 4등분해서 출력하기 : )
			String[] parts = new String[4];
			
			int size = N/4;
			str = str.substring(str.length()-(size-1), str.length()) + str;
			//HashSet<Integer> set = new HashSet<>();
			TreeSet<Integer> set = new TreeSet<>(); 
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < N; j+=size) {
					String tmp = str.substring(i+j, i+j+size);
					set.add(Integer.parseInt(tmp, 16));
				}
			}
			for (int i = 0; i < K-1; i++) {
				set.pollLast();
			}
			System.out.println("#"+t+" "+set.pollLast());
			
			/*List<Integer> list = new ArrayList<>(set);
			Collections.sort(list);
			// 뒤에서 접근
			System.out.println("#"+t+" "+list.get(list.size()-K));*/
		}
	}
}