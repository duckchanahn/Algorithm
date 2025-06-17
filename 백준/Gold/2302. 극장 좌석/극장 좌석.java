import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] dp = new int[41];
        int answer = 1;
        int prev = 0;

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        for(int i = 0; i < M; i++) {
            int vip = sc.nextInt();
            answer *= dp[vip - prev - 1];
            prev = vip;
        }

        answer *= dp[N - prev];
        System.out.println(answer);
    }
}