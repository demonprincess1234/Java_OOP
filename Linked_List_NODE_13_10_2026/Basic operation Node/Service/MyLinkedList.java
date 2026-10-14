package Service;

import java.util.NoSuchElementException;

public class MyLinkedList {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public void transfromNode(int[] arr) {
        if(arr == null || arr.length ==0) {
            throw new IllegalArgumentException("Mang loi");
        }
        head = new Node(arr[0]);
        size = arr.length;
        Node curr = head;

        for(int i=1; i<size;i++) {
            curr.next = new Node(arr[i]);
            curr = curr.next;
        }
    }

    public void addFirst(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addByIndex(int index, int value) {
        if(index==0) {
            addFirst(value);
            size++;
        }
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("Loi nhap lieu");
        }
        Node curr = head;
        for(int i=1; i< index; i++) {
            curr = curr.next;
        }
        Node newNode = new Node(value);
        newNode.next = curr.next.next;
        curr.next = newNode;
        size++;
    }

    public void removeByIndex(int index) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("Loi nhap lieu");
        }
        if(index ==0) {
            head = head.next;
            size--;
        }

        Node curr = head;
        for(int i=1; i< index -1; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        size--;
    }
}

