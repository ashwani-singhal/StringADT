package mySinglyLinkedList;
import myNode.MySinglyNodePrimitive;

public class MySinglyStack {
    private MySinglyNodePrimitive top;
    private int size;

    public MySinglyStack(){
        top=null;
        size=0;
    }

    public boolean isEmpty(){
        return top==null;
    }

    public void getSize(){
        System.out.println("STACK IS OF SIZE:"+" "+ size);
    }

    public void push(int data){
        MySinglyNodePrimitive n=new MySinglyNodePrimitive();
        n.setData(data);
        if(isEmpty()){
            n.setNext(null);
            top=n;
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
        else {
            top=top.getNext();
        }
        size--;
    }

    public void find(int data){
        MySinglyNodePrimitive temp=top;
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

    public void displayStack(){
        MySinglyNodePrimitive temp=top;
        for(int i=1;i<=size;i++){
            System.out.println(temp.getData());
            temp=temp.getNext();
        }
    }

    public static void main(String[] args) {
        MySinglyStack objstack = new MySinglyStack();
        objstack.push(2);
        objstack.push(4);
        objstack.push(6);
        objstack.displayStack();
        objstack.getSize();
        objstack.pop();
        objstack.displayStack();
        objstack.getSize();
        objstack.find(2);
    }
}
