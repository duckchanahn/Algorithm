import java.util.*;
import java.io.*;
public class Main {
    
    static int K, W, H;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[] dxh = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dyh = {2, 1, -1, -2, -2, -1, 1, 2};
    
    public static void main(String[] args) throws Exception {
        inputData();
        
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {0, 0, K, 0});
        visited[0][0][K] = true;
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int k = now[2];
            int time = now[3];
            
            if(x == W-1 && y == H-1) {
                System.out.println(time);
                return;
            }
            
            for(int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                
                if(validInner(nx, ny) && map[ny][nx] == 0 && !visited[ny][nx][k]) {
                    visited[ny][nx][k] = true;
                    q.add(new int[] {nx, ny, k, time + 1});
                }
            }
            
            if(k > 0) {
                for(int dir = 0; dir < 8; dir++) {
                    int nx = x + dxh[dir];
                    int ny = y + dyh[dir];
                    
                    if(validInner(nx, ny) && map[ny][nx] == 0 && !visited[ny][nx][k-1]) {
                        visited[ny][nx][k-1] = true;
                        q.add(new int[] {nx, ny, k-1, time + 1});
                    }
                }
            }
        }
        
        System.out.println("-1");
    }
    
    private static boolean validInner(int nx, int ny) {
        if(0 <= nx && nx < W && 0 <= ny && ny < H) {
            return true;
        }
        return false;
    }
    
    private static void inputData() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        map = new int[H][W];
        visited = new boolean[H][W][K+1];
        
        for(int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}