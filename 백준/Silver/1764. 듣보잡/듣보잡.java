import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for(int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        ArrayList<String> list = new ArrayList<>();
        String s;
        for(int i = 0; i < M; i++) {
            s = br.readLine();
            if(set.contains(s)) {
                list.add(s);
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for(String temp : list) {
            System.out.println(temp);
        }
    }
}