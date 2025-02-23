import java.util.*;

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

/*
    최악의 경우 계산:
    
    N = 50 (도시 크기)
    M = 13 (선택할 수 있는 최대 치킨집 수)
    치킨집 수 = 13 (문제 제약조건)
    집의 수(H) = 2N = 100 (문제 제약조건: 2N을 넘지 않음)
    
    조합 수 계산 (¹³Cₘ):
    
    13개 중 13개를 고르는 경우: ¹³C₁₃ = 1
    13개 중 12개를 고르는 경우: ¹³C₁₂ = 13
    13개 중 11개를 고르는 경우: ¹³C₁₁ = 78
    ...
    13개 중 1개를 고르는 경우: ¹³C₁ = 13
    
    전체 시간 복잡도:
    O(¹³Cₘ * H * M)
    = O(최대 조합 수 * 최대 집 수 * 최대 선택 치킨집 수)
    = O(78 * 100 * 13)  // ¹³C₁₁이 가장 큰 조합 수
    = O(101,400)
    
    => 보통 자바에서 1초에 1억번 연산이 가능하다고 했으니까 완전탐색 + 조합 문제 ! 
 */


public class Main {
    static int N, M;
    static ArrayList<Point> houses = new ArrayList<>();
    static ArrayList<Point> chickens = new ArrayList<>();
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        // 집과 치킨집 위치 저장
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                int value = sc.nextInt();
                if(value == 1) {
                    houses.add(new Point(i, j));
                } else if(value == 2) {
                    chickens.add(new Point(i, j));
                }
            }
        }

        visited = new boolean[chickens.size()];
        // M개의 치킨집 선택
        selectChicken(0, 0);

        System.out.println(answer);
    }

    // 치킨집 M개 선택하는 조합 함수
    static void selectChicken(int start, int count) {
        if(count == M) {
            // 선택된 치킨집으로 도시의 치킨 거리 계산
            answer = Math.min(answer, getChickenDistance());
            return;
        }

        for(int i = start; i < chickens.size(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                selectChicken(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }

    // 도시의 치킨 거리 계산
    static int getChickenDistance() {
        int totalDistance = 0;

        for(Point house : houses) {
            int minDistance = Integer.MAX_VALUE;
            for(int i = 0; i < chickens.size(); i++) {
                if(visited[i]) {
                    Point chicken = chickens.get(i);
                    int distance = Math.abs(house.x - chicken.x) +
                            Math.abs(house.y - chicken.y);
                    minDistance = Math.min(minDistance, distance);
                }
            }
            totalDistance += minDistance;
        }

        return totalDistance;
    }
}