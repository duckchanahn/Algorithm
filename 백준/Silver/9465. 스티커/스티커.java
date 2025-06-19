import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            System.out.println(calMax(br));
        }
    }

    private static int calMax(BufferedReader br) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n + 1][2];
        StringTokenizer st;
        for(int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                map[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n + 1][2];
        dp[1] = map[1];
        for(int i = 2; i <= n; i++) {
            dp[i][0] = Math.max(dp[i-1][1], dp[i-2][1]) + map[i][0];
            dp[i][1] = Math.max(dp[i-1][0], dp[i-2][0]) + map[i][1];
        }

        return Math.max(dp[n][0], dp[n][1]);
    }
}