// 시간복잡도: O(n)
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int v = sc.nextInt();
        int count = 0;
        
        for (int num : arr) {
            if (num == v) {
                count++;
            }
        }
        
        System.out.println(count);
        sc.close();
    }
}