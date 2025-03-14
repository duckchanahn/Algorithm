import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());            
            switch(st.nextToken()) {
                case "1":
                    stack.add(Integer.parseInt(st.nextToken()));
                    break;
                case "2":
                    System.out.println(
                        stack.isEmpty() ? -1 : stack.pop()
                    );
                    break;
                case "3":
                    System.out.println(
                        stack.size()
                    );
                    break;
                case "4":
                    System.out.println(
                        stack.isEmpty() ? 1 : 0
                    );
                    break;
                case "5":
                    System.out.println(
                        stack.isEmpty() ? -1 : stack.peek()
                    );
                    break;
            }
        }

        
    }
}