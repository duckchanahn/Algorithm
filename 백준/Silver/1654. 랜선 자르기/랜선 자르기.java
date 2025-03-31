import java.util.*;
import java.io.*;

public class Main {

    static long left;
    static long right;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int K = line[0]; 
        int N = line[1]; 

        long[] cables = new long[K];
        for (int i = 0; i < K; i++) {
            cables[i] = Long.parseLong(br.readLine());
        }

        left = 1;
        right = Arrays.stream(cables).max().getAsLong();

        long result = binarySearch(cables, N);
        System.out.println(result);
    }

    static long binarySearch(long[] cables, int target) {
        long result = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2; 

            long count = 0;
            for (long cable : cables) {
                count += cable / mid;
            }

            if (count >= target) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1; 
            }
        }

        return result;
    }
}