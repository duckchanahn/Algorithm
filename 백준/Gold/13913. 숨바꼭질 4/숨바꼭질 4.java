import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (n == k) {
            System.out.println(0);
            System.out.println(n);
            return;
        }

        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[200_001];
        int[] parent = new int[200_001];

        Arrays.fill(parent, -1);
        q.offer(new int[]{n, 0});
        visited[n] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int pos = current[0];
            int time = current[1];

            int[] nextPositions = {pos - 1, pos + 1, pos * 2};

            for (int next : nextPositions) {
                if (next >= 0 && next <= 200_000 && !visited[next]) {
                    visited[next] = true;
                    parent[next] = pos;
                    q.offer(new int[]{next, time + 1});

                    if (next == k) {
                        System.out.println(time + 1);

                        List<Integer> path = new ArrayList<>();
                        int current_pos = k;
                        while (current_pos != -1) {
                            path.add(current_pos);
                            current_pos = parent[current_pos];
                        }

                        Collections.reverse(path);

                        for (int i = 0; i < path.size(); i++) {
                            System.out.print(path.get(i));
                            if (i < path.size() - 1) {
                                System.out.print(" ");
                            }
                        }
                        System.out.println();
                        return;
                    }
                }
            }
        }
    }
}
