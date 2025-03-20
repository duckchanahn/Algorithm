import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] stairs = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
        
        int[][] dp = new int[n + 1][3];
        
        if (n >= 1) {
            dp[1][1] = stairs[1];
        }
        
        for (int i = 2; i <= n; i++) {
            dp[i][1] = Math.max(dp[i-2][1], dp[i-2][2]) + stairs[i];
            
            dp[i][2] = dp[i-1][1] + stairs[i];
        }
        
        System.out.println(Math.max(dp[n][1], dp[n][2]));
    }
}