import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < size; i++) {
            int number = Integer.parseInt(br.readLine());
            if(number == 0 && !stack.empty()) {
                stack.pop();
            } else if(number != 0) {
                stack.push(number);
            }
        }
        
        System.out.println(stack.stream().mapToInt(Integer::intValue).sum());
    }
}