import java.util.*;
import java.io.*;

public class Main {
    static int R, C;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> water = new ArrayDeque<>();
    static Queue<int[]> swan = new ArrayDeque<>();
    static Queue<int[]> nextWater = new ArrayDeque<>();
    static Queue<int[]> nextSwan = new ArrayDeque<>();
    static boolean[][] visited;
    static int[] start;
    static int[] end;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        map = new char[R][C];
        visited = new boolean[R][C];
        
        for(int i = 0; i < R; i++) {
            String line = br.readLine();
            for(int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                if(map[i][j] != 'X') {
                    water.add(new int[]{i, j});
                }
                if(map[i][j] == 'L') {
                    if(start == null) start = new int[]{i, j};
                    else end = new int[]{i, j};
                }
            }
        }
        
        swan.add(start);
        visited[start[0]][start[1]] = true;
        
        int day = 0;
        while(!meetSwan()) {
            melt();
            day++;
        }
        System.out.println(day);
    }
    
    static boolean meetSwan() {
        while(!swan.isEmpty()) {
            int[] now = swan.poll();
            
            if(now[0] == end[0] && now[1] == end[1]) return true;
            
            for(int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                
                if(nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    if(map[nx][ny] == 'X') {
                        nextSwan.add(new int[]{nx, ny});
                    } else {
                        swan.add(new int[]{nx, ny});
                    }
                }
            }
        }
        
        swan = nextSwan;
        nextSwan = new ArrayDeque<>();
        return false;
    }
    
    static void melt() {
        while(!water.isEmpty()) {
            int[] now = water.poll();
            
            for(int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                
                if(nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] == 'X') {
                    map[nx][ny] = '.';
                    nextWater.add(new int[]{nx, ny});
                }
            }
        }
        
        water = nextWater;
        nextWater = new ArrayDeque<>();
    }
}