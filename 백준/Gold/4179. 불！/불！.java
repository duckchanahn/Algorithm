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

        boolean[][] map = new boolean[R][C];
        Queue<int[]> person = new LinkedList<>();
        Queue<int[]> fire = new LinkedList<>();

        for(int i = 0; i < R; i++) {
            String line = br.readLine();
            for(int j = 0; j < C; j++) {
                char c = line.charAt(j);
                if(c == '.') {
                    map[i][j] = true;
                } else if(c == 'J') {
                    person.add(new int[]{i, j, 0});
                    map[i][j] = true;  // J 위치도 이동 가능한 곳으로 표시
                    // 시작부터 가장자리인 경우 체크
                    if(i == 0 || i == R-1 || j == 0 || j == C-1) {
                        System.out.println(1);
                        return;
                    }
                } else if(c == 'F') {
                    fire.add(new int[]{i, j});
                }
            }
        }

        while(!person.isEmpty()) {
            // 불 퍼뜨리기
            int fireSize = fire.size();
            for(int i = 0; i < fireSize; i++) {  // 현재 불의 크기만큼만 처리
                int[] now = fire.poll();

                for(int dir = 0; dir < 4; dir++) {
                    int nx = now[0] + dx[dir];
                    int ny = now[1] + dy[dir];

                    if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                    if(map[nx][ny]) {
                        map[nx][ny] = false;
                        fire.add(new int[]{nx, ny});
                    }
                }
            }

            // 지훈이 이동
            int personSize = person.size();
            for(int i = 0; i < personSize; i++) {
                int[] now = person.poll();

                for(int dir = 0; dir < 4; dir++) {
                    int nx = now[0] + dx[dir];
                    int ny = now[1] + dy[dir];

                    // 범위를 벗어났다는 것은 탈출에 성공했다는 의미
                    if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                    
                    if(map[nx][ny]) {
                        if(nx == 0 || nx == R-1 || ny == 0 || ny == C-1) {
                            System.out.println(now[2] + 2);  // 현재 위치에서 가장자리로 이동하므로 +2
                            return;
                        }
                        map[nx][ny] = false;
                        person.add(new int[]{nx, ny, now[2] + 1});
                    }
                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}