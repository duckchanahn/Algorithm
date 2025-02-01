
import java.util.*;
import java.io.*;

public class Main {
    private static final int[] dm = {1, -1, 0, 0, 0, 0};
    private static final int[] dn = {0, 0, 1, -1, 0, 0};
    private static final int[] dh = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int max = 0;

        int[][][] map = new int[H][N][M];
        Queue<int[]> q = new ArrayDeque<>();
        int amount = 0;
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < M; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if(map[i][j][k] != 0) amount++;
                    if(map[i][j][k] == 1) q.add(new int[] {i, j, k, 0});
                }
            }
        }

        while(!q.isEmpty()) {
            int[] now = q.poll();

            for(int i = 0; i < 6; i++) {
                int nh = now[0] + dh[i];
                int nn = now[1] + dn[i];
                int nm = now[2] + dm[i];
                int day = now[3] + 1;

                if(nh < 0 || nn < 0 || nm < 0 || H <= nh || N <= nn || M <= nm || map[nh][nn][nm] != 0) continue;

                map[nh][nn][nm] = 1;
                amount++;
                q.add(new int[] {nh, nn, nm, day});
                max = Math.max(max, day);
            }
        }

        System.out.println(amount == N * M * H ? max : -1);
    }
}