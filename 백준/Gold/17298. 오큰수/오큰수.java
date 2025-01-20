import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];  // 원본 배열 저장
        int[] result = new int[n];  // 결과 배열
        Arrays.fill(result, -1);  // 결과를 모두 -1로 초기화

        // 입력값을 배열에 저장
        String[] tokens = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tokens[i]);
        }

        // 인덱스를 저장할 스택
        Stack<Integer> stack = new Stack<>();

        // 왼쪽부터 순회하면서 오큰수 찾기
        for(int i = 0; i < n; i++) {
            // 스택이 비어있지 않고 현재 값이 스택 top의 값보다 크면
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                result[stack.pop()] = arr[i];  // 오큰수를 찾았으므로 결과 배열에 저장
            }
            stack.push(i);  // 현재 인덱스를 스택에 추가
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }
}