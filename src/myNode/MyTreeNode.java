package myNode;

public class MyTreeNode {
    private int data;
    private MyTreeNode left,right;

    public MyTreeNode(){
        data=0;
        left=null;
        right=null;
    }

    public MyTreeNode(int data){
        this.data=data;
        left=null;
        right=null;
    }

    public MyTreeNode(int data, MyTreeNode left, MyTreeNode right){
        this.data=data;
        this.left=left;
        this.right=right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public MyTreeNode getLeft() {
        return left;
    }

    public void setLeft(MyTreeNode left) {
        this.left = left;
    }

    public MyTreeNode getRight() {
        return right;
    }

    public void setRight(MyTreeNode right) {
        this.right = right;
    }

}
