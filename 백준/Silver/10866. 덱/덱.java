import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        Deque<Integer> deque = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < N; i++) {
            String[] command = br.readLine().split(" ");
            
            switch(command[0]) {
                case "push_front":
                    deque.offerFirst(Integer.parseInt(command[1]));
                    break;
                    
                case "push_back":
                    deque.offerLast(Integer.parseInt(command[1]));
                    break;
                    
                case "pop_front":
                    bw.write(String.valueOf(deque.isEmpty() ? -1 : deque.pollFirst()) + "\n");
                    break;
                    
                case "pop_back":
                    bw.write(String.valueOf(deque.isEmpty() ? -1 : deque.pollLast()) + "\n");
                    break;
                    
                case "size":
                    bw.write(String.valueOf(deque.size()) + "\n");
                    break;
                    
                case "empty":
                    bw.write(String.valueOf(deque.isEmpty() ? 1 : 0) + "\n");
                    break;
                    
                case "front":
                    bw.write(String.valueOf(deque.isEmpty() ? -1 : deque.peekFirst()) + "\n");
                    break;
                    
                case "back":
                    bw.write(String.valueOf(deque.isEmpty() ? -1 : deque.peekLast()) + "\n");
                    break;
            }
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}