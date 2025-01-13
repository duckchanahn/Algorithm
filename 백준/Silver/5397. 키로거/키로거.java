// 시간복잡도: O(N) - N은 입력 문자열의 길이

import java.io.*;
import java.util.Stack;

public class Main {
    public static String getPassword(String input) {
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        
        for(char c : input.toCharArray()) {
            switch(c) {
                case '<':
                    if(!left.empty()) {
                        right.push(left.pop());
                    }
                    break;
                case '>':
                    if(!right.empty()) {
                        left.push(right.pop());
                    }
                    break;
                case '-':
                    if(!left.empty()) {
                        left.pop();
                    }
                    break;
                default:
                    left.push(c);
                    break;
            }
        }
        
        while(!left.empty()) {
            right.push(left.pop());
        }
        
        StringBuilder sb = new StringBuilder();
        while(!right.empty()) {
            sb.append(right.pop());
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0) {
            String input = br.readLine();
            bw.write(getPassword(input) + "\n");
        }
        
        bw.flush();
        bw.close();
    }
}