import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        boolean[] visited = new boolean[N + 1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        int count = 0;
        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                bfs(graph, visited, i);
                count++;
            }
        }
        System.out.println(count);
    }

    private static void bfs(ArrayList<Integer>[] graph, boolean[] visit, int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visit[start] = true;

        while(!q.isEmpty()) {
            int now = q.poll();

            for(int next : graph[now]) {
                if(!visit[next]) {
                    q.offer(next);
                    visit[next] = true;
                }
            }
        }
    }
}