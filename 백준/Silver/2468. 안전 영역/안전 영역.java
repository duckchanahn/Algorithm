import java.util.*;
import java.io.*;

public class Main {
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int N;
    private static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());  // int 키워드 제거

        map = new int[N][N];
        int maxHeight = 0;  // 최대 높이 추적

        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);  // 최대 높이 갱신
            }
        }

        int answer = 1;  // 최소 1개는 보장 (비가 안 올 때)
        for(int h = 1; h <= maxHeight; h++) {  // 0부터 최대높이까지
            int count = bfs(h);
            answer = Math.max(answer, count);
        }

        System.out.println(answer);
    }

    private static int bfs(int h) {
        Queue<int[]> q;
        boolean[][] visited = new boolean[N][N];
        int count = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] > h && !visited[i][j]) {
                    q = new ArrayDeque<>();
                    q.add(new int[] {i, j});
                    visited[i][j] = true;

                    while(!q.isEmpty()) {
                        int[] now = q.poll();

                        for(int dir = 0; dir < 4; dir++) {
                            int nx = now[0] + dx[dir];
                            int ny = now[1] + dy[dir];

                            if(0 <= nx && nx < N && 0 <= ny && ny < N
                                    && map[nx][ny] > h && !visited[nx][ny]) {
                                q.add(new int[] {nx, ny});
                                visited[nx][ny] = true;
                            }
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }
}