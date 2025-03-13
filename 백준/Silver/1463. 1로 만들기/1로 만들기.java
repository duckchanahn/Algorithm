import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        boolean[] memo = new boolean[X+1];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {X, 0});
        while(!q.isEmpty()) {
            int[] now = q.poll();
            if(now[0] == 1) {
                System.out.println(now[1]);
                break;
            }
            if(memo[now[0]]) continue;
            memo[now[0]] = true;

            if(now[0] % 3 == 0) q.add(new int[] {now[0] / 3, now[1] + 1});
            if(now[0] % 2 == 0) q.add(new int[] {now[0] / 2, now[1] + 1});
            q.add(new int[] {now[0] -1, now[1] + 1});
        }
    }


}