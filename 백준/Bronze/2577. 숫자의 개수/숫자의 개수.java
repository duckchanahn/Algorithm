import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        
        long result = (long)A * B * C;
        int[] count = new int[10];
        
        String resultStr = String.valueOf(result);
        
        for (char digit : resultStr.toCharArray()) {
            count[digit - '0']++;
        }
        
        for (int i = 0; i <= 9; i++) {
            System.out.println(count[i]);
        }
        
        sc.close();
    }
}