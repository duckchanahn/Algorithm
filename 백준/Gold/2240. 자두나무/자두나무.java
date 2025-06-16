import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] map = new int[T+1];
        for(int i = 1; i <= T; i++) {
            map[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[T+1][W+1];

        for(int i = 1; i <= T; i++) {
            for(int j = 0; j <= W; j++) {

                if(j > 0) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }

                //0 2 4 = 1
                if((j % 2 == 0 && map[i] == 1) || (j % 2 == 1 && map[i] == 2)) {
                    dp[i][j] += 1;
                }
            }
        }

        int answer = 0;
        for(int i = 0; i <= W; i++) {
            answer = Math.max(answer, dp[T][i]);
        }

        System.out.println(answer);
    }
}