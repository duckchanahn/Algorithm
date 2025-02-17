import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int N;
    static int count = 0;
    static int[] board;  // 각 행에 퀸이 위치한 열을 저장
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N];
        
        nQueen(0);
        System.out.println(count);
    }
    
    // row: 현재 확인하고 있는 행
    static void nQueen(int row) {
        // 모든 행에 퀸을 놓는데 성공한 경우
        if (row == N) {
            count++;
            return;
        }
        
        // 현재 행의 각 열에 퀸을 놓아보며 가능한 경우를 탐색
        for (int col = 0; col < N; col++) {
            board[row] = col;  // 현재 행의 col 위치에 퀸을 놓음
            
            if (isValid(row)) {  // 유효한 위치인지 확인
                nQueen(row + 1);  // 다음 행으로 이동
            }
        }
    }
    
    // 현재까지 놓은 퀸들이 서로 공격할 수 없는 위치인지 확인
    static boolean isValid(int row) {
        for (int i = 0; i < row; i++) {
            // 같은 열에 있는 경우
            if (board[row] == board[i]) {
                return false;
            }
            
            // 대각선상에 있는 경우
            // 행의 차이와 열의 차이가 같으면 대각선에 위치
            if (Math.abs(row - i) == Math.abs(board[row] - board[i])) {
                return false;
            }
        }
        return true;
    }
}