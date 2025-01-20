import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        Stack<Long> stack = new Stack<>();
        long answer = 0;
        
        for(int i = 0; i < n; i++) {
            long height = Long.parseLong(br.readLine());
            
            while(!stack.isEmpty() && stack.peek() <= height) {
                stack.pop();
            }
            
            answer += stack.size();
            stack.push(height);
        }
        
        System.out.println(answer);
    }
}