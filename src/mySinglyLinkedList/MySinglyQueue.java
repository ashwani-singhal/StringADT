package mySinglyLinkedList;
import myNode.MySinglyNodePrimitive;

import java.util.Scanner;

public class MySinglyQueue {
    Scanner s=new Scanner(System.in);
    private MySinglyNodePrimitive front;
    private MySinglyNodePrimitive rear;
    private int size;

    public MySinglyQueue(){
        front=rear=null;
        size=0;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void getSize() {
        System.out.println("ELEMENTS IN QUEUE ARE:"+" "+ size);
    }

    public void enqueue(){
        System.out.println("ENTER THE ELEMENT YOU WANT TO INSERT");
        int data=s.nextInt();
        MySinglyNodePrimitive n = new MySinglyNodePrimitive();
        n.setData(data);
        if(isEmpty()){
            front=rear=n;
            n.setNext(null);
        }
        else{
            rear.setNext(n);
            rear=n;
        }
        size++;
    }

    public void dequeue(){
        if(isEmpty()){
            System.out.println("QUEUE IS EMPTY");
            return;
        }
        else if (size==1){
            front=rear=null;
        }
        else {
            MySinglyNodePrimitive temp = front;
            front=front.getNext();
        }
        size--;
    }

    public void find(){
        System.out.println("ENETR THE ELEMENT TO BE FIND: ");
        int data=s.nextInt();
        MySinglyNodePrimitive temp=front;
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
        MySinglyNodePrimitive temp=front;
        System.out.println("ELEMENTS PRESENT IN THE QUEUE ARE:");
        while (temp!=null){
            System.out.print(temp.getData()+" ");
            temp=temp.getNext();
        }
    }

    public static void main(String[] args) {
        MySinglyQueue objQueue=new MySinglyQueue();
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
        /*objQueue.enqueue(2);
        objQueue.enqueue(4);
        objQueue.enqueue(6);
        objQueue.display();
        objQueue.getSize();
        objQueue.dequeue();
        objQueue.display();
        objQueue.getSize();
        objQueue.find(6);*/

    }
}
