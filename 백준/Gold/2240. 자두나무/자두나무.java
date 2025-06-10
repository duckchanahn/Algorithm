import java.util.*;
import java.io.*;

public class Main {
    static int T, W;
    static int[] fruits;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력 처리
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        fruits = new int[T + 1];  // 1초부터 T초까지
        for (int i = 1; i <= T; i++) {
            fruits[i] = Integer.parseInt(br.readLine());  // 1 또는 2
        }

        // DP 테이블 초기화
        dp = new int[T + 1][W + 1];

        // DP 수행
        for (int t = 1; t <= T; t++) {
            for (int w = 0; w <= W; w++) {
                // 이전 상태 유지
                dp[t][w] = dp[t - 1][w];

                // 이동이 가능한 경우
                if (w > 0) {
                    dp[t][w] = Math.max(dp[t][w], dp[t - 1][w - 1]);
                }

                // 현재 위치가 자두 떨어지는 위치와 같으면 +1
                int currTree = (w % 2 == 0) ? 1 : 2;
                if (fruits[t] == currTree) {
                    dp[t][w]++;
                }
            }
        }

        // 정답: T초 동안 w번 이동했을 때의 최대값
        int answer = 0;
        for (int w = 0; w <= W; w++) {
            answer = Math.max(answer, dp[T][w]);
        }

        System.out.println(answer);
    }
}
