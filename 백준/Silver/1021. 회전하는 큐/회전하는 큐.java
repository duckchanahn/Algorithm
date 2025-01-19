import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        LinkedList<Integer> deque = new LinkedList<>();
        int count = 0;
        
        for(int i = 1; i <= N; i++) {
            deque.offer(i);
        }
        
        st = new StringTokenizer(br.readLine());
        
        while(M-- > 0) {
            int target = Integer.parseInt(st.nextToken());
            int targetIdx = deque.indexOf(target);
            int half = deque.size() / 2;
            
            if(targetIdx <= half) {
                for(int i = 0; i < targetIdx; i++) {
                    deque.offerLast(deque.pollFirst());
                    count++;
                }
            }
            else {
                for(int i = 0; i < deque.size() - targetIdx; i++) {
                    deque.offerFirst(deque.pollLast());
                    count++;
                }
            }
            deque.pollFirst();
        }
        
        System.out.println(count);
    }
}