package myNode;
import mySinglyLinkedList.Employee;

public class MySinglyNodeNonPrimitive {
    private MySinglyNodeNonPrimitive next;
    private Employee data;

    public MySinglyNodeNonPrimitive(){
        Employee data=null;
        next=null;
    }

    public MySinglyNodeNonPrimitive getNext() {
        return next;
    }

    public void setNext(MySinglyNodeNonPrimitive next) {
        this.next = next;
    }

    public Employee getData() {
        return data;
    }

    public void setData(Employee data) {
        this.data = data;
    }
}
