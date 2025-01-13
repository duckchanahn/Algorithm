// 시간복잡도: O(N)
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            String str1 = sc.next();
            String str2 = sc.next();
            
            HashMap<Character, Integer> map = new HashMap<>();
            
            for (char c : str1.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            
            for (char c : str2.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) - 1);
            }
            
            boolean possible = true;
            for (int count : map.values()) {
                if (count != 0) {
                    possible = false;
                    break;
                }
            }
            
            System.out.println(possible ? "Possible" : "Impossible");
        }
        sc.close();
    }
}