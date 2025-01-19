import java.util.*;
import java.io.*;

public class Main {
    private static void execute(String line, Queue<Integer> queue) {
        String[] command = line.split(" ");
        
        switch(command[0]) {
            case "push":
                queue.offer(Integer.parseInt(command[1]));
                break;
            case "pop":
                System.out.println(queue.isEmpty() ? -1 : queue.poll());
                break;
            case "size":
                System.out.println(queue.size());
                break;
            case "empty":
                System.out.println(queue.isEmpty() ? 1 : 0);
                break;
            case "front":
                System.out.println(queue.isEmpty() ? -1 : queue.peek());
                break;
            case "back":
                // LinkedList를 사용하여 마지막 요소에 접근
                System.out.println(queue.isEmpty() ? -1 : ((LinkedList<Integer>)queue).getLast());
                break;
        }
    }
    
    public static void main(String args[]) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            execute(br.readLine(), queue);
        }
    }
}