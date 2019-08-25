import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution
{
    public static int Y,X;
    public static int[][] map;
    public static Queue<int[]> q;
    
    public static void main(String[] args) throws Exception
    {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++)
        {
            sb.append("#").append(t).append(" ");
            ///////////////////////////////////////////////////////////////////////
            StringTokenizer st = new StringTokenizer(br.readLine());
            Y = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            
            q = new LinkedList<>();
            map = new int[Y][X];
            for (int y = 0; y < Y; y++)
            {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < X; x++)
                    map[y][x] = Integer.parseInt(st.nextToken());
            }
            
            q.add(new int[]{R, C, map[R][C], 0});  // 멘홀의 위치를 시작점으로 한다.
            while (!q.isEmpty())
            {
                int head[] = q.poll();
                int y = head[0];
                int x = head[1];
                int shape = head[2];
                int time = head[3];

                // 종료조건
                if(time == L) break;

                // 방문체크
                map[y][x] = -1;

                // 갈 수 있는 길을 탐색한다.
                switch(shape)
                {
                    case 1:
                        for (int i = 0; i < 4; i++) 
                        	go(y, x, time, i);
                        break;
                    case 2:
                    	go(y, x, time, 0);
                    	go(y, x, time, 2);
                        break;
                    case 3:
                        go(y, x, time, 1);
                        go(y, x, time, 3);
                        break;
                    case 4:
                    	go(y, x, time, 0);
                    	go(y, x, time, 1);
                        break;
                    case 5:
                    	go(y, x, time, 1);
                    	go(y, x, time, 2);
                    	break;
                    case 6:
                    	go(y, x, time, 2);
                    	go(y, x, time, 3);
                        break;
                    case 7:
                    	go(y, x, time, 0);
                    	go(y, x, time, 3);
                        break;
                }
            }

            // 방문했던 지점(-1)을 센다.
            int cnt = 0;
            for (int y = 0; y < Y; y++)
            {
            	for (int x = 0; x < X; x++)
            	{
            		if (map[y][x] == -1)
                        cnt++;
            	}
            }
            ///////////////////////////////////////////////////////////////////////
            sb.append(cnt).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    // 범위 체크 및 디버깅 함수
    public static boolean inRange(int y, int x) { return (0 <= y && y < Y) && (0 <= x && x < X) && map[y][x] != 0; }
    public static void print(int[][] map) { for(int y = 0; y < Y; y++) { for(int x = 0; x < X; x++) System.out.printf("%2d ", map[y][x]);System.out.println(); }System.out.println(); }
    // 탐색 함수
    public static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
    public static int[][] canGo = {{1,2,5,6},{1,3,6,7},{1,2,4,7},{1,3,4,5}};
    public static void go(int y, int x, int time, int direction)
    {
    	int ny = y + dir[direction][0];
    	int nx = x + dir[direction][1];
    	// 범위를 벗어나지 않고 이미 왔던 길이 아닐 경우
    	if(inRange(ny, nx) && map[ny][nx] != -1)
    	{
    		// 가려고 하는 곳의 파이프 모양
    		int ns = map[ny][nx];
    		for (int i = 0; i < 4; i++) 
    		{
    			// 그 모양으로 갈 수 있는 파이프는 canGo에 정해져있음. 갈 수 있는 길이면 가본다.
    			if(ns == canGo[direction][i])
    				q.add(new int[] {ny,nx,ns,time+1});
			}
    	}
    }
}