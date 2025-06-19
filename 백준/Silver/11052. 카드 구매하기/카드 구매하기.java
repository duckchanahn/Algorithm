import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] map = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] dp = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            dp[i] = map[i-1];
            for(int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[j] + map[i-j-1], dp[i]);
            }
        }

        System.out.println(dp[N]);
    }
}