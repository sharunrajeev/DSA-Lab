import java.util.*;

class LinkedLink {
    private int data;
    LinkedLink next;

    LinkedLink(int d) {
        data = d;
        next = null;
    }

    public int returnData() {
        return data;
    }
}

class LinkedList {
    
    LinkedLink first;

    void reverse() {
        LinkedLink prev = null;
        LinkedLink current = first;
        LinkedLink next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        first = prev;
    }

    public void insert(int data) {
        LinkedLink newLinkedLink = new LinkedLink(data);
        newLinkedLink.next = first;
        first = newLinkedLink;
    }

    public void delete() {
        first = first.next;
    }

    void display() {
        LinkedLink current = first;
        System.out.println("\nLinked List View");
        while (current != null) {
            System.out.print(current.returnData() + " ");
            current = current.next;
        }
    }
}

public class LabB6 {
    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        Scanner sc = new Scanner(System.in);
        int choice, value;
        do {
            System.out.println("\n\nReversing using singly linked list");
            System.out.println("1. Insert data");
            System.out.println("2. Delete data");
            System.out.println("3. Reverse");
            System.out.println("4. Exit");
            choice = sc.nextInt();
            switch (choice) {
            case 1:
                System.out.println("Enter data to be inserted.");
                value = sc.nextInt();
                l.insert(value);
                l.display();
                break;

            case 2:
                l.delete();
                l.display();
                break;

            case 3:
                l.reverse();
                l.display();
                break;

            case 4:
                System.out.println("See ya!");
                break;

            default:
                System.out.println("Wrong choice!");
                break;
            }
        } while (choice != 4);
        sc.close();
    }
}
