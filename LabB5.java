import java.util.Scanner;

class Node {
    private int data;
    public Node prev, next;

    static Node getNode(int data)
    {
        Node newNode = new Node();
        newNode.data = data;
        newNode.prev = newNode.next = null;
        return newNode;
    }

    public int returnData() {
        return data;
    }
};

class Deque {
    Node front, rear;
    int size;

    Deque() {
        front = rear = null;
        size = 0;
    }

    boolean isEmpty() {
        return (front == null);
    }

    void insertFront(int data) {
        Node newNode = Node.getNode(data);
        if (newNode == null) {
            System.out.println("Overflow!");
        }
        else {
            if (front == null) {
                rear = front = newNode;
            }
            else {
                newNode.next = front;
                front.prev = newNode;
                front = newNode;
            }
            size++;
        }
    }

    void insertRear(int data) {
        Node newNode = Node.getNode(data);
        if (newNode == null)
            System.out.println("Overflow!");
        else {
            if (rear == null) {
                rear = front = newNode;
            } else {
                newNode.prev = rear;
                rear.next = newNode;
                rear = newNode;
            }
            size++;
        }
    }
    
    public void deleteFront() {
        if (isEmpty())
            System.out.println("\nUnderFlow!");
        else {
            front = front.next;
            if (front == null)
                rear = null;
            else
                front.prev = null;
            size--;
            display();
        }
    }

    public void deleteRear() {
        if (isEmpty())
            System.out.println("\nUnderFlow!");
        else {
            rear = rear.prev;
            if (rear == null)
                front = null;
            else
                rear.next = null;
            size--;
            display();
        }
    }
    
    public void display() {
        Node current = front;
        System.out.println("\nDeque View");
        for (int i = 0; i < size; i++) {
            System.out.print(current.returnData() + " ");
            current = current.next;
        }
    }

}

public class LabB5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque dq = new Deque();
        int choice, value;
        do {
            System.out.println("\nDeque Manager");
            System.out.println("1. InsertFront");
            System.out.println("2. InsertRear");
            System.out.println("3. DeleteFront");
            System.out.println("4. DeleteRear");
            System.out.println("5. Exit");
            choice = sc.nextInt();
            switch (choice) {
            case 1:
                System.out.println("Enter value to be inserted at front.");
                value = sc.nextInt();
                dq.insertFront(value);
                dq.display();
                break;
            case 2:
                System.out.println("Enter value to be inserted at rear.");
                value = sc.nextInt();
                dq.insertRear(value);
                dq.display();
                break;
            case 3:
                dq.deleteFront();
                break;
            case 4:
                dq.deleteRear();
                break;
            case 5:
                System.out.println("Have a nice day!");
                break;
            default:
                System.out.println("Wrong choice");
                break;
            }
        } while (choice != 5);
        sc.close();
    }
}
