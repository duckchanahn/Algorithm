import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int F = sc.nextInt(); // 최대높이
        int S = sc.nextInt(); // 강호 위치
        int G = sc.nextInt(); // 목적지
        int U = sc.nextInt(); // 업버튼
        int D = sc.nextInt(); // 다운버튼

        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[F + 1];
        q.add(new int[] {S, 0});
        visited[S] = true;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            if(now[0] == G) {
                System.out.println(now[1]);
                return;
            }


            if(now[0] + U <= F && !visited[now[0] + U]) {
                q.add(new int[] {now[0] + U, now[1] + 1});
                visited[now[0] + U] = true;
            }

            if(0 < now[0] - D && !visited[now[0] - D]) {
                q.add(new int[] {now[0] - D, now[1] + 1});
                visited[now[0] - D] = true;
            }
        }

        System.out.println("use the stairs");
    }
}