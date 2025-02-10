import java.io.*;

public class Main {
    static int[][] image;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        image = new int[N][N];
        
        // 이미지 정보 입력 받기
        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < N; j++) {
                image[i][j] = line.charAt(j) - '0';
            }
        }
        
        quadTree(0, 0, N);
        System.out.println(sb.toString());
    }
    
    // 쿼드트리 압축 메서드
    static void quadTree(int row, int col, int size) {
        // 현재 영역이 모두 같은 값인지 확인
        if(checkArea(row, col, size)) {
            sb.append(image[row][col]);
            return;
        }
        
        // 4분할해야 하는 경우 괄호로 시작
        sb.append('(');
        
        int newSize = size / 2;
        quadTree(row, col, newSize);                       // 왼쪽 위
        quadTree(row, col + newSize, newSize);            // 오른쪽 위
        quadTree(row + newSize, col, newSize);            // 왼쪽 아래
        quadTree(row + newSize, col + newSize, newSize);  // 오른쪽 아래
        
        // 4분할 영역 압축 완료 후 괄호 닫기
        sb.append(')');
    }
    
    // 현재 영역이 모두 같은 값인지 확인하는 메서드
    static boolean checkArea(int row, int col, int size) {
        int value = image[row][col];
        
        for(int i = row; i < row + size; i++) {
            for(int j = col; j < col + size; j++) {
                if(image[i][j] != value) {
                    return false;
                }
            }
        }
        return true;
    }
}