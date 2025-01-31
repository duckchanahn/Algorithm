
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] size = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] map = new int[size[1]][size[0]];
        boolean[][] visit = new boolean[size[1]][size[0]];
        Queue<int[]> q = new ArrayDeque<>();
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int amount = 0;
        for(int i = 0; i < size[1]; i++) {
            String[] lines = br.readLine().split(" ");
            for (int j = 0; j < size[0]; j++) {
                map[i][j] = Integer.parseInt(lines[j]);
                if(map[i][j] != -1) {
                    amount++;
                    if(map[i][j] == 1) {
                        q.add(new int[] {i, j, 0}); // Added day counter
                        visit[i][j] = true;
                    }
                }
            }
        }

        int count = q.size();
        int maxDays = 0;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            maxDays = Math.max(maxDays, now[2]); // Track maximum days

            for(int i = 0; i < 4; i++) {
                int[] next = new int[] {now[0] + dx[i], now[1] + dy[i], now[2] + 1}; // Include day increment

                if(next[0] < 0 || size[1] <= next[0] || next[1] < 0 || size[0] <= next[1]) continue;

                if(!visit[next[0]][next[1]] && map[next[0]][next[1]] == 0) {
                    q.add(next);
                    visit[next[0]][next[1]] = true;
                    count++;
                }
            }
        }

        System.out.println(count == amount ? maxDays : -1);
    }
}