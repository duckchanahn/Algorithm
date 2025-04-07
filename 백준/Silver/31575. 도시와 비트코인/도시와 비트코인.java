import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[M][N];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[M][N];
        q.add(new int[] {0, 0});
        visited[0][0] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            if(now[0] == (M-1) && now[1] == (N-1)) {
                System.out.println("Yes");
                return;
            }

            int[] nextY = new int[] {now[0] + 1, now[1]};
            int[] nextX = new int[] {now[0], now[1] + 1};

            valid(N, M, map, q, visited, nextX);
            valid(N, M, map, q, visited, nextY);
        }
        System.out.println("No");
    }

    private static void valid(int n, int m, int[][] map, Queue<int[]> q, boolean[][] visited, int[] nextX) {
        if(nextX[0] < m
                && nextX[0] >= 0
                && nextX[1] < n
                && nextX[1] >= 0
                && !visited[nextX[0]][nextX[1]]
                && map[nextX[0]][nextX[1]] == 1) {
            q.add(new int[] {nextX[0], nextX[1]});
            visited[nextX[0]][nextX[1]] = true;
        }
    }
}