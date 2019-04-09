package mySinglyLinkedList;
import myNode.MySinglyNodeNonPrimitive;

import java.util.Scanner;

public class Employee {
    MySinglyNodeNonPrimitive head, tail;
    int size;
    private String name;
    private int salary;
    Scanner s=new Scanner(System.in);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

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

    public void insertAtStart(){
        Employee data=new Employee();
        System.out.println("ENTER THE NAME OF PERSON TO BE INSERT");
        String name=s.nextLine();
        data.setName(name);
        System.out.println("ENTER THE SALARY OF PERSON TO BE INSERT");
        int salary=s.nextInt();
        data.setSalary(salary);
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

    public void insertAtLast(){
        Employee data=new Employee();
        System.out.println("ENTER THE NAME OF PERSON TO BE INSERT");
        String name=s.nextLine();
        data.setName(name);
        System.out.println("ENTER THE SALARY OF PERSON TO BE INSERT");
        int salary=s.nextInt();
        data.setSalary(salary);
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

    public void insertAtAny(){
        System.out.println("ENTER THE POSITION WERE YOU WANT TO INSERT ");
        int position=s.nextInt();
        Employee data=new Employee();
        System.out.println("ENTER THE NAME OF PERSON TO BE INSERT");
        String name=s.nextLine();
        data.setName(name);
        System.out.println("ENTER THE SALARY OF PERSON TO BE INSERT");
        int salary=s.nextInt();
        data.setSalary(salary);
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

    public void deleteAtAny(){
        System.out.println("ENTER THE POSITION AT WHICH YOU WANT TO DELETE ELEMENT");
        int position=s.nextInt();
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
        Employee list=new Employee();
        Scanner s=new Scanner(System.in);
        boolean flag=true;
        while (flag){
            System.out.println("ENTER YOUR CHOICE: \n 1. TO INSERT ELEMENT \n 2. TO DELETE ELEMENT \n 3. TO DISPLAY ELEMENTS \n 4. TO GET NUMBER OF ELEMENTS \n 5. TO CHECK IF LIST IS EMPTY \n 6. TO TERMINATE THE PROGRAM");
            int choice =s.nextInt();
            switch (choice){
                case 1:
                    System.out.println("ENTER YOUR CHOICE: \n 1. TO INSERT AT START \n 2. TO INSERT AT ANY \n 3. TO INSERT AT END");
                    int opt1=s.nextInt();
                    switch (opt1){
                        case 1:
                            System.out.println("ENTER THE NUMBER OF ELEMENTS YOU WANT TO ENTER");
                            int count1=s.nextInt();
                            while(count1!=0){
                                list.insertAtStart();
                                count1--;
                            }
                            break;
                        case 2:
                            System.out.println("ENTER THE NUMBER OF ELEMENTS YOU WANT TO ENTER");
                            int count2=s.nextInt();
                            while(count2!=0){
                                list.insertAtAny();
                                count2--;
                            }
                            break;
                        case 3:
                            System.out.println("ENTER THE NUMBER OF ELEMENTS YOU WANT TO ENTER");
                            int count3=s.nextInt();
                            while(count3!=0){
                                list.insertAtLast();
                                count3--;
                            }
                    }
                    break;
                case 2:
                    System.out.println("ENTER YOUR CHOICE: \n 1. TO DELETE AT START \n 2. TO DELETE AT ANY \n 3. TO DELETE AT END");
                    int opt2=s.nextInt();
                    switch (opt2){
                        case 1:
                            System.out.println("ENTER THE NUMBER OF ELEMENTS YOU WANT TO DELETE");
                            int count1=s.nextInt();
                            while(count1!=0){
                                list.deleteAtStart();
                                count1--;
                            }
                            break;
                        case 2:
                            System.out.println("ENTER THE NUMBER OF ELEMENTS YOU WANT TO DELETE");
                            int count2=s.nextInt();
                            while(count2!=0){
                                list.deleteAtAny();
                                count2--;
                            }
                            break;
                        case 3:
                            System.out.println("ENTER THE NUMBER OF ELEMENTS YOU WANT TO DELETE");
                            int count3=s.nextInt();
                            while(count3!=0){
                                list.deleteAtLast();
                                count3--;
                            }
                    }
                    break;
                case 3: list.display();
                    break;
                case 4: list.getSize();
                    break;
                case 5:
                    System.out.println(list.isEmpty());
                    break;
                case 6: flag=false;
            }
        }
        /*Employee obj1=new Employee("a",1000);
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
        obj.getSize();*/
    }
}