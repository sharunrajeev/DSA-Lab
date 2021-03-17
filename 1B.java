// Using java implement stack using arrays.
// Author - Sharun E Rajeev

import java.util.Scanner;

class Stack {                       // Stack implementation of Array
    private int top;                // Stores the top position
    private int maxSize;            // Stores the size of the Array
    private int arr[];              // Creates an Array

    public Stack(int size) {        // Initialises variables using constructor
        top = -1;                   // Top is -1 when we start with
        maxSize = size;
        arr = new int[maxSize];
    }

    public void push(int value) {   // Insertion operation in Stack
        arr[++top] = value;
        display();
    }

    public void pop() {             // Deletion operation in Stack
        if (isEmpty()) {
            System.out.println("Stack Underflow! No more deletion possible");
        } else {
            top--;
            display();
        }
    }

    public boolean isFull() {       // To check if stack is full 
        return (top == (maxSize - 1));
    }

    public boolean isEmpty() {      // To check if stack is empty
        return (top == -1);
    }

    public void display() {         // Display the stack
        System.out.println("\n-----Stack View-----");
        for (int i = top; i >= 0; i--) {
            System.out.println("\t" + arr[i]);
        }
    }
}

public class Lab2 {                 // Class Lab 2   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int size = sc.nextInt();
        Stack s = new Stack(size);
        int choice;
        do {                        // Menu to choose the operation
            System.out.println("\n-----Stack using Array-----\nChoose an option -");
            System.out.println("1.Push");
            System.out.println("2.Pop");
            System.out.println("3.Exit");
            choice = sc.nextInt();
            System.out.println();
            switch (choice) {
                case 1:
                    if (s.isFull()) 
                        System.out.println("Stack Overflow! No more insertion possible.");
                    else {
                        System.out.println("Enter the value to be pushed");
                        int value = sc.nextInt();
                        s.push(value);
                    }
                    break;

                case 2:
                    s.pop();
                    break;

                case 3:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Wrong Choice");
                    break;

            }
        } while (choice != 3);
        sc.close();
    }                                
}
