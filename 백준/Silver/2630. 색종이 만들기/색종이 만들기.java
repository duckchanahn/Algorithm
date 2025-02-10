import java.io.*;
import java.util.*;

public class Main {
    static int[][] paper;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        paper = new int[N][N];

        // 색종이 정보 입력 받기
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, N);

        // 결과 출력
        System.out.println(white);
        System.out.println(blue);
    }

    // 분할 정복 메서드
    static void partition(int row, int col, int size) {
        // 현재 영역이 모두 같은 색인지 확인
        if(checkColor(row, col, size)) {
            if(paper[row][col] == 0) white++;
            else blue++;
            return;
        }

        // 4등분으로 나누어 재귀 호출
        int newSize = size / 2;
        partition(row, col, newSize);                       // 왼쪽 위
        partition(row, col + newSize, newSize);            // 오른쪽 위
        partition(row + newSize, col, newSize);            // 왼쪽 아래
        partition(row + newSize, col + newSize, newSize);  // 오른쪽 아래
    }

    // 현재 영역이 모두 같은 색인지 확인하는 메서드
    static boolean checkColor(int row, int col, int size) {
        int color = paper[row][col];

        for(int i = row; i < row + size; i++) {
            for(int j = col; j < col + size; j++) {
                if(paper[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}