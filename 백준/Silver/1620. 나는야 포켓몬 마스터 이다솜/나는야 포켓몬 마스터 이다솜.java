import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> keyMap = new HashMap<>();
        String[] numList = new String[N + 1];

        for(int i = 1; i <= N; i++) {
            String name = br.readLine();
            keyMap.put(name, i);
            numList[i] = name;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= M; i++) {
            String line = br.readLine();
            if(isNumeric(line)) {
                int index = Integer.parseInt(line);
                sb.append(numList[index]).append('\n');
            } else {
                sb.append(keyMap.get(line)).append('\n');
            }
        }

        System.out.print(sb);
    }

    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
}