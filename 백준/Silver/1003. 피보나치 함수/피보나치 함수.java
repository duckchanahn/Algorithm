import java.io.*;

public class Main {
    private static int[][] memo; 

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        memo = new int[41][2];

        memo[0][0] = 1; memo[0][1] = 0;
        memo[1][0] = 0; memo[1][1] = 1;
        
        for (int i = 2; i <= 40; i++) {
            memo[i][0] = memo[i-1][0] + memo[i-2][0];
            memo[i][1] = memo[i-1][1] + memo[i-2][1];
        }
        
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(memo[n][0] + " " + memo[n][1]);
        }
    }
}