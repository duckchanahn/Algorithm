import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < size; i++) {
            q.add(Integer.parseInt(st.nextToken()));
        }
        
        int answer = 0;
        while(q.size() > 1) {
            int fir = q.poll();
            int sec = q.poll();
            q.add(fir + sec);
            answer += (fir * sec);
        }
        
        System.out.println(answer);
    }
}