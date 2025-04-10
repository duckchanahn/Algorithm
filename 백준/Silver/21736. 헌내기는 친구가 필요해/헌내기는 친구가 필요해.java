import java.util.*;
import java.io.*;

public class Main {
    
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] size = Arrays.stream(br.readLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
        int answer = 0;
        int N = size[0];
        int M = size[1];
        char[][] map = new char[N][M];
        boolean[][] visited = new boolean[N][M];
        int[] pos = new int[2];
        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if(map[i][j] == 'I') {
                    pos = new int[] {i, j};
                }
            }
        }
        
        Queue<int[]> q = new ArrayDeque<>();
        q.add(pos);
        visited[pos[0]][pos[1]] = true;
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(
                    0 <= nx
                    && nx < N
                    && 0 <= ny
                    && ny < M
                    && !visited[nx][ny]
                    && map[nx][ny] != 'X'
                ) {
                    q.add(new int[] {nx, ny});
                    visited[nx][ny] = true;
                    if(map[nx][ny] == 'P') {
                        answer++;
                    }
                }
                    
            }
        }
        
        System.out.println(answer == 0 ? "TT" : answer);
    }
}