import java.io.*;
import java.util.*;

public class Main {
    static class Myun {
        int value;
        public Myun() {
            this.value = 0;
        }
    }

    static Myun top = new Myun();     // 윗면
    static Myun bottom = new Myun();   // 밑면
    static Myun front = new Myun();    // 앞면
    static Myun back = new Myun();     // 뒷면
    static Myun left = new Myun();     // 왼쪽면
    static Myun right = new Myun();    // 오른쪽면

    static int N, M;
    static int x, y;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        while(K-- > 0) {
            int dir = Integer.parseInt(st.nextToken());
            roll(dir);
        }
    }

    static void roll(int direction) {
        int nx = x, ny = y;

        // 다음 위치 계산
        if(direction == 1) ny++;      // 동
        else if(direction == 2) ny--; // 서
        else if(direction == 3) nx--; // 북
        else if(direction == 4) nx++; // 남

        // 범위 체크
        if(nx < 0 || nx >= N || ny < 0 || ny >= M) return;

        // 주사위 굴리기
        int temp;
        if(direction == 1) { // 동
            temp = right.value;
            right.value = top.value;
            top.value = left.value;
            left.value = bottom.value;
            bottom.value = temp;
        } else if(direction == 2) { // 서
            temp = left.value;
            left.value = top.value;
            top.value = right.value;
            right.value = bottom.value;
            bottom.value = temp;
        } else if(direction == 3) { // 북
            temp = back.value;
            back.value = top.value;
            top.value = front.value;
            front.value = bottom.value;
            bottom.value = temp;
        } else { // 남
            temp = front.value;
            front.value = top.value;
            top.value = back.value;
            back.value = bottom.value;
            bottom.value = temp;
        }

        // 좌표 이동
        x = nx;
        y = ny;

        // 맵 확인
        if(map[x][y] == 0) {
            map[x][y] = bottom.value;
        } else {
            bottom.value = map[x][y];
            map[x][y] = 0;
        }

        // 윗면 출력
        System.out.println(top.value);
    }
}