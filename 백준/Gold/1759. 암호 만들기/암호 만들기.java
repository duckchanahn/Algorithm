import java.io.*;
import java.util.*;

public class Main {
    static int L, C;
    static char[] chars;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        chars = br.readLine().replaceAll(" ", "").toCharArray();
        Arrays.sort(chars);

        make(0, 0, new StringBuilder());
        System.out.println(answer.toString());
    }

    static void make(int index, int start, StringBuilder sb) {
        if(index == L) {
            if(valid(sb)) {
                answer.append(sb.toString()).append('\n');
            }
            return;
        }

        for(int i = start; i < C; i++) {
            sb.append(chars[i]);
            make(index + 1, i + 1, sb);
            sb.setLength(sb.length() - 1);  // 마지막 문자 제거
        }
    }

    static boolean valid(StringBuilder sb) {
        int aeiou = 0;  // 모음 개수
        int bcdfg = 0;  // 자음 개수

        for(int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                aeiou++;
            } else {
                bcdfg++;
            }
        }

        return aeiou >= 1 && bcdfg >= 2;
    }
}