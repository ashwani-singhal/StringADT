package myCircularLinkedList;
import myNode.MyDoubleNode;

public class MyCircularQueueDouble {
    private MyDoubleNode front;
    private int size;

    public MyCircularQueueDouble(){
        front=null;
        size=0;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void getSize(){
        System.out.println("YOUR QUEUE IS OF SIZE:"+" "+size);
    }

    public void enqueue(int data){
        MyDoubleNode n=new MyDoubleNode();
        n.setData(data);
        if(isEmpty()){
            front=n;
            /*n.setPrevious(null);
            n.setNext(null);*/
        }
        else if(size==1) {
            front.setNext(n);
            n.setPrevious(front);
            n.setNext(front);
            front.setPrevious(n);
        }
        else{
            MyDoubleNode temp=front;
            for(int i=1;i<size;i++){
                temp=temp.getNext();
            }
            temp.setNext(n);
            n.setPrevious(temp);
            n.setNext(front);
        }
        size++;
    }

    public void dequeue(){
        if(isEmpty()){
            System.out.println("QUEUE IS EMPTY");
            return;
        }
        else if (size==1){
            front=null;
        }
        else{
            MyDoubleNode temp=front;
            for(int i=1;i<size;i++){
                temp=temp.getNext();
            }
            front=front.getNext();
            front.setPrevious(temp);
            temp.setNext(front);
        }
        size--;
    }

    public void find(int data){
        MyDoubleNode temp=front;
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
        MyDoubleNode temp=front;
        for(int i=0;i<size;i++){
            System.out.println(temp.getData());
            temp=temp.getNext();
        }
    }

    public static void main(String[] args) {
        MyCircularQueueDouble list=new MyCircularQueueDouble();
        list.enqueue(5);
        list.enqueue(10);
        list.enqueue(15);
        list.enqueue(20);
        list.enqueue(25);
        list.display();
        list.getSize();
        list.dequeue();
        list.dequeue();
        list.display();
        list.getSize();
        list.find(25);
    }
}
