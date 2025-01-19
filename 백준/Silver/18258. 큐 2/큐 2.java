import java.util.*;
import java.io.*;

public class Main {
   public static void main(String args[]) throws IOException {
       Queue<Integer> queue = new LinkedList<>();
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       
       int n = Integer.parseInt(br.readLine());
       for(int i = 0; i < n; i++) {
           String[] command = br.readLine().split(" ");
           
           switch(command[0]) {
               case "push":
                   queue.offer(Integer.parseInt(command[1]));
                   break;
               case "pop":
                   bw.write(String.valueOf(queue.isEmpty() ? -1 : queue.poll()) + "\n");
                   break;
               case "size":
                   bw.write(String.valueOf(queue.size()) + "\n"); 
                   break;
               case "empty":
                   bw.write(String.valueOf(queue.isEmpty() ? 1 : 0) + "\n");
                   break;
               case "front":
                   bw.write(String.valueOf(queue.isEmpty() ? -1 : queue.peek()) + "\n");
                   break;
               case "back":
                   bw.write(String.valueOf(queue.isEmpty() ? -1 : ((LinkedList<Integer>)queue).getLast()) + "\n");
                   break;
           }
       }
       
       bw.flush();
       bw.close();
       br.close();
   }
}