import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int x = sc.nextInt();
        HashSet<Integer> set = new HashSet<>();
        long count = 0;
        
        for (int num : arr) {
            if (num < x && set.contains(x - num)) {
                count++;
            }
            set.add(num);
        }
        
        System.out.println(count);
        sc.close();
    }
}