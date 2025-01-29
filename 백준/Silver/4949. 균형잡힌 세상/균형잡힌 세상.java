import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while(!(line = br.readLine()).equals("."))
            System.out.println(checkRule(line));

        br.close();
    }

    private static String checkRule(String line) {
        Stack<Character> stack = new Stack<>();

        for(char c : line.toCharArray()) {
            switch (c) {
                case '(':
                    stack.push(c);
                    break;
                case ')':
                    if(stack.isEmpty() || stack.pop() != '(') return "no";
                    break;
                case '[':
                    stack.push(c);
                    break;
                case ']':
                    if(stack.isEmpty() || stack.pop() != '[') return "no";
                    break;
            }
        }

        return stack.isEmpty() ? "yes" : "no";
    }
}
