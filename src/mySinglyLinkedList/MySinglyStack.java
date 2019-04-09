package mySinglyLinkedList;
import myNode.MySinglyNodePrimitive;

import java.util.Scanner;

public class MySinglyStack {
    Scanner s=new Scanner(System.in);
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

    public void push(){
        System.out.println("ENTER THE ELEMENT YOU WANT TO INSERT: ");
        int data=s.nextInt();
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

    public void find(){
        System.out.println("ENTER THE ELEMENT YOU WANT TO FIND");
        int data=s.nextInt();
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
        System.out.println("ELEMENTS PRESENT IN THE STACK ARE: ");
        for(int i=1;i<=size;i++){
            System.out.print(temp.getData()+" ");
            temp=temp.getNext();
        }
    }

    public static void main(String[] args) {
        MySinglyStack objstack = new MySinglyStack();
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
                case 3: objstack.displayStack();
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
       /* objstack.push(2);
        objstack.push(4);
        objstack.push(6);
        objstack.displayStack();
        objstack.getSize();
        objstack.pop();
        objstack.displayStack();
        objstack.getSize();
        objstack.find(2);*/
    }
}
