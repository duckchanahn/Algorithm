import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        int[] map = new int[size + 1];
        int[] sum = new int[size + 1];

        for(int i = 1; i <= size; i++) {
            map[i] = Integer.parseInt(br.readLine());
        }
        
        if(size == 0) {
            System.out.println(0);
            return;
        }

        if(size == 1) {
            System.out.println(map[1]);
            return;
        }

        if(size == 2) {
            System.out.println(map[1] + map[2]);
            return;
        }

        sum[1] = map[1];
        sum[2] = map[1] + map[2];
        sum[3] = Math.max(map[1] + map[3], map[2] + map[3]);

        for(int i = 4; i <= size; i++) {
            sum[i] = Math.max(
                    sum[i-2] + map[i],
                    sum[i-3] + map[i-1] + map[i]
            );
        }

        System.out.println(sum[size]);
    }
}