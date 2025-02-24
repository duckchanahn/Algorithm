import java.io.*;
import java.util.*;

public class Main {
    static char[][] map = new char[12][6];
    static int answer;
    static int[] dx = {-1, 1, 0, 0};  // 상하좌우 이동을 위한 배열
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;  // BFS 방문 체크용
    static boolean isPopped;     // 터진 뿌요가 있는지 체크

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 12; i++) {
            map[i] = br.readLine().toCharArray();
        }

        answer = 0;
        while(true) {
            isPopped = false;
            peong();  // 터트리기
            if(!isPopped) break;  // 터진 뿌요가 없으면 종료
            down();   // 떨구기
            answer++;  // 연쇄 카운트 증가
        }

        System.out.println(answer);
    }

    // 터트리기
    static void peong() {
        visited = new boolean[12][6];

        // 모든 칸을 순회하며 4개 이상 연결된 뿌요 찾기
        for(int i = 0; i < 12; i++) {
            for(int j = 0; j < 6; j++) {
                if(map[i][j] != '.' && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }
    }

    // BFS로 같은 색 뿌요 찾기
    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> puyoList = new ArrayList<>();  // 연결된 뿌요들의 좌표 저장
        char color = map[x][y];

        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        puyoList.add(new int[]{x, y});

        while(!queue.isEmpty()) {
            int[] current = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if(nx >= 0 && nx < 12 && ny >= 0 && ny < 6 &&
                        !visited[nx][ny] && map[nx][ny] == color) {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    puyoList.add(new int[]{nx, ny});
                }
            }
        }

        // 연결된 뿌요가 4개 이상이면 터트리기
        if(puyoList.size() >= 4) {
            for(int[] puyo : puyoList) {
                map[puyo[0]][puyo[1]] = '.';
            }
            isPopped = true;
        }
    }

    // 떨구기
    static void down() {
        // 아래에서부터 위로 탐색
        for(int i = 11; i >= 0; i--) {
            for(int j = 0; j < 6; j++) {
                if(map[i][j] != '.') {
                    int tmp = i;
                    // 현재 뿌요를 아래로 떨어뜨릴 수 있는 만큼 떨어뜨림
                    while(tmp < 11 && map[tmp + 1][j] == '.') {
                        map[tmp + 1][j] = map[tmp][j];
                        map[tmp][j] = '.';
                        tmp++;
                    }
                }
            }
        }
    }
}