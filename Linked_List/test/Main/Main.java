package Main;

import java.util.Arrays;
import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main (String[] args) {
        System.out.print("So luong phan tu cua mang: ");
        int numbers = Integer.parseInt(scanner.nextLine());
        int[] Array = new int[numbers];
        for(int i = 0;i < numbers;i++) {
            Array[i] = Integer.parseInt(scanner.nextLine());
        }

        Arrays.sort(Array);

        Node head = new Node(Array[0]);
        Node curr = head;

        for(int i = 1; i<numbers;i++) {
            if(Array[i] != Array[i-1]) {
                curr.next = new Node(Array[i]);
                curr = curr.next;
            }
        }

    }
}
