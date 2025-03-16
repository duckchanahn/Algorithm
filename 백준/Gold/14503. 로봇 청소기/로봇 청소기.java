import java.util.*;
import java.io.*;
public class Main {
    static class Position {
        int x;
        int y;
        int dir;
        
        public Position(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir % 4;
        }
    }
    
    /*
      북0
    서3 동1
      남2
    */
    // 북, 동, 남, 서 순서 (문제 정의에 따름)
    static int[] dx = {-1, 0, 1, 0}; // 상하
    static int[] dy = {0, 1, 0, -1}; // 좌우
    static int answer = 0;
    static int[][] maps;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        maps = new int[N][M];
        
        st = new StringTokenizer(br.readLine());
        Position now = new Position(
            Integer.parseInt(st.nextToken()),
            Integer.parseInt(st.nextToken()),
            Integer.parseInt(st.nextToken())
        );
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        clean(now);
        
        System.out.println(answer);
    }
    
    // 청소 로직 구현
    public static void clean(Position now) {
        // 1. 현재 위치 청소
        if(maps[now.x][now.y] == 0) {
            maps[now.x][now.y] = 2; // 청소 완료는 2로 표시
            answer++;
        }
        
        // 2. 주변 4칸 확인
        boolean cleaned = true;
        int originalDir = now.dir;
        
        for(int i = 0; i < 4; i++) {
            // 왼쪽으로 회전 (반시계 방향)
            now.dir = (now.dir + 3) % 4;
            
            int nx = now.x + dx[now.dir];
            int ny = now.y + dy[now.dir];
            
            // 청소할 공간이 있는 경우
            if(maps[nx][ny] == 0) {
                now.x = nx;
                now.y = ny;
                cleaned = false;
                break;
            }
        }
        
        // 3. 네 방향 모두 청소가 되어있거나 벽인 경우
        if(cleaned) {
            // 후진 방향 계산
            int backDir = (originalDir + 2) % 4;
            int bx = now.x + dx[backDir];
            int by = now.y + dy[backDir];
            
            // 뒤가 벽이 아니면 후진
            if(maps[bx][by] != 1) {
                now.x = bx;
                now.y = by;
                now.dir = originalDir; // 원래 방향 유지
                clean(now);
            }
            // 뒤가 벽이면 작동 중지
            return;
        }
        
        // 4. 계속 청소
        clean(now);
    }
}