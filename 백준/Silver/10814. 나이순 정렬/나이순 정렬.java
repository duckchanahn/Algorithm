import java.util.*;
import java.io.*;

public class Main {
    
    private static class Person {
        int age;
        String name;
        int order;
        
        public Person(int age, String name, int order) {
            this.age = age;
            this.name = name;
            this.order = order;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int size = Integer.parseInt(br.readLine());
        ArrayList<Person> personList = new ArrayList<>();
        
        for(int i = 0; i < size; i++) {
            String[] temp = br.readLine().split(" ");
            personList.add(new Person(Integer.parseInt(temp[0]), temp[1], i));
        }
        
        Collections.sort(personList, (p1, p2) -> {
            if(p1.age == p2.age) {
                return p1.order - p2.order;
            }
            return p1.age - p2.age;
        });
        
        StringBuilder sb = new StringBuilder();
        for (Person p : personList) {
            sb.append(p.age).append(" ").append(p.name).append("\n");
        }
        
        System.out.print(sb);
        
    }
}