import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(br.readLine());

        boolean[][] visited = new boolean[R][R];

        visited[x][y] = true;
        int time = 1;        

        while (true) {
            int nextX, nextY;

            if ((x + 1) + (y + 1) < R) {
                nextX = x + 1;
                nextY = y + 1;
            } else {
                nextX = x / 2;
                nextY = y / 2;
            }

            if (visited[nextX][nextY]) {
                System.out.println(time);
                break;
            }

            visited[nextX][nextY] = true;

            x = nextX;
            y = nextY;
            time++;
        }
    }
}
