package myCircularLinkedList;
import myNode.MyDoubleNode;

import java.util.Scanner;

public class MyCircularQueueDouble {
    private MyDoubleNode front;
    private int size;
    Scanner s=new Scanner(System.in);

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

    public void enqueue(){
        System.out.println("ENTER THE ELEMENT YOU WANT TO INSERT");
        int data=s.nextInt();
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

    public void find(){
        System.out.println("ENETR THE ELEMENT TO BE FIND: ");
        int data=s.nextInt();
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
        System.out.println("ELEMENTS PRESENT IN THE QUEUE ARE:");
        MyDoubleNode temp=front;
        for(int i=0;i<size;i++){
            System.out.print(temp.getData()+" ");
            temp=temp.getNext();
        }
    }

    public static void main(String[] args) {
        MyCircularQueueDouble objQueue=new MyCircularQueueDouble();
        Scanner s=new Scanner(System.in);
        boolean flag=true;
        while (flag){
            System.out.println("ENTER YOUR CHOICE: \n 1. TO INSERT ELEMENT \n 2. TO DELETE ELEMENT \n 3. TO DISPLAY ELEMENTS \n 4. TO GET NUMBER OF ELEMENTS \n 5. TO FIND IF AN ELEMENT IS PRESENT OR NOT \n 6. TO CHECK IF LIST IS EMPTY \n 7. TO TERMINATE THE PROGRAM");
            int choice =s.nextInt();
            switch (choice){
                case 1:
                    System.out.println("ENTER THE NUMBER OF ELEMENTS YOU WANT TO ENTER");
                    int count1=s.nextInt();
                    while(count1!=0){
                        objQueue.enqueue();
                        count1--;
                    }
                    break;
                case 2:
                    System.out.println("ENTER THE NUMBER OF ELEMENTS YOU WANT TO DELETE");
                    int count2=s.nextInt();
                    while(count2!=0){
                        objQueue.dequeue();
                        count2--;
                    }
                    break;
                case 3: objQueue.display();
                    break;
                case 4: objQueue.getSize();
                    break;
                case 5: objQueue.find();
                    break;
                case 6:
                    System.out.println(objQueue.isEmpty());
                    break;
                case 7: flag=false;
            }
        }
        /*list.enqueue(5);
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
        list.find(25);*/
    }
}
