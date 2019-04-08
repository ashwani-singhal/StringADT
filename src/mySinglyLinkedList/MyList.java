package mySinglyLinkedList;

import myNode.MySinglyNodePrimitive;

public class MyList {
    private MySinglyNodePrimitive head,tail;
    private int size;

    public MyList(){
        head=tail=null;
        size=0;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void getSize(){
        System.out.println();
        System.out.println("LIST IS OF LENGTH"+" "+ size);
    }

    public void insertAtFirst(int data){
        MySinglyNodePrimitive n= new MySinglyNodePrimitive();
        n.setData(data);
        if(isEmpty()){
            head=tail=n;
            /*n.setNext(null);*/
        }
        else{
            n.setNext(head);
            head=n;
        }
        size++;
    }

    public void insertAtLast(int data){
        MySinglyNodePrimitive n= new MySinglyNodePrimitive();
        n.setData(data);
        if(isEmpty()){
            insertAtFirst(data);
            return;
        }
        else{
            /*n.setNext(null);*/
            tail.setNext(n);
            tail=n;
        }
        size++;
    }

    public void insertAtAny(int data, int position){
        MySinglyNodePrimitive n= new MySinglyNodePrimitive();
        n.setData(data);
        if(position<=0 || position>size){
            System.out.println("INVALID POSITION");
        }
        else if(isEmpty()){
            insertAtFirst(data);
            return;
        }
        else if(position==size){
            insertAtLast(data);
            return;
        }
        else{
            MySinglyNodePrimitive temp=head;
            for(int i=1;i<position-1;i++) {
                temp = temp.getNext();
            }
                n.setNext(temp.getNext());
                temp.setNext(n);
            }
            size++;
        }

    public void deleteAtFirst(){
        if(isEmpty()){
            System.out.println("LIST IS EMPTY");
            return;
        }
        else if(size==1){
            head=tail=null;
        }
        else{
            head=head.getNext();
        }
        size--;
    }

    public void deleteAtLast(){
        if(isEmpty()){
            deleteAtFirst();
            return;
        }
        else if(size==1){
            deleteAtFirst();
            return;
        }
        else{
            MySinglyNodePrimitive temp=head;
            for(int i=1;i<size-1;i++){
                temp=temp.getNext();
            }
            tail=temp;
            tail.setNext(null);
        }
        size--;
    }

    public void deleteAtAny(int position){
        if(position<=0 || position>size){
            System.out.println("WRONG POSITION ENTERED");
        }
        else if(isEmpty()){
            deleteAtFirst();
            return;
        }
        else if (position==1){
            deleteAtFirst();
            return;
        }
        else if(position==size){
            deleteAtLast();
            return;
        }
        else {
            MySinglyNodePrimitive temp=head;
            for (int i = 1; i < position - 1; i++) {
                temp = temp.getNext();
            }
            temp.setNext(temp.getNext().getNext());
        }
        size--;
    }

    public void find(int data){
        MySinglyNodePrimitive temp=head;
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
        MySinglyNodePrimitive temp=head;
        while (temp.getNext()!=null){
            System.out.print(temp.getData()+" ");
            temp=temp.getNext();
        }
        System.out.println(tail.getData());
    }

    public static void main(String[] args) {
        MyList list=new MyList();
        list.insertAtFirst(10);
        list.insertAtFirst(5);
        list.insertAtLast(15);
        list.insertAtLast(25);
        list.insertAtAny(20,3);
        list.displayList();
        list.getSize();
        list.deleteAtFirst();
        list.displayList();
        list.getSize();
        list.deleteAtLast();
        list.displayList();
        list.getSize();
        list.deleteAtAny(2);
        list.displayList();
        list.getSize();
        list.find(25);
    }
}
