import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 3; i++) {
            String s = br.readLine();
            if(!s.equals("Fizz") && !s.equals("Buzz") && !s.equals("FizzBuzz")) {
                int result = Integer.parseInt(s) + (3 - i);
                
                if(result % 3 == 0 && result % 5 == 0) {
                    System.out.println("FizzBuzz");
                } else if(result % 3 == 0) {
                    System.out.println("Fizz");
                } else if(result % 5 == 0) {
                    System.out.println("Buzz");
                } else {
                    System.out.println(result);
                }
                return;
            }
        }
    }
}