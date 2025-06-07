import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        int[] map = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] max = new int[size][2];
        max[0][0] = map[0];  // 합
        max[0][1] = map[0];  // 마지막 값

        for(int i = 1; i < size; i++) {
            max[i][0] = map[i];  // 자기 자신만으로 수열을 만드는 경우로 초기화
            max[i][1] = map[i];
            
            for(int j = 0; j < i; j++) {
                if(max[j][1] < map[i]) {  // 증가하는 조건
                    if(max[j][0] + map[i] > max[i][0]) {  // 더 큰 합인 경우만 업데이트
                        max[i][0] = max[j][0] + map[i];
                        max[i][1] = map[i];
                    }
                }
            }
        }

        int answer = 0;
        for(int i = 0; i < size; i++) {
            answer = Math.max(answer, max[i][0]);
        }

        System.out.println(answer);
    }
}