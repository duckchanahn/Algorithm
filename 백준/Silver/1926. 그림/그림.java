import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] size = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[][] map = new int[size[0]][size[1]];
        boolean[][] visit = new boolean[size[0]][size[1]];
        for(int i = 0; i < size[0]; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        Queue<int[]> q = new LinkedList<>();

        int[] dx = { 1, -1, 0, 0};
        int[] dy = { 0, 0, 1, -1};
        int count = 0;
        int max = 0;

        for(int x = 0; x < size[0]; x++) {
            for(int y = 0; y < size[1]; y++) {
                if(visit[x][y] || map[x][y] == 0) continue;
                q.offer(new int[] { x, y });
                int extent = 1;
                visit[x][y] = true;
                while(!q.isEmpty()) {
                    int[] now = q.poll();
                        for(int i = 0; i < 4; i++) {
                            int nextX = now[0] + dx[i];
                            int nextY = now[1] + dy[i];
                            if(nextX < 0 || size[0] <= nextX || nextY < 0 || size[1] <= nextY) continue;
                            if(!visit[nextX][nextY] && map[nextX][nextY] == 1) {
                                q.offer(new int[] {nextX, nextY});
                                visit[nextX][nextY] = true;
                                extent++;
                            }
                        }
                }
                count += 1;
                max = Math.max(max, extent);
            }
        }

        System.out.print(count + "\n" + max);
    }
}
