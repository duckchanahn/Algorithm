import java.io.*;
import java.util.*;

public class Main{
public static void main(String[] args) {
    int n = new Scanner(System.in).nextInt();

    if(n == 1) {
        System.out.println(0);
        System.out.println("1");
        return;
    }

    int[] dp = new int[n + 1];
    dp[1] = 0;

    int[] prev = new int[n + 1];
    prev[1] = 0;

    for(int i = 2; i <= n; i++) {
        dp[i] = dp[i-1] + 1;
        prev[i] = i-1;

        if(i % 2 == 0 && dp[i/2] + 1 < dp[i]) {
            dp[i] = dp[i/2] + 1;
            prev[i] = i / 2;
        }

        if(i % 3 == 0 && dp[i/3] + 1 < dp[i]) {
            dp[i] = dp[i/3] + 1;
            prev[i] = i / 3;
        }
    }

    System.out.println(dp[n]);
    StringBuilder sb = new StringBuilder();

    while(n >= 1) {
        sb.append(n).append(" ");
        n = prev[n];
    }

    System.out.println(sb.toString());
}
}