import java.util.*;
import java.io.*;

public class Main {
    static int[][] mapSum;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N+1][N+1];
        mapSum = new int[N+1][N+1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 합 계산
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                // (i,j)까지의 합 = 왼쪽까지의 누적 합 + 위쪽까지의 누적 합 - 중복 영역 + 현재 값
                mapSum[i][j] = mapSum[i-1][j] + mapSum[i][j-1] - mapSum[i-1][j-1] + map[i][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            sb.append(sum(x1, y1, x2, y2)).append('\n');
        }

        System.out.println(sb.toString());
    }

    private static int sum(int x1, int y1, int x2, int y2) {
        // 전체 영역 - 제외할 영역들 + 중복 제외된 영역
        return mapSum[x2][y2] - mapSum[x1-1][y2] - mapSum[x2][y1-1] + mapSum[x1-1][y1-1];
    }
}