import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] graph = new ArrayList[size + 1];
        boolean[] visit = new boolean[size + 1];
        for(int i = 0; i <= size; i++) {
            graph[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());

            graph[one].add(two);
            graph[two].add(one);
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {first, 0});
        visit[first] = true;

        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int now = temp[0];
            int count = temp[1];

            if(now == second) {
                System.out.println(count);
                return;
            }

            for(int i : graph[now]) {
                if(!visit[i]) {
                    q.add(new int[] {i, count+1});
                    visit[i] = true;
                }
            }
        }
        System.out.println(-1);
    }
}