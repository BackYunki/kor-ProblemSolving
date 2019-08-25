import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution
{
    public static class Node
    {
        LinkedList<Node> link;
        int num;
        boolean visited;
        int depth;

        Node(int num)
        {
            this.num = num;
            link = new LinkedList<>();
        }
    }

    public static void main(String[] args)
    {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        for (int t = 1; t <= 10; t++)
        {
            sb.append("#").append(t).append(" ");
            ////////////////////////////////////////////
            int N = sc.nextInt()/2; // 반복횟수
            int S = sc.nextInt(); // 당번
            // 1. 노드 초기화
            Node[] node = new Node[101];
            for (int i = 0; i < 101; i++)
                node[i] = new Node(i);

            // 2. 인접 리스트 갱신
            for (int i = 0; i < N; i++)
            {
                int a = sc.nextInt();
                int b = sc.nextInt();
                node[a].link.add(node[b]);
            }

            // int cnt = 0;for (int i = 0; i < 101; i++) if(node[i].link.size() > 0) cnt++;System.out.println("연락 가능 노드 수: " + cnt);
            Queue<Node> q = new LinkedList<>();
            q.add(node[S]); // 2번 노드가 들어간 상태임.
            node[S].visited = true; // 2번 노드 방문체크
            int depth = 0;
            while (!q.isEmpty())
            {
                Node head = q.poll(); // 2번 노드를 빼고
                // 자식들을 방문해본다.
                for (Node child : head.link)
                {
                    if(!child.visited)
                    {
                        // 자식들을 방문할 때 큐에 넣는데. 깊이를 갱신해서 넣고
                        child.depth = head.depth+1;
                        child.visited = true;
                        q.add(child);
                        // 7이랑 15가 들어가고
                        // 최대 깊이를 갱신한다.
                        depth = Math.max(depth, child.depth);
                    }
                }
            }
            int maxValue = 0;
            for (int i = 0; i < 101; i++)
            {
                if (node[i].depth == depth)
                {
                    maxValue = Math.max(maxValue, node[i].num);
                }
            }
            sb.append(maxValue);
            ////////////////////////////////////////////
            sb.append("\n");
        }
        System.out.println(sb);
    }
}