import java.util.*;
import java.io.*;

public class Main {

    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    private static int N;
    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = (int)s.charAt(j) - '0';
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    list.add(bfs(i, j));
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for(int i : list) {
            System.out.println(i);
        }
    }

    private static int bfs(int i, int j) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {i, j});
        visited[i][j] = true;
        int size = 1;

        while(!q.isEmpty()) {
            int[] now = q.poll();

            for(int idx = 0; idx < 4; idx++) {
                int nx = now[0] + dx[idx];
                int ny = now[1] + dy[idx];

                if(
                        nx < N
                                && 0 <= nx
                                && ny < N
                                && 0 <= ny
                                && map[nx][ny] == 1
                                && !visited[nx][ny]
                ) {
                    q.add(new int[] {nx, ny});
                    visited[nx][ny] = true;
                    size++;
                }
            }
        }
        return size;
    }
}