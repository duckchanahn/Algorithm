import java.util.*;
import java.io.*;

public class Main {
    private static Map<Integer, Long> memo = new HashMap<>();
    private static final int MOD = 1_000_000_009;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        int maxN = 0;
        int[] queries = new int[T];
        
        // 모든 쿼리를 읽고 최대값 찾기
        for(int i = 0; i < T; i++) {
            queries[i] = Integer.parseInt(br.readLine());
            maxN = Math.max(maxN, queries[i]);
        }
        
        // 최대값까지만 계산
        precompute(maxN);
        
        // 결과 출력
        for(int query : queries) {
            System.out.println(memo.get(query));
        }
    }
    
    private static void precompute(int maxN) {
        memo.put(0, 1L);
        memo.put(1, 1L);
        memo.put(2, 2L);
        memo.put(3, 4L);
        
        for(int i = 4; i <= maxN; i++) {
            long result = (memo.get(i-3) + memo.get(i-2) + memo.get(i-1)) % MOD;
            memo.put(i, result);
        }
    }
}