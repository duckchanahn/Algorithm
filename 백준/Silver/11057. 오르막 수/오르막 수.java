import java.util.*;

public class Main {
    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt();

        int[][] dp = new int[N][10];
        Arrays.fill(dp[0], 1);

        for(int i = 1; i < N; i++) {
            for(int j = 0; j <= 9; j++) {
                for(int k = 0; k <= j; k++) {
                    dp[i][j] = (dp[i][j] + dp[i-1][k]) % 10_007;
                }
            }
        }

        int result = 0;
        for(int j = 0; j <= 9; j++) {
            result = (result + dp[N-1][j]) % 10_007;
        }
        System.out.println(result);
    }
}