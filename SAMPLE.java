import java.util.*;
import java.io.*;

class Linkedlist {
    static Link first;

    static class Link {
        int data;
        Link next;
        Link first;

        Link(int d) {
            data = d;
            next = null;
            first = null;
        }
    }

    public static Link insert(int data) {
        Link li = null;
        Link new_link = new Link(data);
        new_link.next = null;
        if (first == null) {
            first = new_link;
        } else {
            Link last = first;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_link;
        }
        return li;
    }

    public static void printList() {
        Link li;
        Link current = first;
        System.out.print("Linkedlist:");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    static Link removeLastLink(Link first) {
        if (first == null)
            return null;
        if (first.next == null) {
            return null;
        }
        Link prev = first;
        while (prev.next.next != null)
            prev = prev.next;
        prev.next = null;
        return first;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        Linkedlist li = new Linkedlist();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total Nodes:");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element" + (i + 1) + ":");
            int a = sc.nextInt();
            li.insert(a);
        }
        int value;
        boolean quit = false;

        while (!quit) {
            System.out.println("Enter the choice:");
            System.out.println(
                    "1.Find average of middle 2 elements\n2.Delete last Node\n3.Swap 2 values at the given positions");
            int ch = sc.nextInt();
            switch (ch) {
            case 1: {
                Link current = li.first;
                for (int i = 0; i < (n / 2) - 1; i++) {
                    current = current.next;
                }
                int b = current.data;
                current = current.next;
                int c = current.data;
                System.out.println("Average of 2 middle elements = " + ((b + c) / 2));
            }
                break;
            case 2: {
                li.first = removeLastLink(li.first);
                li.printList();
            }
                break;
            case 3: {
                System.out.println("Enter the positions to swap:");
                int i = sc.nextInt();
                int j = sc.nextInt();
                Link ithlink = li.first, jthlink = li.first;
                for (int link = 0; link < i; link++) {
                    ithlink = ithlink.next;
                }
                for (int link = 0; link < j; link++) {
                    jthlink = jthlink.next;
                }
                int temp = ithlink.data;
                ithlink.data = jthlink.data;
                jthlink.data = temp;
                li.printList();
            }
                break;
            }

            System.out.println("1.Continue \n2.Exit");
            BufferedReader select = new BufferedReader(new InputStreamReader(System.in));
            value = Integer.parseInt(select.readLine());
            quit = (value == 2) ? true : false;
        }
        System.out.println("Exiting......");

    };
}