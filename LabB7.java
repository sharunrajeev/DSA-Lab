import java.util.Scanner;

// Question : Implement a binary search tree with all the traversals and search method. Insert 10 to 12 nodes.

// Code
class TreeNode {
    int data;
    TreeNode lchild;
    TreeNode rchild;

    public TreeNode(int d) {
        data = d;
        lchild = null;
        rchild = null;
    }

    public void displayNode() {
        System.out.print(data + " ");
    }
}

class Tree {
    public TreeNode root;

    public Tree() {
        root = null;
    }

    public void insert(int i) {
        TreeNode newNode = new TreeNode(i);
        if (root == null) {
            root = newNode;
        } else {
            TreeNode current = root;
            TreeNode parent;
            while (true) {
                parent = current;
                if (i < current.data) {
                    current = current.lchild;
                    if (current == null) {
                        parent.lchild = newNode;
                        return;
                    }
                } else {
                    current = current.rchild;
                    if (current == null) {
                        parent.rchild = newNode;
                        return;
                    }
                }
            }
        }
    }

    // BST Traversal
    void inOrder(TreeNode localRoot) {

        if (localRoot != null) {
            inOrder(localRoot.lchild);
            localRoot.displayNode();
            inOrder(localRoot.rchild);
        }

    }

    void postOrder(TreeNode localRoot) {

        if (localRoot != null) {
            postOrder(localRoot.lchild);
            postOrder(localRoot.rchild);
            localRoot.displayNode();
        }

    }

    void preOrder(TreeNode localRoot) {

        if (localRoot != null) {
            localRoot.displayNode();
            preOrder(localRoot.lchild);
            preOrder(localRoot.rchild);
        }

    }

    TreeNode getRoot() {
        return root;
    }

    // BST Search
    public void search(int key) {
        TreeNode current = root;
        while (current.data != key) {
            if (key < current.data)
                current = current.lchild;
            else
                current = current.rchild;
            if (current == null) {
                System.out.println("Item not found");
                return;
            }
        }
        System.out.println("Item found");
    }
}

public class LabB7 {
    public static void main(String[] args) {
        Tree tree = new Tree();
        int choice;
        int data;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\nBinary Tree Manager");
            System.out.println("1. Insert into Binary Tree");
            System.out.println("2. Inorder Traversal");
            System.out.println("3. Postorder Traversal");
            System.out.println("4. Prerder Traversal");
            System.out.println("5. Search");
            System.out.println("6. Exit\n");
            System.out.println("Enter your choice.");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter integer to be inserted");
                    data = sc.nextInt();
                    tree.insert(data);
                    break;

                case 2:
                    System.out.println("InOrder Traversal");
                    tree.inOrder(tree.getRoot());
                    break;

                case 3:
                    System.out.println("PostOrder Traversal");
                    tree.postOrder(tree.getRoot());
                    break;

                case 4:
                    System.out.println("PreOrder Traversal");
                    tree.preOrder(tree.getRoot());
                    break;

                case 5:
                    System.out.println("Enter integer to be searched");
                    data = sc.nextInt();
                    tree.search(data);
                    break;

                case 6:
                    System.out.println("Thank you. See you later!");
                    break;

                default:
                    System.out.println("Wrong choice");
                    break;
            }
        } while (choice != 6);
        sc.close();
    }
}