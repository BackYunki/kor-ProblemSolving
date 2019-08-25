import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static boolean[] chk;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            sb.append("#").append(t).append(" ");
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            chk = new boolean[10001];
            List<Integer> list = new ArrayList<>();
            list.add(0);
            for (int i = 0; i < N; i++) {
                int score = Integer.parseInt(st.nextToken());
                int range = list.size();
                for (int j = 0; j < range; j++) {
                    int newScore = list.get(j) + score;
                    if (!chk[newScore]) {
                        list.add(newScore);
                        chk[newScore] = true;
                    }
                }
            }
            sb.append(list.size()).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}