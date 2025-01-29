
import java.util.*;
import java.io.*;

public class Main {
    /*
    아니면 ( : push / ) : 아래 확인하고 아니면 count += 1;
    이전 괄호를 저장하고 () 완성이면 stack.pop(); count += size;
     */
    public static void main(String[] args) throws IOException {
        String line = new BufferedReader(new InputStreamReader(System.in)).readLine();
        Stack<Character> stack = new Stack<>();
        int count = 0;
        char prev = 'p';
        for(char c : line.toCharArray()) {
            if(c == '(') {
                stack.push(c);
            } else {
                if(prev == '(') {
                    stack.pop();
                    count += stack.size();
                } else {
                    stack.pop();
                    count += 1;
                }
            }
            prev = c;
        }
        
        System.out.println(count);
    }


}
