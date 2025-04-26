import java.util.*;
import java.io.*;

public class Main {
    private static int[][] map;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int rows, cols, remaining;
    private static int maxDays;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        cols = Integer.parseInt(st.nextToken());  // n
        rows = Integer.parseInt(st.nextToken());  // m

        map = new int[rows][cols];
        Queue<int[]> q = new ArrayDeque<>();
        remaining = 0;

        for (int i = 0; i < rows; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < cols; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) {
                    q.add(new int[]{i, j, 0});  // {row, col, day}
                } else if (map[i][j] == 0) {
                    remaining++;
                }
            }
        }

        maxDays = 0;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int row = now[0];
            int col = now[1];
            int day = now[2];

            for (int i = 0; i < 4; i++) {
                int newRow = row + dy[i];
                int newCol = col + dx[i];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && map[newRow][newCol] == 0) {
                    map[newRow][newCol] = 1;
                    q.add(new int[]{newRow, newCol, day + 1});
                    remaining--;
                    maxDays = Math.max(maxDays, day + 1);
                }
            }
        }

        System.out.println(remaining == 0 ? maxDays : -1);
    }
}
