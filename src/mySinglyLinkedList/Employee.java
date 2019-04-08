package mySinglyLinkedList;
import myNode.MySinglyNodeNonPrimitive;

public class Employee {
    MySinglyNodeNonPrimitive head, tail;
    int size;
    String name;
    int salary;

    Employee() {
        name = null;
        salary = 0;
    }

    Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void getSize(){
        System.out.println("YOUR LIST IS OF SIZE: "+size);
    }

    public void insertAtStart(Employee data){
        MySinglyNodeNonPrimitive n=new MySinglyNodeNonPrimitive();
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

    public void insertAtLast(Employee data){
        MySinglyNodeNonPrimitive n=new MySinglyNodeNonPrimitive();
        n.setData(data);
        if(isEmpty()){
            insertAtStart(data);
            return;
        }
        else{
            tail.setNext(n);
            tail=n;
        }
        size++;
    }

    public void insertAtAny(Employee data, int position){
        MySinglyNodeNonPrimitive n=new MySinglyNodeNonPrimitive();
        n.setData(data);
        if(isEmpty()){
            insertAtStart(data);
            return;
        }
        else if (position==1){
            insertAtStart(data);
            return;
        }
        else if (position==size+1){
            insertAtLast(data);
            return;
        }
        else if (position==size){
            MySinglyNodeNonPrimitive temp=head;
            if(position==2 && size==2){
                n.setNext(head.getNext());
                head.setNext(n);
            }
            else {
                for (int i = 1; i < position - 1; i++) {
                    temp = temp.getNext();
                }
                n.setNext(temp.getNext());
                temp.setNext(n);
            }
        }
        else{
            MySinglyNodeNonPrimitive temp=head;
            for(int i=1;i<position-1;i++){
                temp=temp.getNext();
            }
            n.setNext(temp.getNext());
            temp.setNext(n);
        }
        size++;
    }

    public void deleteAtStart(){
        if(isEmpty()){
            System.out.println("LIST IS EMPTY");
            return;
        }
        else if (size==1){
            head=tail=null;
        }
        else{
            head=head.getNext();
        }
        size--;
    }

    public void deleteAtLast(){
        if(isEmpty()){
            deleteAtStart();
            return;
        }
        else if (size==1){
            deleteAtStart();
            return;
        }
        else {
            MySinglyNodeNonPrimitive temp = head;
            for (int i = 1; i < size - 1; i++) {
                temp = temp.getNext();
            }
            temp.setNext(null);
            tail = temp;
        }
        size--;
    }

    public void deleteAtAny(int position){
        if(isEmpty()){
            deleteAtStart();
            return;
        }
        else if (size==1){
            deleteAtStart();
            return;
        }
        else if(position==1){
            deleteAtStart();
            return;
        }
        else if (position==2){
            head.setNext(head.getNext().getNext());
        }
        else if (position==size){
            deleteAtLast();
            return;
        }
        else {
            MySinglyNodeNonPrimitive temp = head;
            for (int i = 1; i < position - 1; i++) {
                temp = temp.getNext();
            }
            temp.setNext(temp.getNext().getNext());
        }
        size--;
    }

    public void display(){
        MySinglyNodeNonPrimitive temp=head;
        System.out.println("THE ENTRIES IN THE LIST ARE:-");
        for(int i=1;i<size;i++){
            System.out.println(temp.getData());
            temp=temp.getNext();
        }
        System.out.println(tail.getData());
    }

    public String toString(){
        return ("NAME: "+name+" SALARY: "+salary);
    }

    public static void main(String[] args) {
        Employee obj=new Employee();
        Employee obj1=new Employee("a",1000);
        Employee obj2=new Employee("b",2000);
        Employee obj3=new Employee("c",3000);
        Employee obj4=new Employee("d",4000);
        Employee obj5=new Employee("e",5000);
        obj.insertAtStart(obj1);
        obj.insertAtLast(obj5);
        obj.insertAtAny(obj2,2);
        obj.insertAtAny(obj3,3);
        obj.insertAtAny(obj4,4);
        obj.display();
        obj.getSize();
        obj.deleteAtStart();
        obj.deleteAtLast();
        obj.deleteAtAny(2);
        obj.display();
        obj.getSize();
    }
}