import java.util.*;
import java.io.*;

public class Main {
    static int[] students;
    static boolean[] visited;
    static boolean[] finished;
    static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            students = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                students[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    dfs(i);
                }
            }

            System.out.println(n - count);  // 팀 못 이룬 학생 수
        }
    }

    private static void dfs(int current) {
        visited[current] = true;
        int next = students[current];

        if (!visited[next]) {
            dfs(next);
        } else if (!finished[next]) {
            // 사이클 발견!
            for (int i = next; i != current; i = students[i]) {
                count++;
            }
            count++; // 현재 노드도 포함
        }

        finished[current] = true;
    }
}
