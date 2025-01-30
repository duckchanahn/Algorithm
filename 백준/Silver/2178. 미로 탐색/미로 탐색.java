
import java.util.*;
import java.io.*;

public class Main {
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] size = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] map = new int[size[0]][size[1]];
        int[][] distance = new int[size[0]][size[1]];
        for(int i = 0; i < size[0]; i++) {
            map[i] = br.readLine().chars().map(c -> c - '0').toArray();
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { 0, 0 });
        distance[0][0] = 1;

        while(!q.isEmpty()) {
            int[] now = q.poll();

            if(now[0] == size[0] - 1 && now[1] == size[1] - 1) {
                break;
            }

            for(int i = 0; i < 4; i++) {
                int[] next = {now[0] + dx[i], now[1] + dy[i]};

                if(next[0] < 0 || size[0] <= next[0] || next[1] < 0 || next[1] >= size[1]) continue;

                if(distance[next[0]][next[1]] == 0 && map[next[0]][next[1]] == 1) {
                    q.offer(new int[] { next[0], next[1] });
                    distance[next[0]][next[1]] = distance[now[0]][now[1]] + 1;
                }
            }
        }

        System.out.println(distance[size[0]-1][size[1]-1]);
    }
}
