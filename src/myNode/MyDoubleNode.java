package myNode;

public class MyDoubleNode {

    private MyDoubleNode previous;
    private MyDoubleNode next;
    private int data;

    public MyDoubleNode(){
        previous=next=null;
        data=0;
    }

    public MyDoubleNode(int data){
        previous=next=null;
        this.data=data;
    }

    public MyDoubleNode(MyDoubleNode previous, MyDoubleNode next, int data){
        this.previous=previous;
        this.next=next;
        this.data=data;
    }

    public MyDoubleNode getPrevious(){
        return previous;
    }

    public MyDoubleNode getNext(){
        return next;
    }

    public int getData(){
        return data;
    }

    public void setPrevious(MyDoubleNode previous){
        this.previous=previous;
    }

    public void setNext(MyDoubleNode next){
        this.next=next;
    }

    public void setData(int data){
        this.data=data;
    }

}
