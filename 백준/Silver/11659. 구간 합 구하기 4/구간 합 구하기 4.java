import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] values = new int[N];
        int[] memory = new int[N+1];
        int sum = 0;
        for(int i = 0; i < N; i++) {
            values[i] = Integer.parseInt(st.nextToken());
            sum += values[i];
            memory[i+1] = sum;
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            System.out.println(
                    Math.abs(
                            memory[Integer.parseInt(st.nextToken())-1] - memory[Integer.parseInt(st.nextToken())]
                    )
            );
        }
    }
}