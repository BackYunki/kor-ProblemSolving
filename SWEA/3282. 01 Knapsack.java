import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution
{
    static class Item
    {
        int w;
        int v;

        Item(){}
        Item(int w, int v)
        {
            this.w = w;
            this.v = v;
        }
    }

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine().trim());

        for(int t = 1; t <= tc; t++)
        {
            sb.append("#").append(t).append(" ");
            st= new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            Item[] items = new Item[n+1];
            items[0] = new Item(0, 0);
            for (int i = 1; i < items.length; i++)
            {
                st = new StringTokenizer(br.readLine(), " ");
                int w = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                items[i] = new Item(w, v);
            }

            int K[][] = new int[n+1][W+1];
            for (int i = 1; i <= n; i++)
            {
                Item curItem = items[i];
                for (int w = 1; w <= W; w++)
                {
                    if(w < items[i].w)
                        K[i][w] = K[i-1][w];
                    else
                        K[i][w] = Math.max(K[i-1][w-items[i].w] + items[i].v, K[i-1][w]);
                }
            }
            sb.append(K[n][W]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}