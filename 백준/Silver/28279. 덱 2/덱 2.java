import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i < T; i++) {
            deque(dq, new StringTokenizer(br.readLine()));
        }
    }

    private static void deque(Deque<Integer> dq, StringTokenizer st) {
        int command = Integer.parseInt(st.nextToken());
        switch(command) {
            case 1:
                dq.addFirst(Integer.parseInt(st.nextToken()));
                break;
            case 2:
                dq.addLast(Integer.parseInt(st.nextToken()));
                break;
            case 3:
                System.out.println(!dq.isEmpty() ? dq.pollFirst() : -1);
                break;
            case 4:
                System.out.println(!dq.isEmpty() ? dq.pollLast() : -1);
                break;
            case 5:
                System.out.println(dq.size());
                break;
            case 6:
                System.out.println(!dq.isEmpty() ? 0 : 1);
                break;
            case 7:
                System.out.println(!dq.isEmpty() ? dq.peekFirst() : -1);
                break;
            case 8:
                System.out.println(!dq.isEmpty() ? dq.peekLast() : -1);
                break;
            default:
                break;
        }
    }
}