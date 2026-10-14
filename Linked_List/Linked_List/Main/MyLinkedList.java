package Main;

import org.w3c.dom.Node;

import java.util.NoSuchElementException;

public class MyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    private static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size ==0;
    }

    public void addFirst(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;

        if(tail == null) {
            tail = newNode;
        }
        size++;
    }
    public void addLast(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }
        tail.next = newNode;
        newNode.next=null;
        tail = newNode;
        size++;
    }

    public void addLastNotTail(int value) {
        Node newNode = new Node(value);
        Node curr = head;
        while(curr.next !=null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    public int removeLast() {
        if(head == null) {
            throw new NoSuchElementException("List is empty");
        }
        if(head == tail) {
            int value = head.data;
            head = null;
            tail = null;
            size--;
            return value;
        }
        Node curr=head;
        while(curr.next!=null) {
            curr=curr.next;
        }
        int value= tail.data;
        curr.next=null;
        tail=curr;
        size--;
        return value;
    }
}
