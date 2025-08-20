import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T =  Integer.parseInt(br.readLine());
        while (T-- > 0) {
            getScore(br.readLine());
        }
    }

    private static void getScore(String input) {
        int totalScore = 0;
        int score = 0;

        for(char c : input.toCharArray()) {
            if(c == 'O') {
                score++;
                totalScore += score;
            } else if(c == 'X') {
                score = 0;
            }
        }

        System.out.println(totalScore);
    }
}