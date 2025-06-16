import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] map = new int[size];
        for(int i = 0; i < size; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[size];
        int[] prev = new int[size];

        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        for(int i = 1; i < size; i++) {
            for(int j = 0; j < i; j++) {
                if(map[j] < map[i] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
        }

        int index = 0;
        int answer = 0;
        for(int i = 0; i < size; i++) {
            if(answer < dp[i]) {
                index = i;
                answer = dp[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        while(index != -1) {
            list.add(map[index]);
            index = prev[index];
        }

        Collections.reverse(list);
        for (int i : list) {
            sb.append(i).append(" ");
        }
        System.out.println(answer);
        System.out.println(sb);
    }
}