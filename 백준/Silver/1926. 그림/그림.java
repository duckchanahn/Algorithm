import java.util.*;
import java.io.*;

public class Main {
    
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int n, m;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
        visited = new boolean[n][m];
        
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int answer = 0;
        int max = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    max = Math.max(max, bfs(i, j));
                    answer++;
                }
            }
        }
        
        System.out.println(answer + "\n" + max);
    }
    
    
    private static int bfs(int i, int j) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {i, j});
        visited[i][j] = true;
        
        int size = 1;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            
            for(int idx = 0; idx < 4; idx++) {
                int nx = now[1] + dx[idx];
                int ny = now[0] + dy[idx];
                
                
                if(
                    0 <= nx
                    && nx < m
                    && 0 <= ny
                    && ny < n
                    && !visited[ny][nx]
                    && map[ny][nx] == 1
                ) {
                    q.add(new int[] {ny, nx});
                    visited[ny][nx] = true;
                    size++;
                }
            }
        }
        
        return size;
    }
}