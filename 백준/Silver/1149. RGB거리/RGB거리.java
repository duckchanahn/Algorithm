import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[][] map = new int[size][3];

        for(int i = 0; i < size; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int[][] dp = new int[size][3];
        dp[0] = map[0];

        for(int i = 1; i < size; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + map[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + map[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + map[i][2];
        }

        System.out.println(Math.min(dp[size-1][0], Math.min(dp[size-1][1], dp[size-1][2])));
    }
}