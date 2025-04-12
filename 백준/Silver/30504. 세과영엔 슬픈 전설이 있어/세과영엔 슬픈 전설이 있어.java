import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    
    static class Day implements Comparable<Day> {
        int index, required;
        public Day(int index, int required) {
            this.index = index;
            this.required = required;
        }
        public int compareTo(Day other) {
            return Integer.compare(this.required, other.required);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        
        // A 배열: 각 날짜의 최소 요구 금액과 원래 인덱스 저장
        Day[] days = new Day[n];
        StringTokenizer stA = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            days[i] = new Day(i, Integer.parseInt(stA.nextToken()));
        }
        
        // B 배열: 영재가 준비한 자루 금액
        int[] bags = new int[n];
        StringTokenizer stB = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            bags[i] = Integer.parseInt(stB.nextToken());
        }
        
        // 오름차순 정렬
        Arrays.sort(days);
        Arrays.sort(bags);
        
        int[] answer = new int[n];  // answer[i]: i번째 날 지급할 금액
        
        // 그리디 매칭: i번째(정렬된) day에 대해서,
        // bags[i]가 days[i].required 이상이어야 함.
        boolean possible = true;
        for (int i = 0; i < n; i++) {
            if (bags[i] < days[i].required) {
                possible = false;
                break;
            }
            // days[i].index: 원래 날짜 인덱스
            answer[days[i].index] = bags[i];
        }
        
        if (!possible) {
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            for (int a : answer) {
                sb.append(a).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }
}
