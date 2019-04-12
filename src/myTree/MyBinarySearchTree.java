package myTree;
import myNode.MyTreeNode;

import java.util.Scanner;

public class MyBinarySearchTree {
    public static Scanner s = new Scanner(System.in);
    private MyTreeNode root;
    private int size;
    private int edges;
    private int count;
    private int count1;
    private int count2;

    public boolean isEmpty() {
        return size == 0;
    }

    public void getSize() {
        System.out.println("YOUR TREE HAVE: " + size + " NODES");
    }

    public void addNode() {
        System.out.println("ENTER THE ELEMENT YOU WANT TO ENTER");
        int data = s.nextInt();
        MyTreeNode n = new MyTreeNode();
        n.setData(data);
        if (isEmpty()) {
            root = n;
        } else {
            addNode(n, root);
        }
        size++;
    }

    private void addNode(MyTreeNode n, MyTreeNode node) {
        if (n.getData() <= node.getData() && node.getLeft() == null) {
            node.setLeft(n);
            return;
        } else if (n.getData() > node.getData() && node.getRight() == null) {
            node.setRight(n);
            return;
        } else if (n.getData() <= node.getData()) {
            node = node.getLeft();
        } else {
            node = node.getRight();
        }
        addNode(n, node);
    }

    public void searchNode() {
        System.out.println("ENTER THE ELEMENT YOU WANT TO SEARCH");
        int data = s.nextInt();
        if (isEmpty()) {
            System.out.println("YOUR TREE IS EMPTY");
        } else {
            count2=1;
            searchNode(data, root);
            if(count2==0){
                System.out.println("ELEMENT IS FOUND");
            }
            else{
                System.out.println("ELEMENT IS NOT FOUND \n PLEASE ENTER ANOTHER ELEMENT");
            }
        }
    }

    private void searchNode(int data, MyTreeNode current) {
        if (current!=null && current.getData() == data) {
            count2--;
            return;
        } else if (current!=null && data < current.getData()) {
            current = current.getLeft();
        } else if(current!=null && data > current.getData()){
            current = current.getRight();
        }
        if(current!=null) {
            searchNode(data, current);
        }
    }

    public boolean removeNode() {
        System.out.println("ENTER THE ELEMENT YOU WANT TO DELETE");
        int data = s.nextInt();
        if (isEmpty()) {
            System.out.println("TREE IS EMPTY");
            return true;
        }
        else {
            if(root.getData()==data) {
                replaceRoot(data,root,root);
                System.out.println("ELEMENT HAS BEEN REMOVED");
            }
            else {
                count1=1;
                replace(data, root, root);
                if(count1==0){
                    System.out.println("ELEMENT IS REMOVED");
                }
                else {
                    System.out.println("ELEMENT IS NOT FOUND \n SO, CAN'T BE REMOVED");
                }
            }
        }
        return false;
    }

    private void replaceRoot(int data,MyTreeNode current,MyTreeNode parent){
        removeNode(current, parent);
        size--;
        return;
    }

    private void replace(int data, MyTreeNode current, MyTreeNode parent) {
        if (data < current.getData()) {
            parent = current;
            current = current.getLeft();
            if (current!=null && current.getLeft() != null) {
                replace(data, current, parent);
            }
        } else if (data > current.getData()) {
            parent = current;
            current = current.getRight();
            if (current!=null && current.getRight() != null) {
                replace(data, current, parent);
            }
        }
        if (current!=null && current.getData() == data) {
            removeNode(current, parent);
                size--;
                count1--;
            }
        }

    private void removeNode(MyTreeNode current, MyTreeNode parent) {

        if (current.getLeft() == null && current.getRight() == null) {
            if (current.getData() < parent.getData()) {
                parent.setLeft(null);
            } else if (current.getData() > parent.getData()) {
                parent.setRight(null);
            } else {
                root = null;
            }
        } else if (current.getLeft() == null) {
            if(current.getRight()==parent.getRight()){
                root=current.getRight();
            }
            else if (current.getData() < parent.getData()) {
                parent.setLeft(current.getRight());
                current.setData(0);

            } else {
                parent.setRight(current.getRight());
                current.setData(0);
            }
        } else if (current.getRight() == null) {
            if(current.getLeft()==parent.getLeft()){
                root=current.getLeft();
            }
            else if (current.getData() < parent.getData()) {
                parent.setLeft(current.getLeft());
                current.setData(0);
            } else {
                parent.setRight(current.getLeft());
                current.setData(0);
            }
        } else {
            MyTreeNode replace = current;
            if (current.getLeft().getRight() == null) {
                replace = current.getLeft();
                current.setData(replace.getData());
                current.setLeft(replace.getLeft());
            } else {
                replace = current.getLeft();
                while (replace.getRight().getRight() != null) {
                    replace = replace.getRight();
                }
                current.setData(replace.getRight().getData());
                replace.setRight(null);
            }
        }
    }

    public void displayTree() {
        edges = 2 * size;
        for (int i = 1; i <= size; i++) {
            printLevel(root, i);
            count = i;
            if (edges == 0) {
                break;
            }
        }
    }

    public void treeLevels() {
        System.out.println("YOUR TREE HAS LEVELS: " + (count - 1));
    }

    private void printLevel(MyTreeNode root, int level) {
        if (level == 0) {
            System.out.println("TREE IS EMPTY");
        } else if (level == 1) {
            System.out.print(root.getData() + " ");
            edges = edges - 2;
        } else {
            if (root.getLeft() != null) {
                printLevel(root.getLeft(), level - 1);
            }
            if (root.getRight() != null) {
                printLevel(root.getRight(), level - 1);
            }
        }
    }

    public void toEmptyTree(){
        if(root==null){
            System.out.println("YOUR TREE IS ALREADY EMPTY");
        }
        else {
            root=null;
            size=0;
            System.out.println("YOUR TREE HAS BEEN EMPTIED");
        }
    }

    public static void main(String[] args) {
        MyBinarySearchTree obj = new MyBinarySearchTree();
        boolean flag = true;
        while (flag) {
            System.out.println(" \n ENTER YOUR CHOICE: \n 1. TO INSERT ELEMENT \n 2. TO DELETE ELEMENT \n 3. TO DISPLAY ELEMENTS \n 4. TO GET NUMBER OF ELEMENTS \n 5. TO CHECK IF TREE IS EMPTY \n 6. TO CHECK THE NUMBER OF LEVELS IN TREE \n 7. TO CHECK IF ELEMENT IS PRESENT OR NOT \n 8. TO EMPTY THE PREVIOUS CONTANT OF TREE \n 9. TO TERMINATE THE PROGRAM");
            int choice = s.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("ENTER THE NUMBER OF ELEMENT YOU WANT TO ENTER");
                    int number1 = s.nextInt();
                    while (number1 != 0) {
                        obj.addNode();
                        number1--;
                    }
                    break;
                case 2:
                    System.out.println("ENTER THE NUMBER OF ELEMENTS YOU WANT TO DELETE");
                    int number2 = s.nextInt();
                    while (number2 != 0) {
                        boolean temp=obj.removeNode();
                        if(temp){
                            break;
                        }
                        number2--;
                    }
                    break;
                case 3:
                    System.out.println("YOUR TREE HAS ELEMENTS \n");
                    obj.displayTree();
                    break;
                case 4:
                    obj.getSize();
                    break;
                case 5:
                    if (obj.isEmpty()) {
                        System.out.println("YOUR TREE IS EMPTY");
                    } else {
                        System.out.println("YOUR TREE IS NOT EMPTY");
                    }
                    break;
                case 6:
                    obj.treeLevels();
                    break;
                case 7:
                    obj.searchNode();
                    break;
                case 8:
                    obj.toEmptyTree();
                    break;
                case 9:
                    flag = false;
            }
        }
    }
}
       /* obj.addNode(100);
        obj.addNode(50);
        obj.addNode(30);
        obj.addNode(20);
        obj.addNode(10);
        obj.addNode(60);
        obj.addNode(150);
        obj.addNode(125);
        obj.addNode(160);
        obj.addNode(55);
        obj.addNode(85);
        obj.addNode(35);
        obj.addNode(105);
        obj.addNode(175);
        obj.addNode(225);
        obj.addNode(265);
        obj.displayTree();
        obj.getSize();
        obj.treeLevels();
        obj.removeNode(265);
        obj.displayTree();
        obj.getSize();*/