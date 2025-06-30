import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int MAX = 100001;
        Deque<int[]> dq = new ArrayDeque<>();
        int[] dist = new int[MAX];
        Arrays.fill(dist, -1);

        dq.offer(new int[]{N, 0});
        dist[N] = 0;

        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int pos = cur[0];
            int time = cur[1];

            if (pos == K) {
                System.out.println(time);
                return;
            }

            if (pos * 2 < MAX && dist[pos * 2] == -1) {
                dist[pos * 2] = time;
                dq.offerFirst(new int[]{pos * 2, time});
            }

            for (int next : new int[]{pos - 1, pos + 1}) {
                if (next >= 0 && next < MAX && dist[next] == -1) {
                    dist[next] = time + 1;
                    dq.offerLast(new int[]{next, time + 1});
                }
            }
        }
    }
}
