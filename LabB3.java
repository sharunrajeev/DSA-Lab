// Question : Write a program to implement string reversal using doubly linked list.
// Author - Sharun E Rajeev

import java.io.*;

class Link {
    private char data;
    public Link next, previous;

    public Link(char c) {
        data = c;
    }

    public void displayLink() {
        System.out.print(data);
    }
}

class DoublyLinkedList {
    private Link first, last;       // Reference to first and last item.

    public DoublyLinkedList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(char d) {
        Link nl = new Link(d);
        if(isEmpty()) {
            first = nl;
            last = nl;
        } else {
            nl.next = first;
            first.previous = nl;
            first = nl;
        }
    }

    public void displayBackwards() {
        Link current = first;
        while(current!=null) {
            current.displayLink();
            current = current.next;
        }
    }
}

public class LabB3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("String Reversal Using Doubly Linked List.");
        System.out.println("Enter a string.");
        String input = br.readLine();
        char letter;
        DoublyLinkedList dll = new DoublyLinkedList();
        for(int i=0;i<input.length();i++) {
            letter = input.charAt(i);
            dll.insertFirst(letter);
        }
        dll.displayBackwards();
    }
}
