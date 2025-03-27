import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    private static int[][] memo; // 0 1 순서

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        HashMap<String, String> map = new HashMap<>();

        for(int i = 0; i < size; i++) {
            String[] list = br.readLine().split(" ");
            map.put(list[0], list[1]);
        }
        for (int i = 0; i < T; i++) {
            System.out.println(map.get(br.readLine()));
        }
    }

}