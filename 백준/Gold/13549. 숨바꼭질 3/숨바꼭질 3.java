import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        if(N == K) {
            System.out.println(0);
            return;
        }
        
        Deque<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[100_001];
        q.add(new int[] {N, 0});
        visited[N] = true;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            if(now[0] == K) {
                System.out.println(now[1]);
                return;
            }

            if(now[0] * 2 <= 100_000 && !visited[now[0] * 2]) {
                visited[now[0] * 2] = true;
                q.offerFirst(new int[] {now[0] * 2, now[1]});
            }

            int[] next = new int[] {now[0] - 1, now[0] + 1};
            for(int i : next) {
                if(0 <= i && i <= 100_000 && !visited[i]) {
                    visited[i] = true;
                    q.offerLast(new int[] {i, now[1] + 1});
                }
            }
        }
    }
}