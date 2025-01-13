import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        int[] count = new int[10];
        
        for (char c : n.toCharArray()) {
            count[c - '0']++;
        }
        
        int sixAndNine = count[6] + count[9];
        count[6] = count[9] = (sixAndNine + 1) / 2;
        
        int maxCount = 0;
        for (int i = 0; i < 10; i++) {
            maxCount = Math.max(maxCount, count[i]);
        }
        
        System.out.println(maxCount);
        sc.close();
    }
}