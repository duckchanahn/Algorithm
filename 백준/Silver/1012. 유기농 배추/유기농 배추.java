
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            System.out.println(bfs(br));
        }
    }

    private static int bfs(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        boolean[][] visit = new boolean[N][M];
        int count = 0;

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[y][x] = 1;
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        Queue<int[]> q = new ArrayDeque<>();
        for(int y = 0; y < N; y++) {
            for(int x = 0; x < M; x++) {
                if(map[y][x] == 1 && !visit[y][x]) {
                    count++;
                    visit[y][x] = true;
                    q.add(new int[] {y, x});

                    while (!q.isEmpty()) {
                        int[] now = q.poll();

                        for(int d = 0; d < 4; d++) {
                            int ny = now[0] + dy[d];
                            int nx = now[1] + dx[d];

                            if(ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx] || map[ny][nx] != 1) {
                                continue;
                            }

                            visit[ny][nx] = true;
                            q.add(new int[] {ny, nx});
                        }
                    }
                }
            }
        }

        return count;
    }
}