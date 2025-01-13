// 시간복잡도: O(N)
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] students = new int[7][2];
        
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int y = sc.nextInt();
            students[y][s]++;
        }
        
        int rooms = 0;
        for (int i = 1; i <= 6; i++) {
            for (int j = 0; j < 2; j++) {
                rooms += (students[i][j] + k - 1) / k;
            }
        }
        
        System.out.println(rooms);
        sc.close();
    }
}