import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        System.out.println(findZIterative(N, r, c));
    }
    
    static long findZIterative(int N, int r, int c) {
        long answer = 0;
        int size = 1 << N; // 전체 크기
        
        while (size > 1) {
            size /= 2;
            
            // 현재 위치의 사분면 확인 및 값 누적
            if (r < size) {
                if (c < size) {
                    // 1사분면: 아무것도 더하지 않음
                } else {
                    // 2사분면
                    answer += size * size;
                    c -= size;
                }
            } else {
                if (c < size) {
                    // 3사분면
                    answer += 2 * size * size;
                    r -= size;
                } else {
                    // 4사분면
                    answer += 3 * size * size;
                    r -= size;
                    c -= size;
                }
            }
        }
        
        return answer;
    }
}