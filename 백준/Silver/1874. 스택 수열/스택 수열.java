import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        int[] sequence = new int[n];
        
        // 입력받은 수열 저장
        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(br.readLine());
        }
        
        Stack<Integer> stack = new Stack<>();
        ArrayList<String> operations = new ArrayList<>();
        
        int num = 1; // 스택에 넣을 다음 숫자
        boolean possible = true;
        
        for (int i = 0; i < n; i++) {
            int target = sequence[i];
            
            // 현재 찾아야 하는 수가 스택에 넣을 수보다 크거나 같으면
            while (num <= target) {
                stack.push(num++);
                operations.add("+");
            }
            
            // 스택의 top이 찾는 수와 같으면 pop
            if (!stack.isEmpty() && stack.peek() == target) {
                stack.pop();
                operations.add("-");
            } else {
                possible = false;
                break;
            }
        }
        
        // 결과 출력
        if (possible) {
            for (String op : operations) {
                System.out.println(op);
            }
        } else {
            System.out.println("NO");
        }
    }
}