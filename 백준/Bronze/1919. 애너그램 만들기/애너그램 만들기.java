// 시간복잡도: O(N)
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (char c : str1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for (char c : str2.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) - 1);
        }
        
        int remove = 0;
        for (int count : map.values()) {
            remove += Math.abs(count);
        }
        
        System.out.println(remove);
        sc.close();
    }
}