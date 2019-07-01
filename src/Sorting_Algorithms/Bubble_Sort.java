package Sorting_Algorithms;

import java.util.Scanner;

public class Bubble_Sort {

    int[] Sorted_Array(int elements[],int size){
        int flag=0;
        for (int i=0;i<size;i++){
            for (int j=0;j<size-i-1;j++){
                if(elements[j]>elements[j+1]){
                    int temp=elements[j];
                    elements[j]=elements[j+1];
                    elements[j+1]=temp;
                    flag=1;
                }
            }

            // to check if array is sorted in less steps or not(means it is inserted partially sorted
            //System.out.println(flag);


            if(flag==1){
                break;
            }
        }
        return elements;
    }



    public static void main(String[] args) {
        Bubble_Sort object=new Bubble_Sort();
        Scanner scan=new Scanner(System.in);
        try{
            System.out.println("enter the number of elements");
            int n=scan.nextInt();
            System.out.println("enter the "+n+" elements to be sorted");
            int elements[]=new int[n];
            for(int i=0;i<n;i++){
                elements[i]=scan.nextInt();
            }
            int result[]=object.Sorted_Array(elements,n);
            System.out.println("sorted array is:-");
            for(int i=0;i<n;i++){
                System.out.print(result[i]+" ");
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
