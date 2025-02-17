import java.io.*;
import java.util.*;

public class Main {
    static char[][] map = new char[5][5];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer = 0;
    static int[][] selected = new int[7][2]; // 좌표니까 2차원 배열

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 5; i++) {
            map[i] = br.readLine().toCharArray();
        }

        dfs(0, 0);

        System.out.println(answer);
    }

    /*
     * 7개 칸 선택하기
     * => 다솜파 4명 넘으면 ? 다음 검증 : return;
     * => 7명 다 붙어있으면 ? anwer++; return;
     */
    
    static void dfs(int pos, int count) {
        if(count == 7) {
            // 7명 다 선택한 상황
            if(check()) answer++;
            return;
        }

        // 5*5
        for(int i = pos; i < 25; i++) {
            selected[count][0] = i/5;
            selected[count][1] = i%5;
            dfs(i + 1, count + 1);
        }
    }

    // 인접했는가~
    static boolean check() {
        int countS = 0;
        for(int i = 0; i < 7; i++) {
            if(map[selected[i][0]][selected[i][1]] == 'S') countS++;
        }
        if(countS < 4) return false;

        // 인접 확인
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];
        boolean[][] isSelected = new boolean[5][5];

        for(int i = 0; i < 7; i++) {
            isSelected[selected[i][0]][selected[i][1]] = true;
        }

        q.offer(selected[0]);
        visited[selected[0][0]][selected[0][1]] = true;
        int connectedCount = 1;

        while(!q.isEmpty()) {
            int[] now = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
                if(visited[nx][ny] || !isSelected[nx][ny]) continue;

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
                connectedCount++;
            }
        }

        return connectedCount == 7;
    }
}