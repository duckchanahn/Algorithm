import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();

        if(n == 1) {
            System.out.println(1);
            return;
        }
        if(n == 2) {
            System.out.println(3);
            return;
        }
        
        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 3;
        
        for(int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] + (dp[i-2] * 2)) % 10007;
        }
        
        System.out.println(dp[n]);
    }
}