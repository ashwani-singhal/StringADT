package myCircularLinkedList;

import myNode.MySinglyNodePrimitive;

import java.util.Scanner;

public class MyListLinear {
        Scanner s=new Scanner(System.in);
        private MySinglyNodePrimitive head,tail;
        private int size;

        public MyListLinear(){
            head=tail=null;
            size=0;
        }

        public boolean isEmpty(){
            return size==0;
        }

        public void getSize(){
            System.out.println("SIZE OF LIST IS:"+" "+size);
        }

        public void insertAtFirst(){
            System.out.println("ENTER THE DATA TO BE INSERT");
            int data = s.nextInt();
            MySinglyNodePrimitive n= new MySinglyNodePrimitive();
            n.setData(data);
            if(isEmpty()){
                head=tail=n;
                /*n.setNext(null);*/
            }
            else{
                n.setNext(head);
                tail.setNext(n);
                head=n;
            }
            size++;
        }

        public void insertAtFirst(int data){
            MySinglyNodePrimitive n= new MySinglyNodePrimitive();
            n.setData(data);
            if(isEmpty()){
                head=tail=n;
                /*n.setNext(null);*/
            }
            else{
                n.setNext(head);
                tail.setNext(n);
                head=n;
            }
            size++;
        }

        public void insertAtLast(){
            System.out.println("ENTER THE DATA TO BE INSERT");
            int data=s.nextInt();
            MySinglyNodePrimitive n= new MySinglyNodePrimitive();
            n.setData(data);
            if(isEmpty()){
                insertAtFirst(data);
                return;
            }
            else{
                n.setNext(head);
                tail.setNext(n);
                tail=n;
            }
            size++;
        }

        public void insertAtLast(int data){
            MySinglyNodePrimitive n= new MySinglyNodePrimitive();
            n.setData(data);
            if(isEmpty()){
                insertAtFirst(data);
                return;
            }
            else{
                n.setNext(head);
                tail.setNext(n);
                tail=n;
            }
            size++;
        }

        public void insertAtAny(){
            System.out.println("ENTER THE DATA TO BE INSERT");
            int data=s.nextInt();
            System.out.println("ENTER THE POSITION AT WHICH DATA TO BE INSERT");
            int position=s.nextInt();
            MySinglyNodePrimitive n= new MySinglyNodePrimitive();
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
            else{
                MySinglyNodePrimitive temp=head;
                for(int i=1;i<position-1;i++){
                    temp=temp.getNext();
                }
                n.setNext(temp.getNext());
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
                tail.setNext(head.getNext());
                head=head.getNext();
            }
            size--;
        }

        public void deleteAtLast(){
            if(isEmpty()){
                deleteAtFirst();
                return;
            }
            else if (size==1){
                deleteAtFirst();
                return;
            }
            else {
                MySinglyNodePrimitive temp=head;
                for(int i=1;i<size-1;i++){
                    temp=temp.getNext();
                }
                temp.setNext(head);
                tail=temp;
            }
            size--;
        }

        public void deleteAtAny(){
            System.out.println("ENTER THE POSITION AT WHICH YOU WANT TO DELETE ELEMENT");
            int position=s.nextInt();
            if(position<=0 || position>size){
                System.out.println("WRONG POSITION ENTERED");
            }
            else if(isEmpty()){
                deleteAtFirst();
                return;
            }
            else if (position==1){
                deleteAtFirst();
                return;
            }
            else if (position==size){
                deleteAtLast();
                return;
            }
            else{
                MySinglyNodePrimitive temp=head;
                for(int i=1;i<position-1;i++){
                    temp=temp.getNext();
                }
                temp.setNext(temp.getNext().getNext());
            }
            size--;
        }

    public void find(){
        System.out.println("ENTER THE DATA TO BE FIND");
        int data=s.nextInt();
        MySinglyNodePrimitive temp=head;
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
            System.out.println("THE ELEMENTS PRESENT IN THE LIST ARE: ");
            MySinglyNodePrimitive temp=head;
            for(int i=1;i<size;i++){
                System.out.print(temp.getData()+" ");
                temp=temp.getNext();
            }
            System.out.println(tail.getData());
        }

    public static void main(String[] args) {
        MyListLinear list=new MyListLinear();
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

       /* list.insertAtFirst(10);
        list.insertAtFirst(5);
        list.insertAtLast(20);
        list.insertAtLast(25);
        list.insertAtAny(15,3);
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
