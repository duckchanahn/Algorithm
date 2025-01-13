import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        
        HashMap<Character, Integer> charCount = new HashMap<>();
        
        for (char c = 'a'; c <= 'z'; c++) {
            charCount.put(c, 0);
        }
        
        for (char c : word.toCharArray()) {
            charCount.put(c, charCount.get(c) + 1);
        }
        
        for (char c = 'a'; c <= 'z'; c++) {
            System.out.print(charCount.get(c) + " ");
        }
        
        sc.close();
    }
}