
package myDoublyLinkedList;
import myNode.MyDoubleNode;

public class MyDoubleQueue {
    private MyDoubleNode front, rear;
    private int size;

    public MyDoubleQueue() {
        front = rear = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void getSize() {
        System.out.println("ELEMENTS IN QUEUE ARE:" + " " + size);
    }

    public void enqueue(int data) {
        MyDoubleNode n = new MyDoubleNode();
        n.setData(data);
        if (isEmpty()) {
            front = rear = n;
            n.setPrevious(null);
            n.setNext(null);
        } else {
            n.setPrevious(rear);
            n.setNext(null);
            rear.setNext(n);
            rear = n;
        }
        size++;
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("QUEUE IS EMPTY");
            return;
        } else if (size == 1) {
            front = rear = null;
        } else {
            front.getNext().setPrevious(null);
            front = front.getNext();
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
            System.out.println("SORRY! ELEMENT IS NOT FOUND");
        }
    }

    public void display() {
        MyDoubleNode temp = front;
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }

    public static void main(String[] args) {
        MyDoubleQueue objQueue = new MyDoubleQueue();
        objQueue.enqueue(2);
        objQueue.enqueue(4);
        objQueue.enqueue(6);
        objQueue.display();
        objQueue.getSize();
        objQueue.dequeue();
        objQueue.display();
        objQueue.getSize();
        objQueue.find(6);
    }
}