import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int size = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        
        boolean[] computers = new boolean[size + 1];
        
        StringTokenizer st;
        int[][] lines = new int[T][2];
        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            lines[i][0] = Integer.parseInt(st.nextToken());
            lines[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        computers[1] = true;
        while(!q.isEmpty()) {
            int now = q.poll();
            
            for(int i = 0; i < T; i++) {
                if((lines[i][0] == now) && !computers[lines[i][1]]) {
                    q.add(lines[i][1]);
                    computers[lines[i][1]] = true;
                    answer++;
                } else if((lines[i][1] == now) && !computers[lines[i][0]]) {
                    q.add(lines[i][0]);
                    computers[lines[i][0]] = true;
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}