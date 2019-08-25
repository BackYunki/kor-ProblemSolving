import java.util.*;
class Solution {
    public static void main(String[] args) {
        int MAX = 999;
        int[] sieve = new int[MAX+1];
        Arrays.fill(sieve, 1);
        sieve[0] = sieve[1] = 0;
        for(int i=2; i<=MAX; i++) {
            for(int j=i*2; j<=MAX; j+=i) sieve[j] = 0;
        }
         
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
         
        int N, x, y, z, count;
        for(int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            count = 0;
            int[][] visit = new int[MAX+1][MAX+1];
            for(x=2; x<=N-4; x++) {
                for(y=2; y<=N-2; y++) {
                    z = N - x - y;
                    if( z < 2 ) continue;
                    if( sieve[x] == 0 ) continue;
                    if( sieve[y] == 0 ) continue;
                    if( sieve[z] == 0 ) continue;
                    if( visit[x][y] == 1 ) continue;
                    if( visit[x][z] == 1 ) continue;
                    visit[x][y] = 1;
                    visit[y][x] = 1;
                    visit[x][z] = 1;
                    visit[z][x] = 1;
                    count++;
                }
            }
            System.out.format("#%d %d\n", test_case, count);
        }
        sc.close();
    }
}