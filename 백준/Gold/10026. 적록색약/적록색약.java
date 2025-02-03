
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        char[][] map = new char[size][size];
        boolean[][] visit = new boolean[size][size];
        for(int i = 0; i < size; i++) {
            String line = br.readLine();
            for(int j = 0; j < size; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };

        Queue<int[]> q = new ArrayDeque<>();
        int answer = 0;

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(visit[i][j]) continue;

                q.add(new int[] {i, j});
                while (!q.isEmpty()) {
                    int[] now = q.poll();

                    for(int index = 0; index < 4; index++) {
                        int nx = now[0] + dx[index];
                        int ny = now[1] + dy[index];
                        if(nx < 0 || size <= nx || ny < 0 || size <= ny || visit[nx][ny] || map[nx][ny] != map[i][j]) continue;

                        q.add(new int[] { nx, ny });
                        visit[nx][ny] = true;
                    }
                }
                answer++;
            }
        }

        int answerTwo = 0;
        visit = new boolean[size][size];

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(visit[i][j]) continue;

                q.add(new int[] {i, j});
                while (!q.isEmpty()) {
                    int[] now = q.poll();

                    for(int index = 0; index < 4; index++) {
                        int nx = now[0] + dx[index];
                        int ny = now[1] + dy[index];
                        if(nx < 0 || size <= nx || ny < 0 || size <= ny || visit[nx][ny]) continue;
                        if(
                                (map[i][j] == 'B' && map[nx][ny] != 'B')
                                || (map[i][j] == 'R' && map[nx][ny] == 'B')
                                || (map[i][j] == 'G' && map[nx][ny] == 'B')
                        ) continue;

                        q.add(new int[] { nx, ny });
                        visit[nx][ny] = true;
                    }
                }
                answerTwo++;
            }
        }


        System.out.println(answer + " " + answerTwo);
    }

}