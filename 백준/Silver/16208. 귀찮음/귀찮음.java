import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        Queue<Long> q = new ArrayDeque<>();
        for(int i = 0; i < size; i++) {
            q.add(Long.parseLong(st.nextToken()));
        }
        
        long answer = 0;
        while(q.size() > 1) {
            long fir = q.poll();
            long sec = q.poll();
            q.add(fir + sec);
            answer += (fir * sec);
        }
        
        System.out.println(answer);
    }
}