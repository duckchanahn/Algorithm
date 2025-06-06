import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        int[][] map = new int[size][size];
        int[][] max = new int[size][size];
        for(int i = 0; i < size; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        max[0][0] = map[0][0];
        for(int i = 1; i < size; i++) {
            max[i][0] = max[i-1][0] + map[i][0];
            max[i][i] = max[i-1][i-1] + map[i][i];
            for(int j = 1; j < i; j++) {
                max[i][j] = Math.max(
                        max[i-1][j-1] + map[i][j],
                        max[i-1][j] + map[i][j]
                );
            }
        }

        int answer = 0;
        for(int i = 0; i < size; i++) {
            answer = Math.max(answer, max[size-1][i]);
        }

        System.out.println(answer);
    }
}