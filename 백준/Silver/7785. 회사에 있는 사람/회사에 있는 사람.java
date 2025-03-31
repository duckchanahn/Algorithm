import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < T; i++) {
            String[] s = br.readLine().split(" ");
            if(s[1].equals("enter")) {
                set.add(s[0]);
            } else {
                set.remove(s[0]);
            }
        }

        ArrayList<String> list = new ArrayList<>(set);
        Collections.sort(list, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for(String s : list) {
            sb.append(s).append("\n");
        }
        System.out.println(sb.toString());
    }
}