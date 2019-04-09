package myDoublyLinkedList;

import myNode.MyDoubleNode;

import java.util.Scanner;

public class MyList {
    Scanner s=new Scanner(System.in);
    private MyDoubleNode head,tail;
    private int size;

    public MyList(){
        head=tail=null;
        size=0;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void getSize(){
        System.out.println("SIZE OF LIST IS"+" "+ size);
    }

    public void insertAtFirst(){
        System.out.println("ENTER THE ELEMENT YOU WANT INSERT: ");
        int data=s.nextInt();
        MyDoubleNode n= new MyDoubleNode();
        n.setData(data);
        if(isEmpty()){
           /* n.setPrevious(null);
            n.setNext(null);*/
            head=tail=n;
        }
        else {
            n.setNext(head);
            /*n.setPrevious(null);*/
            head.setPrevious(n);
            head=n;
        }
        size++;
    }

    public void insertAtFirst(int data){
        MyDoubleNode n= new MyDoubleNode();
        n.setData(data);
        if(isEmpty()){
           /* n.setPrevious(null);
            n.setNext(null);*/
            head=tail=n;
        }
        else {
            n.setNext(head);
            /*n.setPrevious(null);*/
            head.setPrevious(n);
            head=n;
        }
        size++;
    }

    public void insertAtLast(){
        System.out.println("ENTER THE ELEMENT YOU WANT INSERT: ");
        int data=s.nextInt();
        MyDoubleNode n= new MyDoubleNode();
        n.setData(data);
        if(isEmpty()){
            insertAtFirst(data);
            return;
        }
        else {
            n.setPrevious(tail);
            /*n.setNext(null);*/
            tail.setNext(n);
            tail = n;
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
        else {
            n.setPrevious(tail);
            /*n.setNext(null);*/
            tail.setNext(n);
            tail = n;
        }
        size++;
    }

    public void insertAtAny(){
        System.out.println("ENTER THE ELEMENT YOU WANT INSERT: ");
        int data=s.nextInt();
        System.out.println("ENTER THE POSITION AT WHICH  YOU WANT INSERT: ");
        int position=s.nextInt();
        MyDoubleNode n=new MyDoubleNode();
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
        else {
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

    public void deleteAtFirst(){
        if(isEmpty()){
            System.out.println("LIST IS EMPTY");
            return;
        }
        else if(size==1){
            head=tail=null;
        }
        else {
            head.getNext().setPrevious(null);
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
            /*MyDoubleNode temp=head;
            for(int i=1;i<size-1;i++){
                temp=temp.getNext();
            }
            temp.setNext(null);
            tail=temp;*/
            MyDoubleNode temp=tail.getPrevious();
            temp.setNext(null);
            tail=temp;
        }
        size--;
    }

    public void deleteAtAny(){
        System.out.println("ENTER THE POSITION AT WHICH YOU WANT DELETE: ");
        int position=s.nextInt();
        if(position<=0 || position>size){
            System.out.println("WRONG POSITION ENTERED");
        }
        else if(isEmpty()){
            deleteAtFirst();
            return;
        }
        else if(position==1){
            deleteAtFirst();
            return;
        }
        else if(position == size){
            deleteAtLast();
            return;
        }
        else{
            MyDoubleNode temp=head;
            for(int i=1;i<position-1;i++){
                temp=temp.getNext();
            }
            temp.setNext(temp.getNext().getNext());
            temp.getNext().setPrevious(temp);
        }
        size--;
    }

    public void find(){
        System.out.println("ENTER THE ELEMENT YOU WANT TO FIND: ");
        int data=s.nextInt();
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
        System.out.println("ELEMENTS PRESENT IN LIST ARE: ");
        MyDoubleNode temp=head;
        for(int i=1;i<size;i++){
            System.out.print(temp.getData()+" ");
            temp=temp.getNext();
        }
        System.out.println(tail.getData());
    }

    public static void main(String[] args) {
        MyList list=new MyList();
        Scanner s=new Scanner(System.in);
        boolean flag=true;
        while (flag){
            System.out.println("ENTER YOUR CHOICE: \n 1. TO INSERT ELEMENT \n 2. TO DELETE ELEMENT \n 3. TO DISPLAY ELEMENTS \n 4. TO GET NUMBER OF ELEMENTS \n 5. TO FIND IF AN ELEMENT IS PRESENT OR NOT \n 6. TO CHECK IF LIST IS EMPTY \n 7. TO TERMINATE THE PROGRAM");
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
                                list.insertAtFirst();
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
                                list.deleteAtFirst();
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
                case 3: list.displayList();
                    break;
                case 4: list.getSize();
                    break;
                case 5: list.find();
                    break;
                case 6:
                    System.out.println(list.isEmpty());
                    break;
                case 7: flag=false;
            }
        }
        /*list.insertAtFirst(10);
        list.insertAtFirst(5);
        list.insertAtLast(20);
        list.insertAtLast(25);
        list.insertAtAny(15,2);
        list.displayList();
        list.getSize();
        list.deleteAtFirst();
        list.deleteAtLast();
        list.deleteAtAny(2);
        list.displayList();
        list.getSize();
        list.find(20);*/
    }
}
