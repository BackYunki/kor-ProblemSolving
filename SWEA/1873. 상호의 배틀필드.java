import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
  
public class Solution {
    final static int RIGHT=0,LEFT=1,DOWN=2,UP=3;
    static int h,w,x,y,dir;
    static int[][] arr;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for(int i=1;i<=tc;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            arr = new int[h][w];
            for(int j=0;j<h;j++) {
                String t = br.readLine();
                for(int k=0;k<w;k++) {
                    int temp = t.charAt(k);
                    arr[j][k] = temp;
                    if(temp!='.'&&temp!='*'&&temp!='#'&&temp!='-') {
                        x = j;
                        y = k;
                        if(temp=='<') dir = LEFT;
                        else if(temp=='>') dir = RIGHT;
                        else if(temp=='^') dir = UP;
                        else if(temp=='v') dir = DOWN;
                    }
                }                   
            }
            int n = Integer.parseInt(br.readLine());
            String t = br.readLine();
            for(int j=0;j<n;j++) {
                switch(t.charAt(j)) {
                case 'U':
                    up();
                    break;
                case 'D':
                    down();
                    break;
                case 'L':
                    left();
                    break;
                case 'R':
                    right();
                    break;
                case 'S':
                    shoot();
                    break;
                }
            }
            sb.append("#"+i+" ");
            for(int j=0;j<h;j++) {
                for(int k=0;k<w;k++)
                    sb.append((char)arr[j][k]);
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
     
    private static void shoot() {
        // *만 제거 가능
        switch(dir) {
        case RIGHT:
            for(int i=y+1;i<w;i++) {
                if(arr[x][i]=='#') return;
                else if(arr[x][i]=='*') {
                    arr[x][i]='.';
                    return;
                }
            }
            break;
        case LEFT:
            for(int i=y-1;i>=0;i--) {
                if(arr[x][i]=='#') return;
                else if(arr[x][i]=='*') {
                    arr[x][i]='.';
                    return;
                }
            }
            break;
        case UP:
            for(int i=x-1;i>=0;i--) {
                if(arr[i][y]=='#') return;
                else if(arr[i][y]=='*') {
                    arr[i][y]='.';
                    return;
                }
            }
            break;
        case DOWN:
            for(int i=x+1;i<h;i++) {
                if(arr[i][y]=='#') return;
                else if(arr[i][y]=='*') {
                    arr[i][y]='.';
                    return;
                }
            }
            break;
        }
    }
    private static void right() {
        dir = RIGHT;
        arr[x][y] = '>';
        if(y+1>=w) return;
        if(arr[x][y+1]=='.') {
            arr[x][y++] = '.';
            arr[x][y] = '>';
        }
    }
    private static void left() {
        dir = LEFT;
        arr[x][y] = '<';
        if(y-1<0) return;
        if(arr[x][y-1]=='.') {
            arr[x][y--] = '.';
            arr[x][y] = '<';
        }
    }
     
    private static void up() {
        dir = UP;
        arr[x][y] = '^';
        if(x-1<0) return;
        if(arr[x-1][y]=='.') {
            arr[x--][y] = '.';
            arr[x][y]='^';
        }
    }
     
    private static void down() {
        dir = DOWN;
        arr[x][y] = 'v';
        if(x+1>=h) return;
        if(arr[x+1][y]=='.') {
            arr[x++][y] = '.';
            arr[x][y] = 'v';
        }
    }
}