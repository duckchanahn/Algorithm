import java.io.*;
import java.util.*;

public class Main {

    static int size;
    static int goal;
    static int count;
    static int[] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        size = Integer.parseInt(st.nextToken());
        goal = Integer.parseInt(st.nextToken());
        map = new int[size];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < size; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }
        count = 0;

        make(0, 0, 0);
        System.out.println(count);
    }

    private static void make(int index, int sum, int selected) {
        if(index == size) {
            if(sum == goal && selected > 0) {
                count++;
            }
            return;
        }

        make(index+1, sum + map[index], selected + 1);
        make(index+1, sum, selected);
    }

}