package myTree;
import myNode.MyTreeNode;
import java.lang.Math.*;

public class MyBinarySearchTree {
    static MyTreeNode root;
    int size;

    public boolean isEmpty(){
        return size==0;
    }

    public void getSize(){
        System.out.println("YOUR TREE HAVE: "+size+" NODES");
    }

    public void addNode(int data){
        MyTreeNode n= new MyTreeNode();
        n.setData(data);
        if(isEmpty()){
            root=n;
        }
        else{
            addNode(n,root);
        }
        size++;
    }

    private void addNode(MyTreeNode n,MyTreeNode node){
        if(n.getData()<=node.getData() && node.getLeft()==null){
            node.setLeft(n);
            return;
        }
        else if (n.getData()>node.getData() && node.getRight()==null){
            node.setRight(n);
            return;
        }
        else if (n.getData()<=node.getData()){
            node=node.getLeft();
        }
        else{
            node=node.getRight();
        }
        addNode(n,node);
    }

    public void searchNode(int data){
        if(isEmpty()){
            System.out.println("YOUR TREE IS EMPTY");
            return;
        }
        else{
            searchNode(data,root);
        }
    }

    private void searchNode(int data,MyTreeNode current){
        if(current.getData()==data){
            System.out.println("ELEMENT IS FOUND");
            return;
        }
        else if(data<current.getData()){
            current=current.getLeft();
        }
        else{
            current=current.getRight();
        }
        searchNode(data,current);
    }

    public void removeNode(int data){
        if(isEmpty()){
            System.out.println("TREE IS EMPTY");
            return;
        }
        else{
            removeNode(data,root);
            size--;
        }
    }

    private void removeNode(int data, MyTreeNode node){
        MyTreeNode parent=node;
        MyTreeNode current=node;
        if(data<current.getData()){
            parent=current;
            current=current.getLeft();
            if(current.getLeft()!=null) {
                removeNode(data, current);
            }
        }
        else if (data>current.getData()){
            parent=current;
            current=current.getRight();
            removeNode(data,current);
        }

        if (current.getLeft()==null && current.getRight()==null){
            if(current.getData()<parent.getData()){
                parent.setLeft(null);
                return;
            }
            else if(current.getData()>parent.getData()){
                parent.setRight(null);
                return;
            }
            else{
                root=null;
                return;
            }
        }

        else if(current.getLeft()==null){
            if(current.getData()<parent.getData()){
                parent.setLeft(current.getRight());
                return;
            }
            else{
                parent.setRight(current.getRight());
                return;
            }
        }

        else if (current.getRight()==null){
            if(current.getData()<parent.getData()){
                parent.setLeft(current.getLeft());
                return;
            }
            else{
                parent.setRight(current.getLeft());
                return;
            }
        }

        else {
            MyTreeNode replace=current;
            if(current.getLeft().getRight()==null){
                replace=current.getLeft();
                current.setData(replace.getData());
                current.setLeft(replace.getLeft());
                return;
            }
            else{
                replace=current.getLeft();
                while(replace.getRight().getRight()!=null){
                    replace=replace.getRight();
                }
                current.setData(replace.getRight().getData());
                replace.setRight(null);
                return;
            }
        }
    }

    public int calculateHeight(){
        return ((int)Math.ceil(Math.log(size)/Math.log(2)));
    }

    public void displayTree(){
        int height=calculateHeight();
        for(int i=1;i<=height;i++){
            printLevel(root,i);
        }
    }

    public void printLevel(MyTreeNode root, int level){
        if(level==0){
            System.out.println("TREE IS EMPTY");
            return;
        }
        else if (level==1){
            System.out.print(root.getData()+" ");
        }
        else {
            if(root.getLeft()!=null) {
                printLevel(root.getLeft(), level - 1);
            }
            if(root.getRight()!=null) {
                printLevel(root.getRight(), level - 1);
            }
        }
    }

   /* public void displayTree(MyTreeNode n){
        if(n==null){return;}
        displayTree(n.getLeft());
        System.out.println(n.getData());
        displayTree(n.getRight());
    }*/

    public static void main(String[] args) {
        MyBinarySearchTree obj=new MyBinarySearchTree();
        obj.addNode(100);
        obj.addNode(50);
        obj.addNode(200);
        obj.addNode(25);
        obj.addNode(75);
        obj.addNode(150);
        obj.addNode(250);
        obj.displayTree();
        obj.getSize();
        System.out.println("your height has levels "+obj.calculateHeight());
        obj.removeNode(25);
        obj.displayTree();
        obj.getSize();
    }
}