import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        boolean start = false;
        for(int i = 0; i < T; i++) {
            String line = br.readLine();
            String[] lines = line.split(" ");
            if(line.contains("ChongChong")) {
                set.add(lines[0]);
                set.add(lines[1]);
                start = true;
            }

            if(start) {
                if(set.contains(lines[0]) || set.contains(lines[1])) {
                    set.add(lines[0]);
                    set.add(lines[1]);
                }
            }
        }

        System.out.println(set.size());
    }
}