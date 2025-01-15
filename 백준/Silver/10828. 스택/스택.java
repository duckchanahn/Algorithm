import java.util.*;
import java.io.*;

public class Main {
    private static void execute(String line, Stack<Integer> stack) {
        String[] command = line.split(" ");
        
        switch(command[0]) {
            case "push":
                stack.push(Integer.parseInt(command[1]));
                break;
            case "pop":
                System.out.println(stack.empty() ? -1 : stack.pop());
                break;
            case "size":
                System.out.println(stack.size());
                break;
            case "empty":
                System.out.println(stack.empty() ? 1 : 0);
                break;
            case "top":
                System.out.println(stack.empty() ? -1 : stack.peek());
                break;
        }
    }
    
    public static void main(String args[]) throws IOException {
        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            execute(br.readLine(), stack);
        }
    }
}