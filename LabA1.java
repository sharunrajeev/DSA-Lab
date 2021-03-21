// Write a java programm to implement bubble sort
// Author - Sharun E Rajeev

import java.util.Scanner;                       // Import to use scanner in our project

public class LabA1 {                             // Lab1 class 
    public static void main(String[] args) {    // Main function
        Scanner sc = new Scanner(System.in);    // Scanner to accept keyboard inputs
        int size;                               // Stores the size of the array
        System.out.println("Enter the size of the array");
        size = sc.nextInt();                    // Accepts size from the user
        int[] ar = new int[size];               // Creates an array of size given by the user
        System.out.println("Enter elements into the array");
        for (int i = 0; i < size; i++) {        // Accepts elements to the array
            ar[i] = sc.nextInt();               // Scanning each integer value and stores to the array
        }
        for (int i = 0; i < size; i++) {        // No of scans which is equal to the size of the array
            for (int j = 1; j < (size - i); j++) {      // Inner loop to compare elements
                if (ar[i] < ar[j]) {            // Compares if the second element is greater than the first
                    int temp = ar[i];           // Interchanging the values 
                    ar[i] = ar[j];
                    ar[j] = temp;
                }
            }
        }
        System.out.println("Array after bubble sorting");
        for (int i = 0; i < size; i++) {        // Displaying the array
            System.out.print(ar[i] + " ");
        }
        sc.close();                             // Closing scanner object
    }
}
