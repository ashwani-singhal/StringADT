package myDoublyLinkedList;
import myNode.MyDoubleNode;

public class MyDoublyStack {
    private MyDoubleNode top;
    private int size;

    public MyDoublyStack(){
        top=null;
        size=0;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void getSize(){
        System.out.println();
        System.out.println("YOUR STACK IS OF SIZE:"+" "+size);
    }

    public void push(int data){
        MyDoubleNode n=new MyDoubleNode();
        n.setData(data);
        if(isEmpty()){
            top=n;
            n.setPrevious(null);
            n.setNext(null);
        }
        else{
            n.setNext(top);
            top=n;
        }
        size++;
    }

    public void pop(){
        if(isEmpty()){
            System.out.println("STACK IS EMPTY");
            return;
        }
        else if(size==1){
            top=null;
        }
        else{
            top=top.getNext();
            top.setPrevious(null);
        }
        size--;
    }

    public void find(int data){
        MyDoubleNode temp=top;
        boolean temp1=false;
        for(int i=0;i<size;i++){
            if(temp.getData()==data){
                temp1=true;
                break;
            }
            temp=temp.getNext();
        }
        if(temp1) {
            System.out.println("ELEMENT IS FOUND");
        }
        else{
            System.out.println("SORRY! , ELEMENT IS NOT FOUND");
        }
    }

    public void display(){
        MyDoubleNode temp=top;
        for(int i=0;i<size;i++){
            System.out.print(temp.getData()+" ");
            temp=temp.getNext();
        }
    }

    public static void main(String[] args) {
        MyDoublyStack list=new MyDoublyStack();
        list.push(5);
        list.push(10);
        list.push(15);
        list.push(20);
        list.push(25);
        list.display();
        list.getSize();
        list.pop();
        list.pop();
        list.display();
        list.getSize();
        list.find(5);
    }
}
