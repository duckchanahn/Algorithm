import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            
            Deque<Integer> deque = new ArrayDeque<>();
            String str = br.readLine();
            if(n > 0) {
                String[] arr = str.substring(1, str.length()-1).split(",");
                for(String s : arr) {
                    deque.add(Integer.parseInt(s));
                }
            }
            
            process(p, deque, sb);
        }
        System.out.print(sb);
    }
    
    private static void process(String commands, Deque<Integer> deque, StringBuilder sb) {
        boolean isReverse = false;
        
        for(char cmd : commands.toCharArray()) {
            if(cmd == 'R') {
                isReverse = !isReverse;
            } else if(deque.isEmpty()) {
                sb.append("error\n");
                return;
            } else {
                if(isReverse) deque.pollLast();
                else deque.pollFirst();
            }
        }
        
        makeString(deque, isReverse, sb);
    }
    
    private static void makeString(Deque<Integer> deque, boolean isReverse, StringBuilder sb) {
        sb.append('[');
        if(!deque.isEmpty()) {
            if(isReverse) {
                sb.append(deque.pollLast());
                while(!deque.isEmpty()) {
                    sb.append(',').append(deque.pollLast());
                }
            } else {
                sb.append(deque.pollFirst());
                while(!deque.isEmpty()) {
                    sb.append(',').append(deque.pollFirst());
                }
            }
        }
        sb.append("]\n");
    }
}