import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution
{
    public static int[] parent;
    public static int[] rank;
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++)
        {
            sb.append("#").append(t).append(" ");

            String[] NM = br.readLine().split(" ");
            int N = Integer.parseInt(NM[0]); // n(1≤n≤1,000,000) 정점은 100만개
            int M = Integer.parseInt(NM[1]); // m(1≤m≤100,000)   명령어는 10만개

            // 1. 서로소 원소 초기화: 자기자신을 부모로 갖게하고 트리깊이를 0으로 초기화한다.
            parent = new int[N + 1];
            rank   = new int[N + 1];
            for (int x = 1; x <= N; x++)
                makeSet(x);

            // 2. 명령어를 실행한다.
            for (int i = 0; i < M; i++)
            {
                String[] cab = br.readLine().split(" ");
                int command = Integer.parseInt(cab[0]);
                int       a = Integer.parseInt(cab[1]);
                int       b = Integer.parseInt(cab[2]);

                switch (command)
                {
                    case 0:
                        union(a, b);
                        break;
                    case 1:
                        int pa = findSet(a);
                        int pb = findSet(b);
                        sb.append((pa == pb) ? 1 : 0);
                        break;
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    // 초기화 메서드
    public static void makeSet(int x)
    {
        parent[x] = x;
        rank[x] = 0;
    }

    // 부모를 찾아오는 메서드
    public static int findSet(int x)
    {
        if(parent[x] == x) return x;
        else // 대장을 모셔오세요.
        {
            return parent[x] = findSet(parent[x]);
        }
    }

    public static void union(int a, int b)
    {
        int pa = findSet(a);
        int pb = findSet(b);

        // a집합이 더 작은 경우
        if(rank[pa] < rank[pb])
        {
            parent[pa] = pb;
        }
        else
        {
            parent[pb] = pa;
            if (rank[pa] == rank[pb])
            {
                // a에 b가 붙을 때 자신과 깊이가 같기 때문에.
                // b가 붙으면 a의 길이가 하나 증가한다.
                rank[pa]++;
            }
        }
    }
}