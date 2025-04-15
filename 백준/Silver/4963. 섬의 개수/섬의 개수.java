import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;

    // 12시부터 시계방향
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

    static int h;
    static int w;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));


        while(true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w == 0 && h == 0) return;
            test(w, h);
        }
    }

    private static void test(int w, int h) throws Exception {
        int answer = 0;
        int[][] map = new int[h][w];
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[h][w];

        for(int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    q.add(new int[] {i, j});
                    visited[i][j] = true;
                    bfs(q, visited, map);
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    private static void bfs(Queue<int[]> q, boolean[][] visited, int[][] map) {
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[1];
            int y = now[0];

            for(int i = 0; i < dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(
                        0 <= nx
                                && nx < w
                                && 0 <= ny
                                && ny < h
                                && !visited[ny][nx]
                                && map[ny][nx] == 1
                ) {
                    q.add(new int[] {ny, nx});
                    visited[ny][nx] = true;
                }
            }
        }
    }
}