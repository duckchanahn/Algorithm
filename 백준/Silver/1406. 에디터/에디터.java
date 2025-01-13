// 시간복잡도: O(N) - N은 명령어의 개수 

import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        char data;
        Node prev, next;
        
        Node(char data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String str = br.readLine();
        int M = Integer.parseInt(br.readLine());
        
        Node head = new Node('0');  
        Node tail = new Node('0');  
        head.next = tail;
        tail.prev = head;
        
        Node cursor = tail;  
        
        for(char c : str.toCharArray()) {
            Node newNode = new Node(c);
            newNode.prev = cursor.prev;
            newNode.next = cursor;
            cursor.prev.next = newNode;
            cursor.prev = newNode;
        }
        
        for(int i = 0; i < M; i++) {
            String command = br.readLine();
            char cmd = command.charAt(0);
            
            switch(cmd) {
                case 'L':
                    if(cursor.prev != head) {
                        cursor = cursor.prev;
                    }
                    break;
                case 'D':
                    if(cursor != tail) {
                        cursor = cursor.next;
                    }
                    break;
                case 'B':
                    if(cursor.prev != head) {
                        cursor.prev.prev.next = cursor;
                        cursor.prev = cursor.prev.prev;
                    }
                    break;
                case 'P':
                    char x = command.charAt(2);
                    Node newNode = new Node(x);
                    newNode.prev = cursor.prev;
                    newNode.next = cursor;
                    cursor.prev.next = newNode;
                    cursor.prev = newNode;
                    break;
            }
        }
        
        Node current = head.next;
        while(current != tail) {
            bw.write(current.data);
            current = current.next;
        }
        
        bw.flush();
        bw.close();
    }
}