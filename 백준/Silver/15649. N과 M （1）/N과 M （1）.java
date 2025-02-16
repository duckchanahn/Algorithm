import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[] selected;
    static boolean[] used;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        selected = new int[M];
        used = new boolean[N + 1];

        make(0);
        System.out.println(sb.toString());
    }

    private static void make(int index) {
        if(index == M) {
            for(int i : selected) {
                sb.append(i + 1).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i = 0; i < N; i++) {
            if(used[i]) continue;

            selected[index] = i;
            used[i] = true;

            make(index + 1);

            used[i] = false;
        }
    }
}