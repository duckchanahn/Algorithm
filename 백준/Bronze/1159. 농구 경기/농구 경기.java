import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T =  Integer.parseInt(br.readLine());
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < T; i++) {
            String line = br.readLine();
            map.put(line.charAt(0), map.getOrDefault(line.charAt(0), 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for(char c = 'a';  c <= 'z'; c++) {
            if(map.getOrDefault(c, 0) >= 5) {
                sb.append(c);
            }
        }

        System.out.println(sb.length() > 0 ? sb.toString() : "PREDAJA");
    }

}