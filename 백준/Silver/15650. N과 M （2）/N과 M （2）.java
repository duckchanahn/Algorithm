import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[] selected;
    static boolean[] used;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        selected = new int[M];
        used = new boolean[N + 1];

        traking(0, 1);
        System.out.println(sb.toString());
    }

    private static void traking(int index, int start) {
        if(index == M) {
            for (int i : selected) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i = start; i <= N; i++) {
            selected[index] = i;
            traking(index+1, i+1);
        }
    }

}