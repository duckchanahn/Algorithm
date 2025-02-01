
import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] map = new char[R][C];
        Queue<int[]> person = new LinkedList<>();
        Queue<int[]> fire = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];

        // 입력 처리
        for(int i = 0; i < R; i++) {
            String line = br.readLine();
            for(int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                if(map[i][j] == 'J') {
                    person.add(new int[]{i, j, 0});
                    visited[i][j] = true;
                } else if(map[i][j] == 'F') {
                    fire.add(new int[]{i, j});
                }
            }
        }

        while(!person.isEmpty()) {
            // 불 먼저 퍼뜨리기
            int fireSize = fire.size();
            for(int i = 0; i < fireSize; i++) {
                int[] cur = fire.poll();

                for(int dir = 0; dir < 4; dir++) {
                    int nx = cur[0] + dx[dir];
                    int ny = cur[1] + dy[dir];

                    if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                    if(map[nx][ny] == '.' || map[nx][ny] == 'J') {
                        map[nx][ny] = 'F';
                        fire.add(new int[]{nx, ny});
                    }
                }
            }

            // 지훈이 이동
            int personSize = person.size();
            for(int i = 0; i < personSize; i++) {
                int[] cur = person.poll();

                // 가장자리에 도달했는지 확인
                if(cur[0] == 0 || cur[0] == R-1 || cur[1] == 0 || cur[1] == C-1) {
                    System.out.println(cur[2] + 1);
                    return;
                }

                for(int dir = 0; dir < 4; dir++) {
                    int nx = cur[0] + dx[dir];
                    int ny = cur[1] + dy[dir];

                    if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                    if(!visited[nx][ny] && map[nx][ny] == '.') {
                        visited[nx][ny] = true;
                        person.add(new int[]{nx, ny, cur[2] + 1});
                    }
                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}