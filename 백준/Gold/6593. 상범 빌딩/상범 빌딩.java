import java.io.*;
import java.util.*;

public class Main {
   static int L, R, C;
   static char[][][] map;
   static boolean[][][] visited;
   static int[] dx = {-1, 1, 0, 0, 0, 0};
   static int[] dy = {0, 0, -1, 1, 0, 0};
   static int[] dz = {0, 0, 0, 0, 1, -1};
   
   static class Position {
       int x, y, z, time;
       
       Position(int z, int x, int y, int time) {
           this.z = z;
           this.x = x;
           this.y = y;
           this.time = time;
       }
   }
   
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
       while (true) {
           StringTokenizer st = new StringTokenizer(br.readLine());
           L = Integer.parseInt(st.nextToken());
           R = Integer.parseInt(st.nextToken());
           C = Integer.parseInt(st.nextToken());
           
           if (L == 0 && R == 0 && C == 0) break;
           
           map = new char[L][R][C];
           visited = new boolean[L][R][C];
           Position start = null;
           
           for (int i = 0; i < L; i++) {
               for (int j = 0; j < R; j++) {
                   String line = br.readLine();
                   for (int k = 0; k < C; k++) {
                       map[i][j][k] = line.charAt(k);
                       if (map[i][j][k] == 'S') {
                           start = new Position(i, j, k, 0);
                       }
                   }
               }
               br.readLine();
           }
           
           int result = bfs(start);
           if (result == -1) {
               System.out.println("Trapped!");
           } else {
               System.out.println("Escaped in " + result + " minute(s).");
           }
       }
   }
   
   static int bfs(Position start) {
       Queue<Position> q = new LinkedList<>();
       q.offer(start);
       visited[start.z][start.x][start.y] = true;
       
       while (!q.isEmpty()) {
           Position now = q.poll();
           
           if (map[now.z][now.x][now.y] == 'E') {
               return now.time;
           }
           
           for (int i = 0; i < 6; i++) {
               int nz = now.z + dz[i];
               int nx = now.x + dx[i];
               int ny = now.y + dy[i];
               
               if (isValid(nz, nx, ny) && !visited[nz][nx][ny] && map[nz][nx][ny] != '#') {
                   visited[nz][nx][ny] = true;
                   q.offer(new Position(nz, nx, ny, now.time + 1));
               }
           }
       }
       
       return -1;
   }
   
   static boolean isValid(int z, int x, int y) {
       return z >= 0 && z < L && x >= 0 && x < R && y >= 0 && y < C;
   }
}