import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N+1][2];
        for(int i = 1; i <= N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        long[] dp = new long[N+2];

        for(int i = N; 0 < i; i--) {
            if(map[i][0] + i - 1 <= N) {
                dp[i] = Math.max(
                        dp[i + 1],
                        dp[i + map[i][0]] + map[i][1]
                );
            } else {
                dp[i] = dp[i + 1];
            }
        }

        System.out.println(dp[1]);
    }
}