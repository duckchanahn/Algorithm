import java.io.*;
import java.util.*;

public class Main {

    static List<LinkedList<Integer>> tobni = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            tobni.add(new LinkedList<>());
            for (char c : br.readLine().toCharArray()) {
                tobni.get(i).add(c - '0');
            }
        }

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken());

            visited = new boolean[4];
            rotate(index, direction);
        }

        int sum = 0;
        sum += tobni.get(0).getFirst();
        sum += tobni.get(1).getFirst() * 2;
        sum += tobni.get(2).getFirst() * 4;
        sum += tobni.get(3).getFirst() * 8;

        System.out.println(sum);
    }

    /*
     * 점수 구하는 건 필요 없고
     * 톱니바퀴 돌리는 거 (시계방향1 >, 반시계방향-1 <)
     * 돌리면 양옆도 돌려야함!-> 재귀로 ?
     */
    // 톱니바퀴 회전 처리
    static void rotate(int index, int direction) {
        visited[index] = true;

        // 왼쪽 톱니바퀴 확인
        if(index > 0 && !visited[index-1]) {
            // 현재 톱니의 6번과 왼쪽 톱니의 2번을 비교
            if(tobni.get(index).get(6) != tobni.get(index-1).get(2)) {
                rotate(index-1, -direction);
            }
        }

        // 오른쪽 톱니바퀴 확인
        if(index < 3 && !visited[index+1]) {
            // 현재 톱니의 2번과 오른쪽 톱니의 6번을 비교
            if(tobni.get(index).get(2) != tobni.get(index+1).get(6)) {
                rotate(index+1, -direction);
            }
        }

        // 현재 톱니바퀴 회전
        if(direction == 1) { // 시계 방향
            tobni.get(index).addFirst(tobni.get(index).removeLast());
        } else { // 반시계 방향
            tobni.get(index).addLast(tobni.get(index).removeFirst());
        }
    }
}