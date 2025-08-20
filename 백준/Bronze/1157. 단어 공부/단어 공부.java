import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line =  br.readLine();
        line = line.toUpperCase();

        int[] chars = new int[26];
        int max = 0;
        for(char c : line.toCharArray()) {
            chars[c - 'A']++;
            max  = Math.max(max, chars[c - 'A']);
        }

        boolean duplicate = false;
        char answer = '?';
        for(int i = 0; i < 26; i++) {
            if(chars[i] == max) {
                if(duplicate) {
                    System.out.println("?");
                    return;
                } else {
                    answer = ((char)('A' + i));
                    duplicate = true;
                }
            }
        }

        System.out.println(answer);
    }

}