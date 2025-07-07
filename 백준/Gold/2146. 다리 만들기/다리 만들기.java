import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        // 지도 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1단계: 각 섬에 고유 번호 부여
        int islandNum = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    markIsland(i, j, islandNum);
                    islandNum++;
                }
            }
        }

        // 2단계: 각 섬에서 가장 짧은 다리 찾기
        int minDistance = Integer.MAX_VALUE;

        for (int island = 2; island < islandNum; island++) {
            visited = new boolean[N][N]; // 방문 배열 초기화
            int distance = findShortestBridge(island);
            minDistance = Math.min(minDistance, distance);
        }

        System.out.println(minDistance);
    }

    // 섬에 고유 번호를 부여하는 DFS
    static void markIsland(int x, int y, int islandNum) {
        visited[x][y] = true;
        map[x][y] = islandNum;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    markIsland(nx, ny, islandNum);
                }
            }
        }
    }

    // 특정 섬에서 다른 섬까지의 최단 거리를 찾는 BFS
    static int findShortestBridge(int startIsland) {
        Queue<int[]> queue = new LinkedList<>();

        // 시작 섬의 경계(바다와 인접한 지점)를 모두 큐에 추가
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == startIsland) {
                    // 바다와 인접한지 확인
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 0) {
                            queue.offer(new int[]{i, j, 0});
                            visited[i][j] = true;
                            break;
                        }
                    }
                }
            }
        }

        // BFS로 다른 섬까지의 최단 거리 찾기
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int dist = current[2];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                    // 다른 섬에 도달한 경우
                    if (map[nx][ny] != 0 && map[nx][ny] != startIsland) {
                        return dist;
                    }

                    // 바다인 경우 계속 진행
                    if (map[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny, dist + 1});
                    }
                }
            }
        }

        return Integer.MAX_VALUE;
    }
}