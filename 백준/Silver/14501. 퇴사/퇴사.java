import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int[] dp = new int[N + 2];

        for (int i = N; i >= 1; i--) {
            int T = map[i][0];
            int P = map[i][1];
            if (i + T - 1 <= N) {
                dp[i] = Math.max(dp[i + 1], P + dp[i + T]);
            } else {
                dp[i] = dp[i + 1];
            }
        }

        System.out.println(dp[1]);
    }
}
