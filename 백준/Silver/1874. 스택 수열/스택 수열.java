import java.io.*;
import java.util.Stack;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        
        // 입력받은 수열을 저장할 배열
        int[] sequence = new int[n];
        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(br.readLine());
        }
        
        Stack<Integer> stack = new Stack<>();
        ArrayList<Character> operations = new ArrayList<>();
        
        int num = 1; // 스택에 넣을 다음 숫자
        boolean isPossible = true;
        
        for (int i = 0; i < n; i++) {
            int target = sequence[i];
            
            // 목표 숫자가 현재 넣을 숫자보다 크거나 같으면
            while (num <= target) {
                stack.push(num++);
                operations.add('+');
            }
            
            // 스택의 top이 목표 숫자와 같은지 확인
            if (!stack.isEmpty() && stack.peek() == target) {
                stack.pop();
                operations.add('-');
            } else {
                isPossible = false;
                break;
            }
        }
        
        // 결과 출력
        if (isPossible) {
            for (char op : operations) {
                sb.append(op).append('\n');
            }
        } else {
            sb.append("NO");
        }
        
        System.out.print(sb);
        br.close();
    }
}