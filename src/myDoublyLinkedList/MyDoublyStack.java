package myDoublyLinkedList;
import myNode.MyDoubleNode;

import java.util.Scanner;

public class MyDoublyStack {
    Scanner s=new Scanner(System.in);
    private MyDoubleNode top;
    private int size;

    public MyDoublyStack(){
        top=null;
        size=0;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void getSize(){
        System.out.println();
        System.out.println("YOUR STACK IS OF SIZE:"+" "+size);
    }

    public void push(){
        System.out.println("ENTER THE ELEMENT YOU WANT TO INSERT: ");
        int data=s.nextInt();
        MyDoubleNode n=new MyDoubleNode();
        n.setData(data);
        if(isEmpty()){
            top=n;
            n.setPrevious(null);
            n.setNext(null);
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
        else{
            top=top.getNext();
            top.setPrevious(null);
        }
        size--;
    }

    public void find(){
        System.out.println("ENTER THE ELEMENT YOU WANT TO FIND");
        int data=s.nextInt();
        MyDoubleNode temp=top;
        boolean temp1=false;
        for(int i=0;i<size;i++){
            if(temp.getData()==data){
                temp1=true;
                break;
            }
            temp=temp.getNext();
        }
        if(temp1) {
            System.out.println("SORRY! , ELEMENT IS NOT FOUND");
        }
        else{
            System.out.println("SORRY! , ELEMENT IS NOT FOUND");
        }
    }

    public void display(){
        System.out.println("ELEMENTS PRESENT IN THE STACK ARE: ");
        MyDoubleNode temp=top;
        for(int i=0;i<size;i++){
            System.out.print(temp.getData()+" ");
            temp=temp.getNext();
        }
    }

    public static void main(String[] args) {
        MyDoublyStack objstack=new MyDoublyStack();
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
                        objstack.push();
                        count1--;
                    }
                    break;
                case 2:
                    System.out.println("ENTER THE NUMBER OF ELEMENTS YOU WANT TO DELETE");
                    int count2=s.nextInt();
                    while(count2!=0){
                        objstack.pop();
                        count2--;
                    }
                    break;
                case 3: objstack.display();
                    break;
                case 4: objstack.getSize();
                    break;
                case 5: objstack.find();
                    break;
                case 6:
                    System.out.println(objstack.isEmpty());
                    break;
                case 7: flag=false;
            }
        }
        /*list.push(5);
        list.push(10);
        list.push(15);
        list.push(20);
        list.push(25);
        list.display();
        list.getSize();
        list.pop();
        list.pop();
        list.display();
        list.getSize();
        list.find(5);*/
    }
}
