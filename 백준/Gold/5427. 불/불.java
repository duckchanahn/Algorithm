
import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            System.out.println(test(br));
        }
    }

    private static String test(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        Queue<int[]> q = new ArrayDeque<>();
        Queue<int[]> fireQ = new ArrayDeque<>();

        int[][] map = new int[h][w]; 
        
        for(int i = 0; i < h; i++) {
            String line = br.readLine();
            for(int j = 0; j < w; j++) {
                char c = line.charAt(j);
                switch (c) {
                    case '.':
                        map[i][j] = 0;
                        break;
                    case '@':
                        map[i][j] = 0;
                        q.add(new int[] {i, j, 0});
                        break;
                    case '#':
                        map[i][j] = -1;
                        break;
                    case '*':
                        map[i][j] = -2;
                        fireQ.add(new int[] {i, j});
                        break;
                }
            }
        }

        // 불 먼저 퍼트리고나서 상근이 이동!
        while(!q.isEmpty()) {
            int fireSize = fireQ.size();
            for(int i = 0; i < fireSize; i++) {
                int[] now = fireQ.poll();

                for(int dir = 0; dir < 4; dir++) {
                    int nx = now[0] + dx[dir];
                    int ny = now[1] + dy[dir];

                    if(nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                    if(map[nx][ny] >= 0) {  
                        map[nx][ny] = -2;
                        fireQ.add(new int[] {nx, ny});
                    }
                }
            }

            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] now = q.poll();
                int x = now[0];
                int y = now[1];
                int time = now[2];

                for(int dir = 0; dir < 4; dir++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];

                    if(nx < 0 || nx >= h || ny < 0 || ny >= w) {
                        return String.valueOf(time + 1);
                    }

                    if(map[nx][ny] == 0) { 
                        map[nx][ny] = time + 1;
                        q.add(new int[] {nx, ny, time + 1});
                    }
                }
            }
        }

        return "IMPOSSIBLE";
    }
}