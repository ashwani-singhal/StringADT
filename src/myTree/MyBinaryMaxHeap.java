/*
package myTree;
import myNode.MyTreeNode;

public class MyBinaryMaxHeap {
    MyTreeNode root;
    int size;

    public boolean isEmpty(){
        return root==null;
    }

    public void getSize(){
        System.out.println("YOUR TREE HAS" +size+ " NUMBER OF ELEMENTS");
    }

    public void insertNode(int data){
        MyTreeNode n=new MyTreeNode();
        n.setData(data);
        if(isEmpty()){
            root=n;
        }
        else{
            insertNode(n,root);
        }
        size++;
    }

    private void insertNode(MyTreeNode n, MyTreeNode node){
        if (n.getData()<node.getData() && node.getLeft()==null && node.getRight()==null){
            node.setLeft(n);
        }
        else if (n.getData()<node.getData() && )
    }
}
*/
