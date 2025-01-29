import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        for(int i = 0; i < size; i++) {
            System.out.println(checkVPS(br.readLine()));
        }

        br.close();
    }

    private static String checkVPS(String line) {
        Stack<Character> stack = new Stack<>();
        for(char c : line.toCharArray()) {
            if(stack.isEmpty()) {
                stack.push(c);
            } else {
                if(c == '(') {
                    stack.push(c);
                } else {
                    if(stack.peek() != '(') {
                        return "NO";
                    } else {
                        stack.pop();
                    }
                }
            }
        }
        return stack.isEmpty() ? "YES" : "NO";
    }

}
