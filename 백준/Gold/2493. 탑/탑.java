import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] towers = new int[n];
        int[] result = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            towers[i] = Integer.parseInt(st.nextToken());
        }
        
        Stack<int[]> stack = new Stack<>();
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && stack.peek()[1] < towers[i]) {
                stack.pop();
            }
            
            if(!stack.isEmpty()) {
                result[i] = stack.peek()[0] + 1;
            }
            
            stack.push(new int[]{i, towers[i]});
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }
}