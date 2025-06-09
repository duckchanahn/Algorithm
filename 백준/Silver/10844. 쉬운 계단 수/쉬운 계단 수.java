import java.util.*;

public class Main {
    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt();

        long[][] dp = new long[N + 1][10];
        for(int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for(int i = 2; i <= N; i++) {
            for(int j = 0; j <= 9; j++) {
                if(j > 0) dp[i][j] = (dp[i][j] + dp[i-1][j-1]) % 1_000_000_000;
                if(j < 9) dp[i][j] = (dp[i][j] + dp[i-1][j+1]) % 1_000_000_000;
            }
        }

        long answer = 0;
        for(int i = 0; i <= 9; i++) {
            answer += dp[N][i];
            answer %= 1000000000;
        }

        System.out.println(answer);
    }
}