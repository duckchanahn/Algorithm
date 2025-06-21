import java.util.*;

public class Main {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        int abs = Math.abs(n);
        if(n == 0) {
            System.out.println("0" + "\n" + "0");
            return;
        }

        long prevprev = 0;
        long prev = 1;

        for(int i = 2; i <= abs; i++) {
            long temp = (prevprev + prev) % 1_000_000_000;
            prevprev = prev;
            prev = temp;
        }

        int sign;
        if(n > 0) {
            sign = 1;
        } else {
            // F(-n) = (-1)^(n+1) * F(n)
            sign = (abs % 2 == 1) ? 1 : -1;
        }
//        sign = n < 0 && abs % 2 == 1 ? 1 : -1;
        System.out.println(sign + "\n" + prev);
    }
}