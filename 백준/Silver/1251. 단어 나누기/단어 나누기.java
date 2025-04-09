import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String result = null;
        
        StringBuilder sb;
        for(int i = 1; i < line.length()-1; i++) {
            for(int j = i + 1; j < line.length(); j++) {
                String first = line.substring(0, i);
                String second = line.substring(i, j);
                String third = line.substring(j, line.length());
                
                String re = new StringBuilder(first).reverse().toString()
                    + new StringBuilder(second).reverse().toString()
                    + new StringBuilder(third).reverse().toString();
                
                if(result == null || re.compareTo(result) < 0) {
                    result = re;
                }
            }
        }
        
        System.out.println(result);
    }
}