import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 1;
        while(true) {
            int size = Integer.parseInt(br.readLine());
            if(size == 0) break;

            int[][] map = new int[size][3];
            for(int i = 0; i < size; i++) {
                map[i] = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }

            System.out.println(count++ + ". " + navigator(map, size));
        }
    }

    private static long navigator(int[][] map, int size) {
        long[][] dp = new long[size][3];
        for(int i = 0; i < size; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        
        dp[0][1] = map[0][1];
        dp[0][2] = map[0][1] + map[0][2];
        
for(int i = 1; i < size; i++) {
    for(int j = 0; j < 3; j++) {
        if(j > 0) dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1] + map[i][j]);
        dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + map[i][j]);
        if(j < 2) dp[i][j] = Math.min(dp[i][j], dp[i-1][j+1] + map[i][j]);
        if(j > 0) dp[i][j] = Math.min(dp[i][j], dp[i][j-1] + map[i][j]);
    }
}

        return dp[size-1][1];
    }
}