import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] map = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] max = new int[size];
        max[0] = map[0];

        for(int i = 1; i < size; i++) {
            max[i] = Math.max(max[i-1] + map[i], map[i]);
        }

        System.out.println(Arrays.stream(max).max().getAsInt());
    }
}