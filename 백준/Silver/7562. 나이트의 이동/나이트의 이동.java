
import java.util.*;
import java.io.*;

public class Main {

    private static final int[] dx = {  2, 2,  1, 1, -2, -2, -1, -1 };
    private static final int[] dy = { -1, 1, -2, 2, -1,  1, -2,  2 };



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            System.out.println(move(br));
        }
    }

    private static int move(BufferedReader br) throws IOException{
        int size = Integer.parseInt(br.readLine());
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int[] now = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0 };
        st = new StringTokenizer(br.readLine());
        int[] goal = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };

        if(now[0] == goal[0] && now[1] == goal[1]) return 0;

        boolean[][] visit = new boolean[size][size];
        int min = Integer.MAX_VALUE;

        Queue<int[]> q = new ArrayDeque<>();
        q.add(now);
        while(!q.isEmpty()) {
            now = q.poll();

            for(int i = 0; i < 8; i++) {
                int[] next = { now[0] + dx[i], now[1] + dy[i], now[2] + 1 };

                if((next[0] < 0 || size <= next[0] || next[1] < 0 || size <= next[1]) || visit[next[0]][next[1]]) continue;
                if(next[0] == goal[0] && next[1] == goal[1]) {
                    min = Math.min(min, next[2]);
                    continue;
                }

                q.add(next);
                visit[next[0]][next[1]] = true;
            }
        }


        return min;
    }
}