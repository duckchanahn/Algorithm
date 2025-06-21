import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt();

        if (N == 1) {
            System.out.println(1);
            return;
        }

        int prevprev = 1;
        int prev = 2;

        int temp = 0;
        for(int i = 2; i < N; i++) {
            temp = (prevprev + prev) % 15_746;
            prevprev = prev;
            prev = temp;

        }

        System.out.println(prev);
    }
}