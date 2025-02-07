
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        long result = 1;
        long base = a % c;
        while(b > 0) {
            if(b % 2 == 1) {
                result = (result * base) % c;
            }

            base = (base * base) % c;
            b /= 2;
        }

        System.out.println(result);
    }
}