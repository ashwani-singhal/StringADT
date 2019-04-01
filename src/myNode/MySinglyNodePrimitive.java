package myNode;

public class MySinglyNodePrimitive {

    private MySinglyNodePrimitive next;
    private int data;

    public MySinglyNodePrimitive(){
        next=null;
        data=0;
    }

    public MySinglyNodePrimitive(int data){
        next=null;
        this.data=data;
    }

    public MySinglyNodePrimitive(MySinglyNodePrimitive next, int data) {
        this.next = next;
        this.data = data;
    }

    public MySinglyNodePrimitive getNext(){
        return next;
    }

    public int getData(){
        return data;
    }

    public void setNext(MySinglyNodePrimitive next){
        this.next=next;
    }

    public void setData(int data){
        this.data=data;
    }

}
