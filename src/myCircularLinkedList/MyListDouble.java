package myCircularLinkedList;
import myNode.MyDoubleNode;

public class MyListDouble {
    private MyDoubleNode head,tail;
    private int size;

    public MyListDouble(){
        head=tail=null;
        size=0;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void getSize(){
        System.out.println("LIST IS OF SIZE:"+" "+ size);
    }

    public void insertAtFirst(int data){
        MyDoubleNode n=new MyDoubleNode();
        n.setData(data);
        if(isEmpty()){
            n.setPrevious(null);
            n.setNext(null);
            head=tail=n;
        }
        else {
            n.setPrevious(tail);
            n.setNext(head);
            head=n;
        }
        size++;
    }

    public void insertAtLast(int data){
        MyDoubleNode n= new MyDoubleNode();
        n.setData(data);
        if(isEmpty()){
            insertAtFirst(data);
            return;
        }
        else{
            n.setPrevious(tail);
            n.setNext(head);
            tail.setNext(n);
            head.setPrevious(n);
            tail=n;
        }
        size++;
    }

    public void insertAtAny(int data,int position){
        MyDoubleNode n=new MyDoubleNode();
        n.setData(data);
        if(position<=0 || position>size){
            System.out.println("WRONG POSITION ENTERED");
        }
        else if(isEmpty()){
            insertAtFirst(data);
            return;
        }
        //list start from 1
        else if(position==1){
            insertAtFirst(data);
            return;
        }
        else if (position==size){
            insertAtLast(data);
            return;
        }
        else{
            MyDoubleNode temp=head;
            for(int i=1;i<position-1;i++){
                temp=temp.getNext();
            }
            n.setPrevious(temp);
            n.setNext(temp.getNext());
            temp.getNext().setPrevious(n);
            temp.setNext(n);
        }
        size++;
    }

    public void deleteAtFront(){
        if(isEmpty()){
            System.out.println("LIST IS EMPTY");
            return;
        }
        else if(size==1){
            head=tail=null;
        }
        else{
            tail.setNext(head.getNext());
            head.getNext().setPrevious(tail);
            head=head.getNext();
        }
        size--;
    }

    public void deleteAtEnd(){
        if(isEmpty()){
            deleteAtFront();
            return;
        }
        else if(size==1){
            deleteAtFront();
            return;
        }
        else{
            /*MyDoubleNode temp=head;
            for(int i=1;i<size-1;i++){
                temp=temp.getNext();
            }
            temp.setNext(head);
            head.setPrevious(temp);*/
            MyDoubleNode temp=tail.getPrevious();
            temp.setNext(head);
            head.setPrevious(temp);
            tail=temp;
        }
        size--;
    }

    public void deleteAtAny(int position){
        if(position<=0 || position>size){
            System.out.println("WRONG POSITION ENTERED");
        }
        else if(isEmpty()){
            deleteAtFront();
            return;
        }
        else if(position==1){
            deleteAtFront();
            return;
        }
        else if(position==size){
            deleteAtEnd();
            return;
        }
        else{
            MyDoubleNode temp=head;
            for(int i=1;i<position-1;i++){
                temp=temp.getNext();
            }
            temp.getNext().getNext().setPrevious(temp);
            temp.setNext(temp.getNext().getNext());
        }
        size--;
    }

    public void find(int data){
        MyDoubleNode temp=head;
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

    public void displayList(){
        MyDoubleNode temp=head;
        for(int i=1;i<size;i++){
            System.out.print(temp.getData()+" ");
            temp=temp.getNext();
        }
        System.out.println(tail.getData());
    }

    public static void main(String[] args) {
        MyListDouble list=new MyListDouble();
        list.insertAtFirst(10);
        list.insertAtFirst(5);
        list.insertAtLast(20);
        list.insertAtLast(25);
        list.insertAtAny(15,3);
        list.displayList();
        list.getSize();
        list.deleteAtFront();
        list.deleteAtEnd();
        list.deleteAtAny(2);
        list.displayList();
        list.getSize();
        list.find(20);
    }
}