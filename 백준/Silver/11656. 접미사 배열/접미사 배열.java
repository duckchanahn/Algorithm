import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(sc.nextLine());

        String[] s = new String[sb.length()];
        for(int i = 0; i < s.length; i++) {
            s[i] = sb.toString();
            sb.deleteCharAt(0);
        }


        Arrays.sort(s);
        for(String st : s) {
            System.out.println(st);
        }
    }
}